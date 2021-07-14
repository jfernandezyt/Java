package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleWithTires extends Vehicle{
    /*
    @fields:
    List<Tire> tires

    @methods:
    addTire - add a new tire to the list of tires
    removeTire - remove a tire from the list of tires
    replaceTire(index) - replace a Tire at a given index
     */
    List<Tire> tires = new ArrayList<>();

    public VehicleWithTires(Engine engine, String type, boolean isLand, boolean isWater, boolean isAir, boolean isSpace, int maxPassengers) {
        super(engine, type, isLand, isWater, isAir, isSpace, maxPassengers);
    }

    void addTire(int diameter, int pressure, int max){
        tires.add(new Tire(diameter, pressure, max));
    }

    void removeTire(){tires.remove(0);}

    void replaceTire(int index, int diameter, int pressure, int max){
        tires.set(index, new Tire(diameter, pressure, max));
    }
}
