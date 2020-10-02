package com.example.sqllitedatabasedemo.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.R;
import com.example.sqllitedatabasedemo.helper.BackgroundTask;

public class DisplayProductActivity extends AppCompatActivity
{

    ImageView back;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product_layout);

        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("get_info");

        back=findViewById(R.id.back);
        title=findViewById(R.id.title);
        title.setText("All Product");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }
}
