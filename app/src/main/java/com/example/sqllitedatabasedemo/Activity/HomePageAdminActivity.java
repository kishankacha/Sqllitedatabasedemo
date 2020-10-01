package com.example.sqllitedatabasedemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.R;

public class HomePageAdminActivity extends AppCompatActivity {

    Button addproduct,viewproduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        addproduct=findViewById(R.id.addproduct);
        viewproduct=findViewById(R.id.viewproduct);
        addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomePageAdminActivity.this, AddProductActivity.class);
                startActivity(intent);
                finish();
            }
        });
        viewproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomePageAdminActivity.this, DisplayProductActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
