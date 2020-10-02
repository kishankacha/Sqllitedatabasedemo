package com.example.sqllitedatabasedemo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sqllitedatabasedemo.TableClass.ProductContract;
import com.example.sqllitedatabasedemo.TableClass.Tabledata;

public class DatabaseOperations  extends SQLiteOpenHelper {

    public  static  final  int database_version =1;
    public  String CREATE_QUERY="CREATE TABLE "+ Tabledata.TableInfo.TABLE_NAME+"("+ Tabledata.TableInfo.USER_NAME +" TEXT, "+ Tabledata.TableInfo.USER_PASS+" TEXT);";

    private  static  final  String CREATE_QUERY2= "create table " + ProductContract.ProductEntry.TABLE_NAME+
            "("+ProductContract.ProductEntry.ID+ " text,"+ProductContract.ProductEntry.NAME+" text,"+
            ProductContract.ProductEntry.PRICE+ " integer,"+ProductContract.ProductEntry.QTY+ " integer);";

    public DatabaseOperations(Context context) {
        super(context, Tabledata.TableInfo.DATABASE_NAME, null,database_version);
        Log.d("Database operations","Database Created ");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        sdb.execSQL(CREATE_QUERY);
        sdb.execSQL(CREATE_QUERY2);
        Log.d("Database operations","Table Created ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public  void  putInformation(DatabaseOperations dop,String name,String pass)
    {
        SQLiteDatabase SQ= dop.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Tabledata.TableInfo.USER_NAME,name);
        cv.put(Tabledata.TableInfo.USER_PASS,pass);
        long k= SQ.insert(Tabledata.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database operations","One row inserted");
    }

    public Cursor getInformation(DatabaseOperations dop)
    {
        SQLiteDatabase SQ=dop.getReadableDatabase();
        String[] coloums={Tabledata.TableInfo.USER_NAME, Tabledata.TableInfo.USER_PASS};
        Cursor CR=SQ.query(Tabledata.TableInfo.TABLE_NAME,coloums,null,null,null,null,null);
        return  CR;

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

    public  Integer deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(ProductContract.ProductEntry.TABLE_NAME,"ID= ? ",new  String[] {id});
    }

    public  boolean updatedata(String id,String name,int price,int qty)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ProductContract.ProductEntry.ID,id);
        contentValues.put(ProductContract.ProductEntry.NAME,name);
        contentValues.put(ProductContract.ProductEntry.PRICE,price);
        contentValues.put(ProductContract.ProductEntry.QTY,qty);
        db.update(ProductContract.ProductEntry.TABLE_NAME,contentValues,"ID= ?",new  String[] {id});
        return  true;
    }
}
