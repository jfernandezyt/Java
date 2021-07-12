package com.company;

public class Booking {
    private final int bookingId;
    private static int numberOfBookings = 0;
    private final Customer customer;
    private final Car car;
    private final double bookingCost;
    private boolean isSettled = false;
    private final int locationId;


    public Booking(Customer customer, Car car, double bookingCost, int locationId){
        this.customer = customer;
        this.car = car;
        this.bookingCost = bookingCost;
        this.locationId = locationId;
        bookingId = ++numberOfBookings;
    }

    public Customer getCustomer(){
        return customer;
    }
    public Car getCar(){
        return car;
    }
    public double getBookingCost(){
        return bookingCost;
    }
    public boolean getIsSettled(){
        return isSettled;
    }
    public int getLocationId(){ return locationId; }
    public int getBookingId(){ return bookingId; }

    public void setIsSettled(boolean isSettled) {
        this.isSettled = isSettled;
    }

    public String toString(){
        return String.format("{bookingId: %s, customer: %s, car: %s, bookingCost: %s, isSettled: %s, locationId: %s}", bookingId, customer, car, bookingCost, isSettled, locationId);
    }

}
