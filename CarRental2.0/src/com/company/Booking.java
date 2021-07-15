package com.company;

public class Booking {

    private final int bookingID;
    private static int numberOfBookings = 0;
    private final Customer customer;
    private final Car car;
    private final double bookingCost;
    private boolean isSettled = false;

    public Booking(Customer customer, Car car, double bookingCost) {
        this.customer = customer;
        this.car = car;
        this.bookingCost = bookingCost;
        bookingID = ++numberOfBookings;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", customer=" + customer +
                ", car=" + car +
                ", bookingCost=" + bookingCost +
                ", isSettled=" + isSettled +
                '}';
    }
}
