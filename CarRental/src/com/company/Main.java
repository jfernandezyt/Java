package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Booking> bookingsList = new ArrayList<>();
        double income = 0;
        boolean sessionDone = false;

        int numOfLocations = InputCollector.getNumberOfLocations();
        int numOfCars = InputCollector.getCarsPerLocation();

        InputCollector.printNextLine();
        InputCollector.printNextLine();

        CarRental rental = new CarRental(numOfLocations, numOfCars);

        int optionChosen = InputCollector.getChosenOption();

        while (!sessionDone) {
            Booking booking;
            int locationId;
            int carId;




            switch (optionChosen) {
                case 1 -> { //book by first available
                    String customerName = InputCollector.getCustomerName();
                    int numberOfDaysRenting = InputCollector.getAmountOfRentingDays(customerName);
                    Customer customer = new Customer(customerName, numberOfDaysRenting);

                    booking = rental.bookByFirstAvailable(customer);
                    if (booking != null) {
                        income += booking.getBookingCost();
                        bookingsList.add(booking);
                        Output.printSuccess(customer.getCustomerName());
                    } else {
                        InputCollector.printNextLine();
                        Output.printFailure(customer.getCustomerName());
                        InputCollector.printNextLine();
                    }
                }
                case 2 -> { //book by location id
                    String customerName = InputCollector.getCustomerName();
                    int numberOfDaysRenting = InputCollector.getAmountOfRentingDays(customerName);
                    Customer customer = new Customer(customerName, numberOfDaysRenting);

                    locationId = InputCollector.getLocationId(rental.getLocations(), "booking");
                    booking = rental.bookByLocationId(customer, locationId);
                    if (booking != null) {
                        income += booking.getBookingCost();
                        bookingsList.add(booking);
                        Output.printSuccess(customer.getCustomerName());
                    } else {
                        InputCollector.printNextLine();
                        Output.printFailure(customer.getCustomerName());
                        InputCollector.printNextLine();
                    }
                }
                case 3 -> { //book by car id
                    String customerName = InputCollector.getCustomerName();
                    int numberOfDaysRenting = InputCollector.getAmountOfRentingDays(customerName);
                    Customer customer = new Customer(customerName, numberOfDaysRenting);

                    carId = InputCollector.getCarId(Car.getNumberOfCars(), "booking");
                    booking = rental.bookByCarId(customer, carId);
                    if (booking != null) {
                        income += booking.getBookingCost();
                        bookingsList.add(booking);
                        Output.printSuccess(customer.getCustomerName());
                    } else {
                        InputCollector.printNextLine();
                        Output.printFailure(customer.getCustomerName());
                        InputCollector.printNextLine();
                    }
                }
                case 4 -> {
                    String result = "";
                    List<String> listResult = new ArrayList<>();
                    optionChosen = InputCollector.settleMenu();
                    while (optionChosen != 10) {
                        switch (optionChosen) {
                            case 5 -> { //settleByFirstBooking
                                result = rental.settleByFirstBooking(bookingsList);
                                if (result != null) {
                                    Output.printString(result);
                                } else {
                                    Output.printFailure();
                                }
                            }
                            case 6 -> { //settleByLocationId
                                locationId = InputCollector.getLocationId(rental.getLocations(), "settling");
                                listResult = rental.settle(bookingsList, locationId);
                                if (listResult != null) {
                                    Output.printString("You successfully settled the account(s) of:");
                                    for (String tempResult : listResult) {
                                        Output.printString(tempResult);
                                    }
                                } else {
                                    Output.printFailure();
                                }
                            }

                            case 7 -> {//settleByCarId
                                carId = InputCollector.getCarId(Car.getNumberOfCars(), "settling");
                                result = rental.settleByCarId(bookingsList, carId);
                                if (result != null) {
                                    Output.printString(result);
                                } else {
                                    Output.printFailure();
                                }
                            }
                            case 8 -> { //settleByCustomerName
                                String name = InputCollector.getCustomerName();
                                result = rental.settleByCustomerName(bookingsList, name);
                                if (result != null) {
                                    Output.printString(result);
                                } else {
                                    Output.printFailure();
                                }
                            }
                            case 9 -> { //settleAll
                                listResult = rental.settle(bookingsList);
                                if (listResult != null) {
                                    Output.printString("You successfully settled the account(s) of:");
                                    for (String tempResult : listResult) {
                                        Output.printString(tempResult);
                                    }
                                } else {
                                    Output.printFailure();
                                }
                            }
                            default -> { }
                        }
                        optionChosen = InputCollector.settleMenu();
                    }
                }
                default -> sessionDone = true;
            }
            optionChosen = InputCollector.getChosenOption();

            if(optionChosen == 0){
                sessionDone = true;
            }

        }

        System.out.println("\n\n\n\nThese were the bookings for today.\n");
        System.out.println("You made a total of: $" + income);
        for (Booking booking : bookingsList) {
            System.out.println(booking);
        }

    }
}
