package com.example.intent_basic_ltqv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {
    TextView tVIntent;
    EditText edtRepMain;
    Button clickRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        tVIntent = findViewById(R.id.tv_CommentIntent);
        edtRepMain = findViewById(R.id.edtRepMain);
        clickRep = findViewById(R.id.repMain);

        //Nhận dữ liệu từ main
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("intent_key");
        tVIntent.setText(value1);

        clickRep.setOnClickListener(view -> {

            String s = edtRepMain.getText().toString();

            //Truyền chuỗi s từ intent sang main
            Intent intent1 = new Intent(IntentActivity.this, MainActivity.class);
            intent1.putExtra("intent_key_rep", s);
            startActivity(intent1);
            finish();
        });
    }
}