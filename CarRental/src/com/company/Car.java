package com.company;

public class Car {
    private final int carId;
    private static int numberOfCars = 0;
    private final double costPerDay;
    private boolean isBooked = false;

    public Car(double costPerDay) {
        this.costPerDay = costPerDay;
        carId = ++numberOfCars;
    }

    public int getCarId() {
        return carId;
    }
    public Double getCostPerDay() { return costPerDay; }
    public boolean getIsBooked() { return isBooked; }
    public static int getNumberOfCars() { return numberOfCars; }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    @Override
    public String toString(){
        return String.format("{carId: %s, costPerDay: %s isBooked: %s}", carId, costPerDay, isBooked);
    }
}
