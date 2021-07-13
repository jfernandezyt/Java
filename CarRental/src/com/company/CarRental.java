package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CarRental {
    private final int numberOfLocations;
    private final int carsPerLocation;
    private Location[] allLocations;
    private double income = 0;

    public CarRental(int numberOfLocations, int carsPerLocation) {
        this.numberOfLocations = numberOfLocations;
        this.carsPerLocation = carsPerLocation;
        createLocations();
    }


    private void createLocations() {
        if (numberOfLocations > 0 && carsPerLocation > 0) {
            Location[] locationHolder = new Location[numberOfLocations];
            for (int i = 0; i < numberOfLocations; i++) {
                Car[] fleet = new Car[carsPerLocation];
                for (int j = 0; j < carsPerLocation; j++) {
                    fleet[j] = new Car(((j + 1) * 10.0));
                }
                locationHolder[i] = new Location(fleet);
            }
            setAllLocations(locationHolder);
        }
    }

    public Booking bookByFirstAvailable(Customer bookingCustomer) {
        Location[] tempLocations = getAllLocations();

        for (Location tempLocation : tempLocations) {
            Car tempCar = getFirstCarAtLocation(tempLocation);
            if (tempCar != null)
                return tempLocation.book(bookingCustomer, tempCar);

        }
        return null;
    }

    public Booking bookByLocationId(Customer bookingCustomer, int locationId) {
        Car[] tempCarList = getAllLocations()[locationId].getAvailableCars();

        for (Car car : tempCarList)
            if (!car.getIsBooked())
                return getAllLocations()[locationId].book(bookingCustomer, car);


        return null;

    }

    public Booking bookByCarId(Customer bookingCustomer, int carId) {
        Location[] tempLocations = getAllLocations();

        for (Location tempLocation : tempLocations) {
            Car tempCar = getCarById(tempLocation, carId);
            if (tempCar != null)
                return tempLocation.book(bookingCustomer, tempCar);

        }
        return null;
    }

    private Car getFirstCarAtLocation(Location location){
        for (int j = 0; j < location.getAvailableCars().length; j++)
            if (!location.getAvailableCars()[j].getIsBooked())
                return location.getAvailableCars()[j];
            else
                System.out.println("There weren't any vehicles available to book at this location.");

        return null;

    }
    private Car getCarById(Location location, int carId){
        for (int j = 0; j < location.getAvailableCars().length; j++)
            if (!location.getAvailableCars()[j].getIsBooked() && location.getAvailableCars()[j].getCarId() == carId)
                return location.getAvailableCars()[j];
            else
                System.out.println("There weren't any vehicles at this location with that id.");

        return null;

    }

    public String settleByFirstBooking(List<Booking> list) {
        for (Booking booking : list) {
            if (!booking.getIsSettled()) {
                Booking settledBooking = getAllLocations()[booking.getLocationId() - 1].settle(booking);

                return produceSettledString(settledBooking);
            }
        }
        return null;
    }

    public String settleByCarId(List<Booking> list, int carId) {
        for(Booking booking : list){
            if(!booking.getIsSettled() && booking.getCar().getCarId() == carId){
                Booking settledBooking = getAllLocations()[booking.getLocationId() - 1].settle(booking);

                return produceSettledString(settledBooking);
            }
        }
        return null;
    }

    public String settleByCustomerName(List<Booking> list, String name) {
        for(Booking booking: list)
            if(!booking.getIsSettled() && booking.getCustomer().getCustomerName().equals(name))
                return produceSettledString(getAllLocations()[booking.getLocationId() - 1].settle(booking));

        return null;
    }

    public List<String> settleByLocationId(List<Booking> list, int locationId){
        List<String> settledMessagesList = new ArrayList<>();
        for(Booking booking: list)
            if(!booking.getIsSettled() && booking.getLocationId() == locationId)
                settledMessagesList.add(produceSettledString(getAllLocations()[booking.getLocationId() - 1].settle(booking)));

        return settledMessagesList;
    }

    public List<String> settleAll(List<Booking> list) {
        List<String> settledMessagesList = new ArrayList<>();
        for(Booking booking: list)
            if(!booking.getIsSettled())
                settledMessagesList.add(produceSettledString(getAllLocations()[booking.getLocationId() - 1].settle(booking)));

        return settledMessagesList;
    }

    private String produceSettledString(Booking settledBooking){
            return String.format("%s, they rented the vehicle with the id of %s. Total cost for customer was: %s. They rented for %s days at a cost of %s per day.",
                    settledBooking.getCustomer().getCustomerName(),
                    settledBooking.getCar().getCarId(),
                    settledBooking.getBookingCost(),
                    settledBooking.getCustomer().getDaysRenting(),
                    settledBooking.getCar().getCostPerDay());
    }

    public int getNumberOfLocations() {
        return numberOfLocations;
    }
    private Location[] getAllLocations() {
        return allLocations;
    }
    public double getIncome(){
        return income;
    }

    public void setIncome(double profit) {
        income += profit;
    }
    private void setAllLocations(Location[] allLocations) {
        this.allLocations = allLocations;
    }

    public String toString() {
        return String.format("{locations: %s, carsPerLocation: %s}", numberOfLocations, carsPerLocation);
    }


}
