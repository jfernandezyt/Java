package com.company;

import java.util.ArrayList;
import java.util.List;

public class Location implements CanBookAndSettle {
    private final int locationId;
    private static int numberOfLocations = 0;
    private final List<Car> availableCars;
    private List<Booking> bookings;
    private double income;

    public Location(List<Car> availableCars) {
        this.availableCars = availableCars;
        bookings = new ArrayList<>();
        income = 0;
        locationId = ++numberOfLocations;
    }

    @Override
    public void book(Customer bookingCustomer, Car bookedCar) {
        bookedCar.setIsBooked(true);
        double cost = bookingCustomer.getDaysRenting() * bookedCar.getCostPerDay();
        bookings.add(new Booking(bookingCustomer, bookedCar, cost, this.locationId));
        income += cost;
        System.out.printf("Car was successfully booked for %s!", bookingCustomer.getCustomerName());
    }

    @Override
    public void settle(Booking booking) {
        booking.setIsSettled(true);
        booking.getCar().setIsBooked(false);
        System.out.println("Successfully settled the account.");
    }



    //getters
    @Override
    public List<Booking> getBookings() {
        return bookings;
    }
    @Override
    public int getLocationId() {
        return locationId;
    }
    public double getIncome() {
        return income;
    }
    @Override
    public List<Car> getAvailableCars() {
        return availableCars;
    }

    @Override
    public boolean hasBookings() {
        return bookings.size() > 0;
    }

    @Override
    public String toString(){
        return String.format("{locationId: %s, availableCars: %s, bookings: %s, income: %s}", locationId, availableCars, bookings, income);
    }
}
