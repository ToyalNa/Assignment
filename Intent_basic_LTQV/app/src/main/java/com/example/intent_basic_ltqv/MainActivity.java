package com.example.intent_basic_ltqv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnClickIntent, btnTrinhduyet, btnPhone,btCamera,btSMS;
    EditText edtComment, edtPhone,edtSearch;
    TextView tvRepIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        onClick();
        rep_intent();

    }

    public void init() {
        btnClickIntent = findViewById(R.id.click);
        btnTrinhduyet = findViewById(R.id.btTrinhduyet);
        btnPhone = findViewById(R.id.btPhone);
        btCamera = findViewById(R.id.btCamera);
        btSMS = findViewById(R.id.btSMS);

        edtComment = findViewById(R.id.tV_comment);
        edtPhone = findViewById(R.id.tV_Phone);
        edtSearch = findViewById(R.id.edtSearch);

        tvRepIntent = findViewById(R.id.tV_repIntent);
    }

    public void onClick() {
        btnClickIntent.setOnClickListener(view -> {

            String s = edtComment.getText().toString();

            //Truyền dữ liệu từ main sang intent
            Intent intent1 = new Intent(MainActivity.this, IntentActivity.class);
            intent1.putExtra("intent_key", s);
            startActivity(intent1);
            finish();
        });
        btnTrinhduyet.setOnClickListener(view -> {
            String url = edtSearch.getText().toString();
            Intent intentURL = new Intent(Intent.ACTION_VIEW);
            intentURL.setData(Uri.parse("https://www." + url + ".com"));

            startActivity(intentURL);
            finish();

        });
        btnPhone.setOnClickListener(view -> {
            String phone = edtPhone.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + phone));
            startActivity(callIntent);
            finish();

        });
        btCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCamera = new Intent(MainActivity.this,CameraActivity.class);
                startActivity(intentCamera);
                finish();
            }
        });
        btSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCamera = new Intent(MainActivity.this,SMSActivity.class);
                startActivity(intentCamera);
                finish();
            }
        });
    }

    public void rep_intent() {

        //Nhận dữ liệu từ intent
        Intent intent = getIntent();
        String value1 = intent.getStringExtra("intent_key_rep");
        tvRepIntent.setText(value1);
    }
}