package com.company;

public class Location {
    private final int locationId;
    private static int numberOfLocations = 0;
    private final Car[] availableCars;

    public Location(Car[] availableCars) {
        this.availableCars = availableCars;
        locationId = ++numberOfLocations;
    }

    public Car[] getAvailableCars() { return availableCars; }

    public Booking book(Customer bookingCustomer, Car bookedCar) {
        bookedCar.setIsBooked(true);
        double cost = bookingCustomer.getDaysRenting() * bookedCar.getCostPerDay();
        return new Booking(bookingCustomer, bookedCar, cost, this.locationId);
    }

    public Booking settle(Booking booking) {
        booking.setIsSettled(true);
        booking.getCar().setIsBooked(false);
        return booking;
    }

}
