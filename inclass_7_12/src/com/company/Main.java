package com.company;

public class Main {

    public static void main(String[] args) {
	    Car car1 = new Car(new Engine("Electric", 0), 5);
        car1.addTire(33, 35, 35);
        car1.addTire(33, 35, 35);
        car1.addTire(33, 35, 35);
        car1.addTire(33, 35, 35);
        car1.addPassenger(new Passenger("Julia", 140));
        car1.addPassenger(new Passenger("Joel", 200));
        System.out.println(car1);

//        Boat boat1 = new Boat(new Engine("OutBoard", 100), 10, 500);
//        boat1.addPassenger(new Passenger("Erin", 135));
//        System.out.println(boat1);
//
//        Plane plane1 = new Plane(new Engine("Multi", 100), 50, false);
//        plane1.addTire(27, 200, 200);
//        plane1.addTire(27, 200, 200);
//        plane1.addTire(27, 200, 200);
//        plane1.addTire(27, 200, 200);
//        plane1.addTire(27, 200, 200);
//        plane1.addTire(27, 200, 200);
//        plane1.addPassenger(new Passenger("Tim", 180));
//        plane1.addPassenger(new Passenger("Tam", 150));
//        plane1.addPassenger(new Passenger("John", 180));
//        plane1.addPassenger(new Passenger("Jose", 175));
//        plane1.addPassenger(new Passenger("Ivy", 125));
//        plane1.addPassenger(new Passenger("Zed", 165));
//        plane1.addPassenger(new Passenger("Red", 220));
//        plane1.addPassenger(new Passenger("Bam", 250));
//
//        System.out.println(plane1);

    }
}
