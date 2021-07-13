package com.company;

public class Tire {
    /*
    @fields:
    int diameter
    int pressure
    int max

    @methods:
    fill() - fill the tire pressure. default amount or accept a parameter ?

    @contructors:
    Tire(diameter, pressure)
     */
    private final int diameter;
    private int pressure;
    private final int max;

    public Tire(int diameter, int pressure, int max) {
        this.diameter = diameter;
        this.pressure = pressure;
        this.max = max;
    }

    public void fill(){
        pressure += (max - pressure);
    }

    @Override
    public String toString(){
        return String.format("{diameter: %s, pressure:%s, max:%s}", diameter, pressure, max);
    }

}
