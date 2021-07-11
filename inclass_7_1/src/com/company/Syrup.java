package com.company;

public class Syrup {
    private final String syrupName;
    private int currentAmountOfLiquid;

    public Syrup(String syrupName, int currentAmountOfLiquid) {
        this.syrupName = syrupName;
        this.currentAmountOfLiquid = currentAmountOfLiquid;

    }

    public String dispense(int amountDispensing) {

        if (currentAmountOfLiquid - amountDispensing > 0)
            currentAmountOfLiquid -= amountDispensing;

        return syrupName;
    }

    public int getCurrentAmountOfLiquid() {
        return currentAmountOfLiquid;
    }
    public String getName() {
        return syrupName;
    }

    @Override
    public String toString() {
        return String.format("{name: %s, amountOfLiquid: %s}", syrupName, currentAmountOfLiquid);
    }

}
