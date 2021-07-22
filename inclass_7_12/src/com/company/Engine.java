package com.company;

public abstract class Engine implements IEngine{
    String type;
    boolean isOn = false;
    int fuel;


    @Override
    public void turnOn() {
        if(!isOn)
            isOn = true;
        else
            System.out.println("Vehicle was already on.");
    }

    @Override
    public void turnOff() {
        if(isOn)
            isOn = false;
        else
            System.out.println("Vehicle was already off.");
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", isOn=" + isOn +
                ", fuel=" + fuel +
                '}';
    }
}
