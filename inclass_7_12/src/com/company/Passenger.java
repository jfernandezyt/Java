package com.company;

public class Passenger {
    /*
    @fields:
    String name
    int weight

    @constructors:
    Passenger(name, weight)
     */
    private final String name;
    private int weight;

    public Passenger(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return String.format("{name: %s, weight:%s}", name, weight);
    }

    public int getWeight() {
        return weight;
    }
}
