package com.company;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Vehicle implements VehicleWithTires{
    /*
    inherent from Vehicle
    implement VehicleWithTires

    @fields:
    boolean isLanding

    @methods
    toggleLanding - switch isLanding from current state

    @constructors:
    Plane(Engine engine, String type, List<Passenger> list, Tire[] tires, int maxPassengers, boolean isLanding)
        use the parent class to set the (engine, type, isLand, isWater, isWater, isAir, isSpace, list, maxPassengers)
        set isLanding
        set Tires

     */
    private boolean isLanding;
    private List<Tire> tires;

    public Plane(Engine engine,int maxPassengers, boolean isLanding) {
        super(engine, "Plane", false, false, true, false, new ArrayList<>(), maxPassengers);
        this.isLanding = isLanding;
        this.tires = new ArrayList<>();
    }
    public void toggleLanding(){
        isLanding = !isLanding;
    }

    @Override
    public void addTire(int diameter, int pressure, int max) {
        tires.add(new Tire(diameter, pressure, max));
    }

    @Override
    public void removeTire() {
        tires.remove(0);
    }

    @Override
    public void replaceTire(int index, int diameter, int pressure, int max) {
        tires.set(index, new Tire(diameter, pressure, max));
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
