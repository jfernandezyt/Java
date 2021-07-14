package com.company;

import java.util.ArrayList;
import java.util.List;

public class Car extends VehicleWithTires {
    /*
    inherent from Vehicle
    implement VehiclesWithTires

    @constructors:
    Car(Engine engine, String type, List<Passenger> list, Tire[] tires, int maxPassengers)
        use the parent class to set the (engine, type, isLand, isWater, isWater, isAir, isSpace, list, maxPassengers)
        set tires
     */
    private List<Tire> tires;

    public Car(Engine engine, int maxPassengers) {
        super(engine, "Car", true, false, false, false, maxPassengers);
        this.tires = new ArrayList<>();
    }
    @Override
    public String toString(){
        return String.format("{engine: %s, type:%s, isLand:%s, isWater: %s, isAir: %s, isSpace: %s, passengersList: %s, maxPassengers: %s, tires: %s}",
                super.getEngine(),
                super.getType(),
                super.getisLand(),
                super.getisWater(),
                super.getisAir(),
                super.getisSpace(),
                super.getPassengersList(),
                super.getMaxPassengers(),
                tires);
    }
}
