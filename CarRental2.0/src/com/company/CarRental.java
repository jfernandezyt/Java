package com.company;


import java.util.List;
import java.util.Map;

public class CarRental {
    private List<CanRent> locations;
    private double income = 0;

    public CarRental(List<CanRent> locations) {
        this.locations = locations;
    }

    public void bookFirstAvailable(Customer customer) {
        boolean isDoneBooking = false;
        for (CanRent location : locations) {
            for (Object carObj : location.getInventory()) {
                Car car = (Car) carObj;
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
        for (Object carObj : locations.get(locationID).getInventory()) {
            Car car = (Car) carObj;
            if (!car.getIsBooked()) {
                locations.get(locationID).book(customer, car);
                break;
            }
        }
    }

    public void bookByCarID(Customer customer, int carID) {
        boolean isDoneBooking = false;
        for (CanRent location : locations) {
            Car check = (Car) location.getInventory().get(location.getInventory().size() - 1);
            if(check.getCarID() < carID ){
                continue;
            }
            for (Object carObj : location.getInventory()) {
                Car car = (Car) carObj;
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
        for (CanRent location: locations) {
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
        for (CanRent location: locations) {
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
        for (CanRent location: locations) {
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

    public List<CanRent> getLocations() {
        return locations;
    }

    private void calculateIncome(){
        for (CanRent location: locations) {
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
