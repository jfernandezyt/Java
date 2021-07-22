package com.company;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Vehicle implements IHaveTires {
    /*
    inherent from Vehicle
    implement IHaveTires

    @fields:
    List<Tire> tires
    boolean isLanding

    @methods
    toggleLanding - switch isLanding from current state

    @constructors:
    Plane(Temp engine, String type, List<Passenger> list, Tire[] tires, int maxPassengers, boolean isLanding)
        use the parent class to set the (engine, type, isLand, isWater, isWater, isAir, isSpace, list, maxPassengers)
        set isLanding
        set Tires

     */
    private boolean isLanding;
    private List<Tire> tires;

    public Plane(IEngine engine, int maxPassengers, boolean isLanding) {
        super(engine, "Plane", false, false, true, false,  maxPassengers);
        this.isLanding = isLanding;
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
    public void toggleLanding(){
        isLanding = !isLanding;
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
