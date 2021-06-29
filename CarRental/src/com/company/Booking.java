package com.company;

public class Booking {
    private final int bookingId;
    private static int numberOfBookings = 0;
    private Customer customer;
    private Car car;
    private double bookingCost;
    private boolean isSettled = false;
    private int locationId;

    public Booking(){
        bookingId = ++numberOfBookings;
    }

    public int getBookingId(){ return bookingId; }
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

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setCar(Car car){
        this.car = car;
    }
    public void setBookingCost(double bookingCost) {
        this.bookingCost = bookingCost;
    }
    public void setIsSettled(boolean isSettled) {
        this.isSettled = isSettled;
    }
    public void setLocationId(int locationId){
        this.locationId = locationId;
    }

    public String toString(){
        return String.format("{bookingId: %s, customer: %s, car: %s, bookingCost: %s, isSettled: %s, locationId: %s}", getBookingId(), getCustomer(), getCar(), getBookingCost(), getIsSettled(), getLocationId());
    }

}
