package com.example.sqllitedatabasedemo.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.R;
import com.example.sqllitedatabasedemo.helper.BackgroundTask;

public class DisplayProductActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product_layout);
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("get_info");

    }
}
