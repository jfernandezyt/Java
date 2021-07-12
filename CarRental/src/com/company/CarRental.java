package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarRental {
    private int locations;
    private int carsPerLocation;
    private Location[] allLocations;
    private int income = 0;

    public CarRental() {

    }

    public CarRental(int locations, int carsPerLocation) {
        this.locations = locations;
        this.carsPerLocation = carsPerLocation;
        createLocations();
    }

    public int getLocations() {
        return locations;
    }

    public int getCarsPerLocation() {
        return carsPerLocation;
    }

    public Location[] getAllLocations() {
        return allLocations;
    }

    public void addIncome(int profit) {
        income += profit;
    }

    public void setAllLocations(Location[] allLocations) {
        this.allLocations = allLocations;
    }

    public void createLocations() {
        if (locations > 0 && carsPerLocation > 0) {
            Location[] locationHolder = new Location[locations];
            for (int i = 0; i < locations; i++) {
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
            Car tempCar = getSpecificCar(tempLocation, "firstAvail");
            if (tempCar != null) {
                return tempLocation.book(bookingCustomer, tempCar);
            }
        }
        return null;
    }

    public Booking bookByLocationId(Customer bookingCustomer, int locationId) {
        Car[] tempCarList = getAllLocations()[locationId].getAvailableCars();

        for (Car car : tempCarList) {
            if (!car.getIsBooked()) {
                return getAllLocations()[locationId].book(bookingCustomer, car);
            }
        }
        return null;

    }

    public Booking bookByCarId(Customer bookingCustomer, int carId) {
        Location[] tempLocations = getAllLocations();

        for (Location tempLocation : tempLocations) {
            Car tempCar = getSpecificCar(tempLocation, "carId", carId);
            if (tempCar != null) {
                return tempLocation.book(bookingCustomer, tempCar);
            }
        }
        return null;
    }

    public Car getSpecificCar(Location location, String type, int... carId) {
        if (type.equals("carId")) {
            for (int j = 0; j < location.getAvailableCars().length; j++) {
                if (!location.getAvailableCars()[j].getIsBooked() && location.getAvailableCars()[j].getCarId() == carId[0]) {
                    return location.getAvailableCars()[j];
                }
            }
        } else if (type.equals("firstAvail")) {
            for (int j = 0; j < location.getAvailableCars().length; j++) {
                if (!location.getAvailableCars()[j].getIsBooked()) {
                    return location.getAvailableCars()[j];
                }
            }
        }
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
            if(booking.getCar().getCarId() == carId && !booking.getIsSettled()){
                Booking settledBooking = getAllLocations()[booking.getLocationId() - 1].settle(booking);

                return produceSettledString(settledBooking);
            }
        }
        return null;
    }

    public String settleByCustomerName(List<Booking> list, String name) {
        for(Booking booking: list){
            if(booking.getCustomer().getCustomerName().equals(name) && !booking.getIsSettled()){
                Booking settledBooking = getAllLocations()[booking.getLocationId() - 1].settle(booking);
                return produceSettledString(settledBooking);
            }
        }
        return null;
    }

    public List<String> settle(List<Booking> list, int... locationId) {
        List<String> settled = new ArrayList<>();

        if(locationId.length > 0){
            for (Booking booking : list) {
                if (!booking.getIsSettled() && booking.getLocationId() == locationId[0] + 1) {
                    Booking settledBooking = getAllLocations()[booking.getLocationId() - 1].settle(booking);

                    settled.add(produceSettledString(settledBooking));
                }
            }
        }else{
            for (Booking booking : list) {
                if (!booking.getIsSettled()) {
                    Booking settledBooking = getAllLocations()[booking.getLocationId() - 1].settle(booking);

                    settled.add(produceSettledString(settledBooking));
                }
            }
        }


        return settled;
    }

    public String produceSettledString(Booking settledBooking){
            return String.format("%s, they rented the vehicle with the id of %s. Total cost for customer was: %s. They rented for %s days at a cost of %s per day.",
                    settledBooking.getCustomer().getCustomerName(),
                    settledBooking.getCar().getCarId(),
                    settledBooking.getBookingCost(),
                    settledBooking.getCustomer().getDaysRenting(),
                    settledBooking.getCar().getCostPerDay());
    }

    public String toString() {
        return String.format("{locations: %s, carsPerLocation: %s}", getLocations(), getCarsPerLocation());
    }


}
