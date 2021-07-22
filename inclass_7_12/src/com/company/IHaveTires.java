package com.company;

public interface IHaveTires {
    /*
    @methods:
    addTire(int diameter, int pressure, int max)
    removeTire
    replaceTire(int index, int diameter, int pressure, int max)
     */

    void addTire(Tire tire);

    void removeTire();

    void replaceTire(Tire tire, int index);
}
