package com.company;

public class Car {
    private int carID;
    private double costPerDay;
    private boolean isBooked = false;
    private static int numberOfCars = 0;

    public Car(double costPerDay) {
        this.costPerDay = costPerDay;
        carID = ++numberOfCars;
    }


    //getters
    public boolean getIsBooked() {
        return isBooked;
    }
    public double getCostPerDay() {
        return costPerDay;
    }

    //setter
    public void setIsBooked(boolean value) {
        isBooked = value;
    }
    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", cost=" + costPerDay +
                ", isBooked=" + isBooked +
                '}';
    }

    public int getCarID() {
        return carID;
    }
}
