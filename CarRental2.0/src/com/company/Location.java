package com.company;

import java.util.List;

public class Location implements CanBook, CanSettle {
    private final int locationID;
    private static int numberOfLocations = 0;
    private List<Car> listOfCars;
    private List<Booking> listOfBookings;
    private double income = 0;

    public Location(int locationID, List<Car> listOfCars, List<Booking> listOfBookings) {
        this.locationID = locationID;
        this.listOfCars = listOfCars;
        this.listOfBookings = listOfBookings;
        locationID = ++numberOfLocations;
    }

    @Override
    public void book(Customer customer, Car car) {
        if (!car.getIsBooked()) {
            car.setIsBooked(true);
            listOfBookings.add(new Booking(customer, car, car.getCostPerDay() * customer.getDaysRenting()));
            System.out.println("Successfully booked!");
        }else{
            System.out.println("Car is not available.");
        }

    }

    @Override
    public void settle() {

    }

    public int getLocationID() {
        return locationID;
    }

    public List<Car> getListOfCars() {
        return listOfCars;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", listOfCars=" + listOfCars +
                ", listOfBookings=" + listOfBookings +
                ", income=" + income +
                '}';
    }



}
