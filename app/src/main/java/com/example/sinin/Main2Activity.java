package com.example.sinin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText tv_name,tv_email,tv_password;
    RadioGroup G_gender;
    String gender="male";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_name=findViewById(R.id.editText);
        tv_email=findViewById(R.id.editText2);
        tv_password=findViewById(R.id.editText3);
        G_gender=findViewById(R.id.Gender);
        G_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.female:
                        gender="female";
                        break;
                    case R.id.male:
                        gender="male";
                }
            }
        });

    }

    public void sinin(View view) {
        if (!tv_name.getText().toString().equals("")&&!tv_email.getText().toString().equals("")&&
               !tv_password.getText().toString().equals("")){

            int name=tv_name.getText().toString().length();
            int password=tv_password.getText().toString().length();

            if (name>5&&password>8)
            {
                intent();
            }
            else if (name>5&&!(password>8))
            {
                Toast.makeText(this, "Your Password > 8 ", Toast.LENGTH_SHORT).show();
            }
            else if (password>8&&!(name>5))
            {
                Toast.makeText(this, "Your name > 5 ", Toast.LENGTH_SHORT).show();
            }
            else if(name<5){
                Toast.makeText(this, "Your name > 5 ", Toast.LENGTH_SHORT).show();
            }
            else if(password<8){
                Toast.makeText(this, "Your Password > 8 ", Toast.LENGTH_SHORT).show();
            }

        }
        else if (tv_name.getText().toString().equals("")&&tv_email.getText().toString().equals("")&&
                tv_password.getText().toString().equals("")){
            AlertDialog("Pleas Enter Your Date");
        }
       else if (tv_name.getText().toString().equals("")){
           AlertDialog("Pleas Enter Your Name");

        }
       else if (tv_email.getText().toString().equals("")){
           AlertDialog("Pleas Enter Your email");
       }
       else if (tv_password.getText().toString().equals("")){
           AlertDialog("Pleas Enter Your Password");
       }
    }
    public void AlertDialog(String error){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage(error);
        builder.setIcon(R.drawable.ic_sentiment);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
        builder.setCancelable(false);

    }
    public  void intent(){
        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra("name",tv_name.getText().toString());
        intent.putExtra("email",tv_email.getText().toString());
        intent.putExtra("password",tv_password.getText().toString());
        intent.putExtra("gender",gender);
        startActivity(intent);
    }
}
