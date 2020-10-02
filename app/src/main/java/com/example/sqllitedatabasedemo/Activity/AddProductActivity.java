package com.example.sqllitedatabasedemo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.helper.BackgroundTask;
import com.example.sqllitedatabasedemo.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddProductActivity extends AppCompatActivity {

    TextInputEditText e_id,p_name,p_price,p_qty;
    String id,name,price,qty;
    Button add_product;
    TextView title;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproduct);
        p_name=findViewById(R.id.p_name);
        e_id=findViewById(R.id.p_id);
        p_price=findViewById(R.id.p_price);
        p_qty=findViewById(R.id.p_qty);
        add_product=findViewById(R.id.add_product);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        title.setText("ADD PRODUCT");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                id=e_id.getText().toString();
                name=p_name.getText().toString();
                qty=p_qty.getText().toString();
                price=p_price.getText().toString();

                BackgroundTask backgroundTask=new BackgroundTask(AddProductActivity.this);
                backgroundTask .execute("add_info",id,name,price,qty);
                Intent intent=new Intent(AddProductActivity.this, HomePageAdminActivity.class);
                startActivity(intent);
              //  finish();

            }
        });

    }
}
