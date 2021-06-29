package com.company;

public class Fruit extends Product{
    private String color;
    private boolean inSeason;

    //Fruit constructors
    public Fruit(){

    }
    public Fruit(String color){
        this.color = color;
    }
    public Fruit(String color, boolean inSeason){
        this.color = color;
        this.inSeason = inSeason;
    }
    public Fruit(String name, double price, boolean isExpired, int quantity, String color, boolean inSeason){
        super(price, name, isExpired, quantity);
        this.color = color;
        this.inSeason = inSeason;
    }

    //Getters
    public String getColor() {
        return color;
    }
    public boolean getInSeason() {
        return inSeason;
    }

    //Setters
    public void setColor(String color) {
        this.color = color;
    }

    public void setInSeason(boolean inSeason) {
        this.inSeason = inSeason;
    }


    //toString method
    public String toString(){return String.format("{name: %s, price: %s, isExpired: %s, quantity: %s, color: %s, inSeason: %s}", getName(), getPrice(), getIsExpired(), getQuantity(), getColor(), getInSeason());
    }
}
