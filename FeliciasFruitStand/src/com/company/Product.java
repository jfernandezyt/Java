package com.company;

public class Product {

    private double price;
    private String name;
    private boolean isExpired = false;
    private int quantity;

    //Constructors
    public Product(){

    }
    public Product(double price, String name, int quantity){
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }
    public Product(double price, String name, boolean isExpired, int quantity){
        this.price = price;
        this.name = name;
        this.isExpired = isExpired;
        this.quantity = quantity;
    }


    //Getters
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public boolean getIsExpired(){
        return isExpired;
    }
    public int getQuantity(){
        return quantity;
    }

    //Setters
    public void setPrice(double price){
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setIsExpired(boolean isExpired){
        this.isExpired = isExpired;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
