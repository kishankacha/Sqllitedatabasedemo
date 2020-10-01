package com.example.sqllitedatabasedemo.Activity;

public class Product {

    private  String id,name;
    private  int price,qty;

    public  Product(String id,String  name,int price,int qty){
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setQty(qty);

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
