package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    /*
    @fields:
    Temp temp
    String type
    boolean isLand
    boolean isWater
    boolean isAir
    boolean isSpace
    List<Passenger> passengersList
    int maxPassengers

    @methods
    turnOn - switch temp on
    turnOff - switch temp to off
    addPassenger - add a passenger to the list of passengers
    removePassenger - remove specific passenger or last passenger ? clarify

    @constructors:
    Vehicle(temp, type, isLand, isWater, isWater, isAir, isSpace, list, maxPassengers)

     */

    private IEngine engine;
    private final String type;
    private final boolean isLand;
    private final boolean isWater;
    private final boolean isAir;
    private final boolean isSpace;
    private List<Passenger> passengersList;
    private final int maxPassengers;

    public Vehicle(IEngine engine, String type, boolean isLand, boolean isWater, boolean isAir, boolean isSpace, int maxPassengers) {
        this.engine = engine;
        this.type = type;
        this.isLand = isLand;
        this.isWater = isWater;
        this.isAir = isAir;
        this.isSpace = isSpace;
        this.passengersList = new ArrayList<>();
        this.maxPassengers = maxPassengers;
    }

    public void turnOn(){
        engine.turnOn();
    }

    public void turnOff(){
        engine.turnOff();
    }

    public void addPassenger(String name, int weight){
        if(passengersList.size() < maxPassengers)
            passengersList.add(new Passenger(name, weight));
        else
            System.out.println("Vehicle is full");
    }



    public void removePassenger(){
        passengersList.remove(0);
    }

    public IEngine getEngine() {
        return engine;
    }

    public String getType() {
        return type;
    }

    public boolean getisLand() {
        return isLand;
    }

    public boolean getisWater() {
        return isWater;
    }

    public boolean getisAir() {
        return isAir;
    }

    public boolean getisSpace() {
        return isSpace;
    }

    public List<Passenger> getPassengersList() {
        return passengersList;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }
}
