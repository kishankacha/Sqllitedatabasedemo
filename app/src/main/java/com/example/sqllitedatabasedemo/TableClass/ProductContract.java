package com.example.sqllitedatabasedemo.TableClass;

public final class ProductContract {

    ProductContract()
    {

    }

    public  static  abstract class ProductEntry
    {
        public  static  final  String ID="id";
        public  static  final  String NAME="name";
        public  static  final  String PRICE="price";
        public  static  final  String QTY="qty";
        public  static  final String  DATABASE_NAME="user_info";
        public  static  final  String TABLE_NAME="product_table";

    }
}
