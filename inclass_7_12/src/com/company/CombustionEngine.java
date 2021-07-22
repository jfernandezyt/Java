package com.company;

public class CombustionEngine extends Engine{
    public CombustionEngine(int fuel) {
        this.type = EngineTypes.COMBUSTION.toString();
        this.fuel = fuel;
    }
}
