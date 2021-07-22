package com.company;

import java.util.ArrayList;
import java.util.List;

public class Car extends Vehicle implements IHaveTires {
    /*
    inherent from Vehicle
    implement VehiclesWithTires

    @fields
    List<Tire> tires

    @constructors:
    Car(Temp engine, String type, List<Passenger> list, Tire[] tires, int maxPassengers)
        use the parent class to set the (engine, type, isLand, isWater, isWater, isAir, isSpace, list, maxPassengers)
        set tires
     */
    private List<Tire> tires;

    public Car(IEngine engine, int maxPassengers) {
        super(engine, "Car", true, false, false, false, maxPassengers);
        this.tires = new ArrayList<>();
    }

    @Override
    public void addTire(Tire tire){
        tires.add(tire);
    }
    @Override
    public void removeTire(){tires.remove(0);}
    @Override
    public void replaceTire(Tire tire, int index){
        tires.set(index, tire);
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
