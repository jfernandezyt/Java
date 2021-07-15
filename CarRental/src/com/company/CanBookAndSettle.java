package com.company;


import java.util.List;

public interface CanBookAndSettle {

    void settle(Booking booking);

    void book(Customer bookingCustomer, Car bookedCar);

    List<Car> getAvailableCars();

    boolean hasBookings();

    List<Booking> getBookings();

    int getLocationId();

    double getIncome();

}
