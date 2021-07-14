package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        boolean sessionDone = false;
        Customer customer;
        CarRental rental;
        int optionChosen;

        do {
            rental = InputCollector.createLocation();
        } while (rental == null);

        while (!sessionDone) {
            int locationId = -1;
            int carId = -1;
            optionChosen = Navigation.getUserBookingChoice();

            switch (optionChosen) {
                case 1 -> { //book by first available
                    do {
                        customer = InputCollector.createCustomer();
                    } while (customer == null);
                    rental.bookByFirstAvailable(customer);
                }
                case 2 -> { //book by location id
                    do {
                        customer = InputCollector.createCustomer();
                    } while (customer == null);

                    do {
                        locationId = InputCollector.getInputNumber("Please enter the location ID you'd like to book from (between 1 - " + rental.getNumberOfLocations() + "):");
                    } while (locationId < 0);

                    rental.bookByLocationId(customer, locationId);
                    locationId = -1;

                }
                case 3 -> { //book by car id
                    do {
                        customer = InputCollector.createCustomer();
                    } while (customer == null);

                    do {
                        carId = InputCollector.getInputNumber("Please enter the car ID you'd like to book (between 1 - " + Car.getNumberOfCars() + "): ");
                    } while (carId < 0);

                    rental.bookByCarId(customer, carId);
                    carId = -1;

                }
                case 4 -> {
                    optionChosen = Navigation.getUserSettlingChoice();

                    while (optionChosen != 10) {
                        switch (optionChosen) {
                            case 5 -> { //settleByFirstBooking
                                rental.settleByFirstBooking();
                            }
                            case 6 -> { //settleByLocationId
                                do {
                                    locationId = InputCollector.getInputNumber("Please enter the location ID you'd like to settle for choose (between 1 - " + rental.getNumberOfLocations() + "):");
                                } while (locationId < 0);

                                rental.settleByLocationId(locationId);
                                locationId = -1;
                            }

                            case 7 -> {//settleByCarId
                                do {
                                    carId = InputCollector.getInputNumber("Please enter the car ID of the account you'd like to settle (between 1 - " + Car.getNumberOfCars() + "): ");
                                } while (carId < 0);

                                rental.settleByCarId(carId);
                                carId = -1;
                            }
                            case 8 -> { //settleByCustomerName
                                String name;
                                do {
                                    name = InputCollector.getInputString("Enter the Customer Name: ");
                                } while (name == null);

                                rental.settleByCustomerName(name);
                                name = null;
                            }
                            case 9 -> { //settleAll
                                rental.settleAll();
                            }
                            default -> {
                            }
                        }
                        optionChosen = Navigation.getUserSettlingChoice();
                    }
                }
                default -> sessionDone = true;
            }
        }
        System.out.println("\n\n\n\nThese were the bookings for today.\n");
        System.out.println("You made a total of: $ ");
        rental.printIncome();
        for (Location location : rental.getAllLocations()) {
            for (Booking booking: location.getBookings()) {
                System.out.println(booking);
            }
        }

    }

}
