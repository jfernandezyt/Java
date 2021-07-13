package com.company;

public class Engine {
    /*
    @fields:
    String type
    boolean isOn
    int fuel

    @methods:
    turnOn - switch isOn to true
    turnOff - switch isOn to false
     */
    private final String type;
    private boolean isOn = false;
    private int fuel;

    public Engine(String type, int fuel) {
        this.type = type;
        this.fuel = fuel;
    }

    public void turnOn(){
        isOn = true;
    }

    public void turnOff(){
        isOn = false;
    }

    @Override
    public String toString(){
        return String.format("{type: %s, isOn:%s, fuel:%s}", type, isOn, fuel);
    }
}
