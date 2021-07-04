package com.company;

public class Shot{
    private String flavorName;
    private int currentLiquidAmount;
    private final int amountDispersing;

    public Shot(String flavorName, int currentLiquidAmount){
        this.flavorName = flavorName;
        this.currentLiquidAmount = currentLiquidAmount;
        this.amountDispersing = 10;
    }

    public String dispense(){
        if(getVolume() > 0){
            currentLiquidAmount -= amountDispersing;
        }else{
            //System.out.println("Out of " + flavorName + ". No liquid left, please replace");
            return null;
        }

        return flavorName;
    }


    public int getVolume(){
        int shotsRemaining = currentLiquidAmount / amountDispersing;

        return shotsRemaining;
    }

    @Override
    public String toString(){
        return String.format("{name: %s, currentLiquidAmount: %s, amountDispersing: %s}", flavorName, currentLiquidAmount, amountDispersing);
    }
}
