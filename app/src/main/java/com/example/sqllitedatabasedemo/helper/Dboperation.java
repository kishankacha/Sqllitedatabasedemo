package com.example.sqllitedatabasedemo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sqllitedatabasedemo.TableClass.ProductContract;

public class Dboperation extends SQLiteOpenHelper {

    private   static  final  int database_version =1;
    //private  static  final String DB_NAME="user_info.db";
    private  static  final  String CREATE_QUERY= "create table " + ProductContract.ProductEntry.TABLE_NAME+
            "("+ProductContract.ProductEntry.ID+ " text,"+ProductContract.ProductEntry.NAME+" text,"+
            ProductContract.ProductEntry.PRICE+ " integer,"+ProductContract.ProductEntry.QTY+ " integer);";

    Dboperation(Context ctx)
    {
        super(ctx,ProductContract.ProductEntry.DATABASE_NAME,null,database_version);
        Log.d("Database Operation ","Database Created..." );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database Operation ","Table Created..." );

    }

    public  void  addinformation(SQLiteDatabase db,String id,String name,int price,int qty)
    {

        ContentValues contentValues=new ContentValues();
        contentValues.put(ProductContract.ProductEntry.ID,id);
        contentValues.put(ProductContract.ProductEntry.NAME,name);
        contentValues.put(ProductContract.ProductEntry.PRICE,price);
        contentValues.put(ProductContract.ProductEntry.QTY,qty);
        db.insert(ProductContract.ProductEntry.TABLE_NAME,null,contentValues);
        Log.d("Database Operation ","One Row inserted......" );
    }

    public Cursor getInformation(SQLiteDatabase db)
    {
        String[] projections={ProductContract.ProductEntry.ID,ProductContract.ProductEntry.NAME, ProductContract.ProductEntry.PRICE,
        ProductContract.ProductEntry.QTY};

        Cursor cursor=db.query(ProductContract.ProductEntry.TABLE_NAME,projections, null,null,null,null,null);
        return  cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
