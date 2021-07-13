package com.company;

import java.util.ArrayList;
import java.util.List;

public interface VehicleWithTires {
    /*
    @fields:
    List<Tire> tires

    @methods:
    addTire - add a new tire to the list of tires
    removeTire - remove a tire from the list of tires
    replaceTire(index) - replace a Tire at a given index
     */
    List<Tire> tires = new ArrayList<>();

    void addTire(int diameter, int pressure, int max);

    void removeTire();

    void replaceTire(int index, int diameter, int pressure, int max);
}
