package com.example.sqllitedatabasedemo.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.helper.DatabaseOperations;
import com.example.sqllitedatabasedemo.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity  extends AppCompatActivity {

    TextView register;
    TextInputEditText USERPASSWORD,USERNAME;
    String username,userpass;
    Button login;
    Context CTX=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register=findViewById(R.id.register);
        USERNAME=findViewById(R.id.USERNAME);
        USERPASSWORD=findViewById(R.id.USERPASSWORD);
        login=findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this, RegisteruserActivity.class);
                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username=USERNAME.getText().toString();
                userpass=USERPASSWORD.getText().toString();
                DatabaseOperations DOP=new DatabaseOperations(CTX);
                Cursor CR=DOP.getInformation(DOP);
                CR.moveToFirst();
                boolean longstatus=false;
                String Name="";
                do {
                    if(username.equals(CR.getString(0)) && (userpass.equals(CR.getString(1))))
                    {

                        longstatus=true;
                        Name=CR.getString(0);
                    }

                    }
                    while (CR.moveToNext()) ;

                    if (longstatus)
                    {
                        Toast.makeText(getBaseContext(), "Login Success "+Name, Toast.LENGTH_SHORT).show();
                        if (Name.equals("admin"))
                        {
                            Intent intent=new Intent(LoginActivity.this, HomePageAdminActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            Intent intent=new Intent(LoginActivity.this, HomepageActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "Login failed ", Toast.LENGTH_SHORT).show();
                        finish();
                    }

            }
        });
    }
}