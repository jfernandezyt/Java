package com.company;

import java.util.List;

public class Location implements CanRent {
    private final int locationID;
    private static int numberOfLocations = 0;
    private List<Car> listOfInventory;
    private List<Booking> listOfBookings;
    private double income = 0;

    public Location(List<Car> listOfInventory, List<Booking> listOfBookings) {
        this.listOfInventory = listOfInventory;
        this.listOfBookings = listOfBookings;
        locationID = ++numberOfLocations;
    }

    @Override
    public void book(Customer customer, Car car) {
        car.setIsBooked(true);
        listOfBookings.add(new Booking(customer, car, car.getCostPerDay() * customer.getDaysRenting()));
        System.out.println("Successfully booked!");
    }

    @Override
    public void settle(Booking booking) {
        booking.setIsSettled(true);
        booking.getCar().setIsBooked(false);
        income += booking.getBookingCost();
    }

    @Override
    public List<Car> getInventory() {
        return listOfInventory;
    }

    @Override
    public List<Booking> getListOfBookings() {
        return listOfBookings;
    }

    @Override
    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", listOfCars=" + listOfInventory +
                ", listOfBookings=" + listOfBookings +
                ", income=" + income +
                '}';
    }


}
