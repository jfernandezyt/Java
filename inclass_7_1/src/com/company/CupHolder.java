package com.company;

public class CupHolder {
    private final String volumePerCup;
    private int quantity;

    public CupHolder(String volumePerCup, int quantity){
        this.volumePerCup = volumePerCup;
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public String dispenseCup(){
        quantity -= 1;
        return volumePerCup;
    }
    public void refill(int refillAmount){
        quantity += refillAmount;
    }

    @Override
    public String toString(){
        return String.format("{volumePerCup: %s, quantity: %s}", volumePerCup, quantity);
    }
}
