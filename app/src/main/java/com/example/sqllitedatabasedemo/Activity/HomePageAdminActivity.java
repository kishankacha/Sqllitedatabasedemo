package com.example.sqllitedatabasedemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.R;

public class HomePageAdminActivity extends AppCompatActivity {

    Button addproduct,viewproduct,deleteproduct,updateproduct;
    ImageView back;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        addproduct=findViewById(R.id.addproduct);
        viewproduct=findViewById(R.id.viewproduct);
        deleteproduct=findViewById(R.id.deleteproduct);
        updateproduct=findViewById(R.id.updateproduct);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        back.setVisibility(View.GONE);
        title.setText("HOME PAGE");

        addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomePageAdminActivity.this, AddProductActivity.class);
                startActivity(intent);

            }
        });
        viewproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomePageAdminActivity.this, DisplayProductActivity.class);
                startActivity(intent);

            }
        });
        deleteproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomePageAdminActivity.this, DeleteProductActivity.class);
                startActivity(intent);

            }
        });
        updateproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePageAdminActivity.this, UpdateProductActivity.class);
                startActivity(intent);

            }
        });
    }
}
