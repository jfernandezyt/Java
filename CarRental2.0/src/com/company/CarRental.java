package com.company;

import java.util.List;

public class CarRental {
    private List<Location> locations;
    private double income = 0;

    public CarRental(List<Location> locations) {
        this.locations = locations;
    }

    public void bookFirstAvailable(Customer customer) {
        boolean isDoneBooking = false;
        for (Location location : locations) {
            for (Car car : location.getListOfCars()) {
                if (!car.getIsBooked()) {
                    location.book(customer, car);
                    isDoneBooking = true;
                    break;
                }
            }
            if(isDoneBooking)
                break;
        }
    }

    public void bookByLocationID(Customer customer, int locationID) {
        for (Car car : locations.get(locationID).getListOfCars()) {
            if (!car.getIsBooked()) {
                locations.get(locationID).book(customer, car);
                break;
            }
        }
    }

    public void bookByCarID(Customer customer, int carID) {
        boolean isDoneBooking = false;
        for (Location location : locations) {
            if(location.getListOfCars().get(location.getListOfCars().size() - 1).getCarID() < carID ){
                continue;
            }
            for (Car car : location.getListOfCars()) {
                if (!car.getIsBooked()) {
                    location.book(customer, car);
                    isDoneBooking = true;
                    break;
                }
            }
            if(isDoneBooking)
                break;
        }
    }

    public void settleFirstBooking(){
        boolean isDoneSettling = false;
        for (Location location: locations) {
            for (Booking booking: location.getListOfBookings()) {
                if(!booking.getIsSettled()){
                    location.settle(booking);
                    System.out.printf("Successfully settled booking with ID: %s %n", booking.getBookingID());
                    isDoneSettling = true;
                    break;
                }
            }
            if(isDoneSettling)
                    break;
        }
    }

    public void settleByLocationID(int locationID){
        int counter = 0;
        for (Booking booking: locations.get(locationID).getListOfBookings()) {
            if(!booking.getIsSettled()) {
                locations.get(locationID).settle(booking);
                counter++;
            }
        }
        if(counter > 0)
            System.out.printf("Successfully settled %s bookings for locationID: %s %n", counter, locationID);
        else
            System.out.println("No bookings to settle at this location.");
    }

    public void settleByCarID(int carID){
        boolean isDoneSettling = false;
        for (Location location: locations) {
            for (Booking booking: location.getListOfBookings()) {
                if(booking.getCar().getCarID() == carID && !booking.getIsSettled()){
                    location.settle(booking);
                    System.out.printf("Successfully settled booking with ID: %s %n", booking.getBookingID());
                    isDoneSettling = true;
                    break;
                }
            }
            if(isDoneSettling)
                break;
        }
    }

    public void settleAll(){
        int counter = 0;
        for (Location location: locations) {
            for (Booking booking: location.getListOfBookings()) {
                if(!booking.getIsSettled()) {
                    location.settle(booking);
                    counter++;
                }
            }
        }
        if(counter > 0)
            System.out.printf("Successfully settled %s total bookings for all locations %n", counter);
        else
            System.out.println("No bookings to settle.");
    }

    public double getIncome() {
        income = 0;
        calculateIncome();
        return income;
    }

    public List<Location> getLocations() {
        return locations;
    }

    private void calculateIncome(){
        for (Location location: locations) {
            income += location.getIncome();
        }
    }

    @Override
    public String toString() {
        return "CarRental{" +
                "locations=" + locations +
                ", income=" + income +
                '}';
    }
}
