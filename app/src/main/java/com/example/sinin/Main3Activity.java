package com.example.sinin;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView tv_name,tv_email,tv_password,tv_gender;
    String name,email,password,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv_name=findViewById(R.id.Text);
        tv_email=findViewById(R.id.Text2);
        tv_password=findViewById(R.id.Text3);
        tv_gender=findViewById(R.id.gender);
        Intent intent =getIntent();
        name=intent.getStringExtra("name");
        email=intent.getStringExtra("email");
        password=intent.getStringExtra("password");
        gender=intent.getStringExtra("gender");
        tv_name.setText(name);
        tv_email.setText(email);
        tv_password.setText(password);
        tv_gender.setText(gender);

    }
}
