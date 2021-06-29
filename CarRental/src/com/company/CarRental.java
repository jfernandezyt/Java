package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarRental {
    private int locations;
    private int carsPerLocation;
    private Location[] allLocations;

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

    public void setLocations(int locations) {
        this.locations = locations;
    }

    public void setCarsPerLocation(int carsPerLocation) {
        this.carsPerLocation = carsPerLocation;
    }

    public void setAllLocations(Location[] allLocations) {
        this.allLocations = allLocations;
    }

    public void createLocations() {
        if (locations > 0 && carsPerLocation > 0) {
            Location[] locationHolder = new Location[locations];

            for (int i = 0; i < locations; i++) {
                Car[] fleet = new Car[carsPerLocation];
                Location tempLocation = new Location();

                for (int j = 0; j < carsPerLocation; j++) {
                    Car tempCar = new Car();
                    double cost = (j + 1) * 10.0;
                    tempCar.setCostPerDay(cost);
                    fleet[j] = tempCar;

                }
                tempLocation.setAvailableCars(fleet);
                locationHolder[i] = tempLocation;
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
