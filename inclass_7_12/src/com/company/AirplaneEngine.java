package com.company;

public class AirplaneEngine extends Engine {
    public AirplaneEngine(int fuel) {
        this.type = EngineTypes.AIRPLANE.toString();
        this.fuel = fuel;
    }
}
