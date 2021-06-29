package com.company;

public class Location {
    private final int locationId;
    private static int numberOfLocations = 0;
    private Car[] availableCars;

    public Location() {
        locationId = ++numberOfLocations;
    }

    public int getLocationId() { return locationId; }
    public Car[] getAvailableCars() { return availableCars; }

    public void setAvailableCars(Car[] availableCars) { this.availableCars = availableCars; }

    public Booking book(Customer bookingCustomer, Car bookedCar) {
        bookedCar.setIsBooked(true);

        Booking booking = new Booking();
        booking.setCustomer(bookingCustomer);
        booking.setCar(bookedCar);
        booking.setLocationId(this.locationId);
        booking.setBookingCost(bookingCustomer.getDaysRenting() * bookedCar.getCostPerDay());

        bookingCustomer.setBooking(booking);
        bookedCar.setBooking(booking);

        return booking;
    }

    public Booking settle(Booking booking) {

        booking.setIsSettled(true);

        booking.getCar().setIsBooked(false);
        booking.getCar().getBooking().setIsSettled(true);

        booking.getCustomer().getBooking().setIsSettled(true);

        return booking;
    }

}
