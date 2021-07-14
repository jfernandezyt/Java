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
        if(!isOn)
            isOn = true;
        else
            System.out.println("Vehicle was already on.");
    }

    public void turnOff(){
        if(isOn)
            isOn = false;
        else
            System.out.println("Vehicle was already off.");
    }

    @Override
    public String toString(){
        return String.format("{type: %s, isOn:%s, fuel:%s}", type, isOn, fuel);
    }
}
