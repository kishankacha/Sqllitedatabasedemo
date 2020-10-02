package com.example.sqllitedatabasedemo.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllitedatabasedemo.R;
import com.example.sqllitedatabasedemo.helper.DatabaseOperations;
import com.google.android.material.textfield.TextInputEditText;

public class DeleteProductActivity extends AppCompatActivity {

    DatabaseOperations db;
    Button btn_delete;
    TextInputEditText delete_id;
    TextView title;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        db=new DatabaseOperations(DeleteProductActivity.this);
        btn_delete=findViewById(R.id.btn_delete);
        delete_id=findViewById(R.id.delete_id);
        title=findViewById(R.id.title);
        back=findViewById(R.id.back);
        title.setText("Delete Product");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deletedRows=db.deletedata(delete_id.getText().toString());
                if (deletedRows >0)
                {
                    Toast.makeText(DeleteProductActivity.this, "Data Was successfully deleted", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(DeleteProductActivity.this, "Data not deleted", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
