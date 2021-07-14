package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarRental {
    private final int numberOfLocations;
    private final int carsPerLocation;
    private List<Location>  allLocations;
    private double income = 0;

    public CarRental(int numberOfLocations, int carsPerLocation) {
        this.numberOfLocations = numberOfLocations;
        this.carsPerLocation = carsPerLocation;
        createLocations();
    }


    private void createLocations() {
        if (numberOfLocations > 0 && carsPerLocation > 0) {
            List<Location> locationHolder = new ArrayList<>();;
            for (int i = 0; i < numberOfLocations; i++) {
                List<Car> fleet = new ArrayList<>();
                for (int j = 0; j < carsPerLocation; j++) {
                    fleet.add(new Car(((j + 1) * 10.0)));
                }
                locationHolder.add(new Location(fleet));
            }
            allLocations = locationHolder;
        }
    }

    public void bookByFirstAvailable(Customer bookingCustomer) {
        for (Location location : allLocations) {
            Car car = getFirstCarAtLocation(location);
            if (car != null) {
                location.book(bookingCustomer, car);
                break;
            }
        }
    }

    public void bookByLocationId(Customer bookingCustomer, int locationId) {
        List<Car> carList = allLocations.get(locationId).getAvailableCars();
        for (Car car : carList)
            if (!car.getIsBooked()) {
                allLocations.get(locationId).book(bookingCustomer, car);
                break;
            }
    }

    public void bookByCarId(Customer bookingCustomer, int carId) {
        for (Location location : allLocations) {
            Car car = getCarById(location, carId);
            if (car != null) {
                location.book(bookingCustomer, car);
                break;
            }
        }
    }

    private Car getFirstCarAtLocation(Location location) {
        for (int j = 0; j < location.getAvailableCars().size(); j++)
            if (!location.getAvailableCars().get(j).getIsBooked())
                return location.getAvailableCars().get(j);
            else
                System.out.println("There weren't any vehicles available to book at this location.");

        return null;

    }

    private Car getCarById(Location location, int carId) {
        for (int j = 0; j < location.getAvailableCars().size(); j++)
            if (!location.getAvailableCars().get(j).getIsBooked() && location.getAvailableCars().get(j).getCarId() == carId)
                return location.getAvailableCars().get(j);
            else
                System.out.println("There weren't any vehicles at this location with that id.");

        return null;

    }

    public void settleByFirstBooking() {
        for (Location location : allLocations) {
            if (location.hasBookings()) {
                for (Booking booking : location.getBookings()) {
                    location.settle(booking);
                    break;
                }
            }
        }
    }

    public void settleByCarId(int carId) {
        for (Location location : allLocations) {
            if (location.hasBookings()) {
                for (Booking booking : location.getBookings()) {
                    if (booking.getCar().getCarId() == carId && !booking.getIsSettled()) {
                        location.settle(booking);
                        break;
                    }
                }

            }
        }
    }

    public void settleByCustomerName(String name) {
        for (Location location : allLocations) {
            if (location.hasBookings()) {
                for (Booking booking : location.getBookings()) {
                    if (booking.getCustomer().getCustomerName().equals(name) && !booking.getIsSettled()) {
                        location.settle(booking);
                        break;
                    }
                }

            }
        }
    }

    public void settleByLocationId(int locationId) {
        for (Location location : allLocations) {
            if (location.hasBookings() && location.getLocationId() == locationId) {
                for (Booking booking : location.getBookings()) {
                    if (!booking.getIsSettled()) {
                        location.settle(booking);
                        break;
                    }
                }

            }
        }
    }

    public void settleAll() {
        for (Location location : allLocations) {
            if (location.hasBookings()) {
                for (Booking booking : location.getBookings()) {
                    if (!booking.getIsSettled())
                        location.settle(booking);

                }

            }
        }
    }

    //Getters
    public int getNumberOfLocations() {
        return numberOfLocations;
    }
    public List<Location> getAllLocations() {
        return allLocations;
    }


    private void addAllIncome() {
        for (Location location: allLocations){
            if(location.getIncome() > 0)
                this.income += location.getIncome();
        }
    }

    public void printIncome() {
        addAllIncome();
        System.out.printf("Income for the day was %s", income);
        income = 0;
    }



    @Override
    public String toString() {
        return String.format("{locations: %s, carsPerLocation: %s, allLocations: %s, income: %s}", numberOfLocations, carsPerLocation, allLocations, income);
    }


}
