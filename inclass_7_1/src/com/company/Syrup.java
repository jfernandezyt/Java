package com.company;

public class Syrup{
    private String syrupName;
    private int currentAmountOfLiquid;

    public Syrup(String syrupName, int currentAmountOfLiquid) {
        this.syrupName = syrupName;
        this.currentAmountOfLiquid = currentAmountOfLiquid;

    }

    public String  dispense(int amountDispensing){

        if( currentAmountOfLiquid - amountDispensing > 0){
            currentAmountOfLiquid -= amountDispensing;
        }
        return syrupName;
    }
    public int getCurrentAmountOfLiquid(){
        return currentAmountOfLiquid;
    }

    @Override
    public String toString(){
        return String.format("{name: %s, amountOfLiquid: %s}", syrupName, currentAmountOfLiquid);
    }

}
