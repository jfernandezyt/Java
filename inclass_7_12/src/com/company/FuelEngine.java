package com.company;

public class FuelEngine extends Engine{
    public FuelEngine(int fuel) {
        this.type = EngineTypes.FUEL.toString();
        this.fuel = fuel;
    }
}
