package com.company;

public class Meat extends Product{
    private String type;
    private String cut;

    //Meat constructors
    public Meat(){

    }
    public Meat(String type){
        this.type = type;
    }
    public Meat(String type, String cut){
        this.type = type;
        this.cut = cut;
    }
    public Meat(String name, double price, boolean isExpired, int quantity, String type, String cut){
        super(price, name, isExpired, quantity);
        this.type = type;
        this.cut = cut;
    }

    //Getters
    public String getType() {
        return type;
    }
    public String getCut() {
        return cut;
    }

    //Setters
    public void setColor(String type) {
        this.type = type;
    }

    public void setInSeason(String cut) {
        this.cut = cut;
    }

    //toString method
    public String toString(){
        return String.format("{name: %s, price: %s, isExpired: %s, quantity: %s, type: %s, cut: %s}", getName(), getPrice(), getIsExpired(), getQuantity(), getType(), getCut());
    }
}
