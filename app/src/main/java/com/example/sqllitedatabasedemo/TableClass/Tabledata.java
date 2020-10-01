package com.example.sqllitedatabasedemo.TableClass;

import android.provider.BaseColumns;
import android.provider.Telephony;

public class Tabledata {

    public  Tabledata()
    {
    }
    public  static  abstract  class  TableInfo implements BaseColumns
    {

        public static final  String USER_NAME="user_name";
        public static final String USER_PASS="user_pass";
        public  static  final String  DATABASE_NAME="user_info";
        public static  final String TABLE_NAME="reg_info";
    }
}
