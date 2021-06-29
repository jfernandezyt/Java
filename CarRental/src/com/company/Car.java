package com.company;

public class Car extends BookingObjects{
    private final int carId;
    private static int numberOfCars = 0;
    private double costPerDay;
    private boolean isBooked = false;


    public Car() {
        carId = ++numberOfCars;
    }

    public int getCarId() {
        return carId;
    }
    public Double getCostPerDay() { return costPerDay; }
    public boolean getIsBooked() { return isBooked; }
    public static int getNumberOfCars() { return numberOfCars; }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }
    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public String toString(){
        return String.format("{carId: %s, costPerDay: %s isBooked: %s}", getCarId(), getCostPerDay(), getIsBooked());
    }
}
