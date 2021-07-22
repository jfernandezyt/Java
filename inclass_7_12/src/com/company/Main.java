package com.company;

public class Main {

    public static void main(String[] args) {
        EngineFactory engine = new EngineFactory();

        Car car = new Car(engine.createEngine(EngineTypes.FUEL, 100), 5);

        System.out.println(car);
    }
}
