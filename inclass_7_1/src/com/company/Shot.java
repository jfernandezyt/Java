package com.company;

public class Shot extends DrinkDispenserObject{
    private double amountDispersing;

    public Shot(String name, double amountOfLiquid){
        super(name, amountOfLiquid);
        this.amountDispersing = 10.0;
    }

    public double getAmountDispersing() {
        return amountDispersing;
    }

    public void setAmountDispersing(double amountDispersing) {
        this.amountDispersing = amountDispersing;
    }

    public String dispense(){
        if(super.getAmountOfLiquid() - amountDispersing > 0){
            super.setAmountOfLiquid(super.getAmountOfLiquid() - amountDispersing);
        }else{
            return null;
        }

        return getName();
    }


    public String getVolume(){
        double shotsRemaining = super.getAmountOfLiquid() / amountDispersing;

        return Double.toString(shotsRemaining);
    }
}
