package com.example.sqllitedatabasedemo.helper;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqllitedatabasedemo.Activity.Product;
import com.example.sqllitedatabasedemo.Adapter.ProductAdapter;
import com.example.sqllitedatabasedemo.R;
import com.example.sqllitedatabasedemo.TableClass.ProductContract;

public class BackgroundTask extends AsyncTask<String,Product,String> {

    Context ctx;
    ProductAdapter productAdapter;
    Activity activity;
    ListView listView;
    public BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
        activity=(Activity) ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String method=params[0];
        DatabaseOperations dboperation=new DatabaseOperations(ctx);
        if (method.equals("add_info"))
        {
            String id=params[1];
            String Name=params[2];
            int price=Integer.parseInt(params[3]);
            int qty=Integer.parseInt(params[4]);
            SQLiteDatabase db=dboperation.getWritableDatabase();
            dboperation.addinformation(db,id,Name,price,qty);

             return  "One row inserted";
        }
        else if (method.equals("get_info"))
        {
            listView=activity.findViewById(R.id.display_listiew);
            SQLiteDatabase db=dboperation.getReadableDatabase();
            Cursor cursor= dboperation.getInformation(db);
            productAdapter=new ProductAdapter(ctx, R.layout.display_product_row);
            String id,name;
            int price,qty;
            while (cursor.moveToNext())
            {
                id=cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.ID));
                name=cursor.getString(cursor.getColumnIndex(ProductContract.ProductEntry.NAME));
                price=cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.PRICE));
                qty=cursor.getInt(cursor.getColumnIndex(ProductContract.ProductEntry.QTY));
                Product product=new Product(id,name,price,qty);
                publishProgress(product);
            }
            return  "get_info";


        }
      return  null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {

        if (result.equals("get_info"))
        {
            listView.setAdapter(productAdapter);
        }
        else
        {
            Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onProgressUpdate(Product... values)
    {
        productAdapter.add(values[0]);
    }
}
