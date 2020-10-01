package com.example.sqllitedatabasedemo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sqllitedatabasedemo.TableClass.Tabledata;

public class DatabaseOperations  extends SQLiteOpenHelper {

    public  static  final  int database_version =1;
    public  String CREATE_QUERY="CREATE TABLE "+ Tabledata.TableInfo.TABLE_NAME+"("+ Tabledata.TableInfo.USER_NAME
            +" TEXT, "+ Tabledata.TableInfo.USER_PASS+" TEXT);";
    public DatabaseOperations(Context context) {
        super(context, Tabledata.TableInfo.DATABASE_NAME, null,database_version);
        Log.d("Database operations","Database Created ");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        sdb.execSQL(CREATE_QUERY);
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
}
