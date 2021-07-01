package com.company;

public class Syrup extends DrinkDispenserObject{

    public Syrup(String name, double amountOfLiquid) {
        super(name, amountOfLiquid);
    }

    public void  dispense(double amountDispensing){
        super.setAmountOfLiquid(getAmountOfLiquid() - amountDispensing);
    }

    @Override
    public String toString(){
        return String.format("{name: %s, amountOfLiquid: %s}", getName(), getAmountOfLiquid());
    }

}
