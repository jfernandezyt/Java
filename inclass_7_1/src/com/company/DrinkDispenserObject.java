package com.company;

public class DrinkDispenserObject {

    private String name;
    private double amountOfLiquid;

    public DrinkDispenserObject(String name, double amountOfLiquid){
        this.name = name;
        this.amountOfLiquid = amountOfLiquid;
    }

    public String getName(){
        return name;
    }
    public double getAmountOfLiquid(){
        return amountOfLiquid;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAmountOfLiquid(double amountOfLiquid){
        this.amountOfLiquid = amountOfLiquid;
    }
}
