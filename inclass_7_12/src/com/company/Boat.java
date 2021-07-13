package com.company;

import java.util.ArrayList;
import java.util.List;

public class Boat extends Vehicle {
    /*
    inherent from Vehicle

    @fields:
    int maxLoad

    @constructors:
    Boat(Engine engine, String type, List<Passenger> list, int maxPassengers, int maxLoad)
        use the parent class to set the (engine, type, isLand, isWater, isWater, isAir, isSpace, list, maxPassengers)
        set maxLoad

     */
    private final int maxLoad;
    private int currentLoad = 0;

    public Boat(Engine engine, int maxPassengers, int maxLoad) {
        super(engine, "Boat", false, true, false, false, maxPassengers);
        this.maxLoad = maxLoad;
    }

    private void addToLoad(int addedLoad) {
        currentLoad += addedLoad;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        if (getPassengersList().size() < getMaxPassengers()) {
            if ((currentLoad + passenger.getWeight()) <= maxLoad) {
                addToLoad(passenger.getWeight());
                getPassengersList().add(passenger);
            }
        } else
            System.out.println("Vehicle is full");
    }

    @Override
    public String toString() {
        return String.format("{engine: %s, type:%s, isLand:%s, isWater: %s, isAir: %s, isSpace: %s, passengersList: %s, maxPassengers: %s, maxLoad: %s}",
                super.getEngine(),
                super.getType(),
                super.getisLand(),
                super.getisWater(),
                super.getisAir(),
                super.getisSpace(),
                super.getPassengersList(),
                super.getMaxPassengers(),
                maxLoad);
    }
}
