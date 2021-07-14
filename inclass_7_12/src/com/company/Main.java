package com.company;

public class Main {

    public static void main(String[] args) {
	    Car car1 = new Car(new Engine("Electric", 0), 5);
        car1.addTire(33, 35, 35);
        car1.addTire(33, 35, 35);
        car1.addTire(33, 35, 35);
        car1.addTire(33, 35, 35);
        car1.addPassenger("Julia", 140);
        car1.addPassenger("Joel", 200);
        System.out.println(car1);


        Boat boat1 = new Boat(new Engine("OutBoard", 100), 10, 500);
        boat1.addPassenger("Erin", 135);
        System.out.println(boat1);

        Plane plane1 = new Plane(new Engine("Multi", 100), 50, false);
        plane1.addTire(27, 200, 200);
        plane1.addTire(27, 200, 200);
        plane1.addTire(27, 200, 200);
        plane1.addTire(27, 200, 200);
        plane1.addTire(27, 200, 200);
        plane1.addTire(27, 200, 200);
        plane1.addPassenger("Tim", 180);
        plane1.addPassenger("Tam", 150);
        plane1.addPassenger("John", 180);
        plane1.addPassenger("Jose", 175);
        plane1.addPassenger("Ivy", 125);
        plane1.addPassenger("Zed", 165);
        plane1.addPassenger("Red", 220);
        plane1.addPassenger("Bam", 250);

        System.out.println(plane1);

    }
}
