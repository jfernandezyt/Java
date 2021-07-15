package com.company;

import java.util.List;

public class Location implements CanBook, CanSettle {
    private final int locationID;
    private static int numberOfLocations = 0;
    private List<Car> listOfCars;
    private List<Booking> listOfBookings;
    private double income = 0;

    public Location(List<Car> listOfCars, List<Booking> listOfBookings) {
        this.listOfCars = listOfCars;
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

    public List<Car> getListOfCars() {
        return listOfCars;
    }

    public List<Booking> getListOfBookings() {
        return listOfBookings;
    }

    public double getIncome() {
        return income;
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
