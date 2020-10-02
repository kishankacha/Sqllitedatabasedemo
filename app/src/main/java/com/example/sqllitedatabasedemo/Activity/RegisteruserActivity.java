package com.example.sqllitedatabasedemo.Activity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.R;
import com.example.sqllitedatabasedemo.helper.DatabaseOperations;
import com.google.android.material.textfield.TextInputEditText;

public class RegisteruserActivity extends AppCompatActivity {

    TextInputEditText  USER_PASS,USER_NAME,CONFO_PASS;
    Button register;
    String user_name,user_pass,confo_pass;
    Context ctx=this;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        USER_NAME=findViewById(R.id.user_name);
        USER_PASS=findViewById(R.id.user_pass);
        register=findViewById(R.id.register);
        CONFO_PASS=findViewById(R.id.confo_pass);
        title=findViewById(R.id.title);

        title.setText("Register");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user_name=USER_NAME.getText().toString();
                user_pass=USER_PASS.getText().toString();
                confo_pass=CONFO_PASS.getText().toString();

                if(!(user_pass.equals(confo_pass))){

                    Toast.makeText(RegisteruserActivity.this, "Password are not matching ", Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CONFO_PASS.setText("");

                }
                else
                {
                    DatabaseOperations DB=new DatabaseOperations(ctx);
                    DB.putInformation(DB,user_name,user_pass);
                    Toast.makeText(getBaseContext(), "Registration Success ", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
}
