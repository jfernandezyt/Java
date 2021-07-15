package com.company;

import java.util.List;

public class CarRental {
    private List<Location> locations;
    private double income = 0;

    public CarRental(List<Location> locations) {
        this.locations = locations;
    }

    public void bookFirstAvailable(Customer customer) {
        for (Location location : locations) {
            for (Car car : location.getListOfCars()) {
                if (!car.getIsBooked()) {
                    location.book(customer, car);
                    break;
                }
            }
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
        for (Location location : locations) {
            if(location.getListOfCars().get(location.getListOfCars().size() - 1).getCarID() < carID ){
                continue;
            }
            for (Car car : location.getListOfCars()) {
                if (!car.getIsBooked()) {
                    location.book(customer, car);
                    break;
                }
            }
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
