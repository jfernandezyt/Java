package com.company;

public class CupHolder {
    private final int volumePerCup;
    private int quantity;

    public CupHolder(int volumePerCup, int quantity){
        this.volumePerCup = volumePerCup;
        this.quantity = quantity;
    }

    public double getVolumePerCup() {
        return volumePerCup;
    }

    public double getQuantity() {
        return quantity;
    }

    public double dispenseCup(){
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
