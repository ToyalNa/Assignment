package com.example.recycler_splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int []arr_std = {R.drawable.vt,R.drawable.vn,R.drawable.vnb,R.drawable.mb};
    List<Phone> StdList;
    String [] name;
    String [] phone;


    private RecyclerView rcv_std;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StdList = new ArrayList<>();
        name = getResources().getStringArray(R.array.name);
        phone = getResources().getStringArray(R.array.phone);
        for (int i = 0; i < name.length;i++){
            Phone std = new Phone(arr_std[i],name[i],phone[i]);
            StdList.add(std);
        }

        rcv_std = findViewById(R.id.rv_student);
        rcv_std.setHasFixedSize(true);
        rcv_std.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(StdList);
        rcv_std.setAdapter(adapter);
    }
}