package com.company;

public class Shot {
    private final String flavorName;
    private float currentLiquidAmount;
    private final float amountDispersing;

    public Shot(String flavorName, int currentLiquidAmount) {
        this.flavorName = flavorName;
        this.currentLiquidAmount = currentLiquidAmount;
        this.amountDispersing = 10;
    }

    public String dispense() {
        if (getVolume() > 0)
            currentLiquidAmount -= amountDispersing;
        else
            return null;

        return flavorName;
    }


    public float getVolume() {
        return currentLiquidAmount / amountDispersing;
    }
    public String getName() {
        return flavorName;
    }

    @Override
    public String toString() {
        return String.format("{name: %s, currentLiquidAmount: %s, amountDispersing: %s}", flavorName, currentLiquidAmount, amountDispersing);
    }
}
