package com.example.firebase_todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;

    Adapter adapter;
    boolean isLoading=false;
    String key =null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_name = findViewById(R.id.edt_name);
        final EditText edt_msv = findViewById(R.id.edt_msv);
        Button btn_add = findViewById(R.id.btn_add);
        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, RvStudent.class);
            startActivity(intent);
        });
        DAOStudent dao = new DAOStudent();
        Student emp_edit = (Student) getIntent().getSerializableExtra("EDIT");
        if (emp_edit != null) {
            btn_add.setText("UPDATE");
            edit_name.setText(emp_edit.getName());
            edt_msv.setText(emp_edit.getMsv());
            btn_open.setVisibility(View.GONE);
        } else {
            btn_add.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);
        }
        btn_add.setOnClickListener(v ->
        {
            Student emp = new Student(edit_name.getText().toString(), edt_msv.getText().toString());
            if (emp_edit == null) {
                dao.add(emp).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er ->
                {
//                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            } else {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", edit_name.getText().toString());
                hashMap.put("msv", edt_msv.getText().toString());
                dao.update(emp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
            adapter.notifyDataSetChanged();
        });
    }
}