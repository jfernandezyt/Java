package com.company;

public class BoatEngine extends Engine {
    public BoatEngine(int fuel) {
        this.type = EngineTypes.BOAT.toString();
        this.fuel = fuel;
    }
}
