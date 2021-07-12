package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Booking> bookingsList = new ArrayList<>();
        double income = 0;
        boolean sessionDone = false;

        int numOfLocations = InputCollector.getInputNumber("Please enter the amount of locations for this Rental Company: ");
        int numOfCars = InputCollector.getInputNumber("Please enter the amount of vehicles per location: ");

        CarRental rental = new CarRental(numOfLocations, numOfCars);

        int optionChosen = InputCollector.getInputNumber("""
                    Please enter the method of booking \s
                    1) for first available
                    2) for booking by Location id
                    3) book by car id
                    4) to settle accounts
                    0) if you'd like to exit the program):\s""");

        while (!sessionDone) {
            Booking booking;
            int locationId;
            int carId;

            switch (optionChosen) {
                case 1 -> { //book by first available
                    String customerName = InputCollector.getInputString("Enter the Customer Name");
                    int numberOfDaysRenting = InputCollector.getInputNumber("Alright, " + customerName +" please enter the number of days renting: ");
                    Customer customer = new Customer(customerName, numberOfDaysRenting);

                    booking = rental.bookByFirstAvailable(customer);
                    if (booking != null) {
                        income += booking.getBookingCost();
                        bookingsList.add(booking);
                        Output.printSuccess(customer.getCustomerName());
                    } else {
                        Output.printFailure(customer.getCustomerName());
                    }
                }
                case 2 -> { //book by location id
                    String customerName = InputCollector.getInputString("Enter the Customer Name");
                    int numberOfDaysRenting = InputCollector.getInputNumber("Alright, " + customerName +" please enter the number of days renting: ");
                    Customer customer = new Customer(customerName, numberOfDaysRenting);

                    locationId = InputCollector.getInputNumber("Please enter the location ID you'd like to book from (between 1 - " + rental.getLocations() + "):");
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
                    String customerName = InputCollector.getInputString("Enter the Customer Name");
                    int numberOfDaysRenting = InputCollector.getInputNumber("Alright, " + customerName +" please enter the number of days renting: ");
                    Customer customer = new Customer(customerName, numberOfDaysRenting);

                    carId = InputCollector.getInputNumber("Please enter the car ID you'd like to book (between 1 - " +  Car.getNumberOfCars() + "): ");
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
                    String result;
                    List<String> listResult;
                    optionChosen = InputCollector.getInputNumber("""
                            Please choose the method of settling\s
                            5) to settle the first booking,\s
                            6) to settle by location ID,\s
                            7) to settle by car ID,\s
                            8) settle by customer name,\s
                            9) settle all bookings,\s
                            10) to go back to booking menu):\s""");

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
                                locationId = InputCollector.getInputNumber("Please enter the location ID of the location who's accounts you'd like to settle (between 1 - " + rental.getLocations() + "): ");
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
                                carId = InputCollector.getInputNumber("Please enter the car ID of the account you'd like to settle (between 1 - " +  Car.getNumberOfCars() + "): ");
                                result = rental.settleByCarId(bookingsList, carId);
                                if (result != null) {
                                    Output.printString(result);
                                } else {
                                    Output.printFailure();
                                }
                            }
                            case 8 -> { //settleByCustomerName
                                String name = InputCollector.getInputString("Enter the Customer Name");
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
                        optionChosen = InputCollector.getInputNumber("""
                            Please choose the method of settling\s
                            5) to settle the first booking,\s
                            6) to settle by location ID,\s
                            7) to settle by car ID,\s
                            8) settle by customer name,\s
                            9) settle all bookings,\s
                            10) to go back to booking menu):\s""");
                    }
                }
                default -> sessionDone = true;
            }
            optionChosen = InputCollector.getInputNumber("""
                    Please enter the method of booking \s
                    1) for first available
                    2) for booking by Location id
                    3) book by car id
                    4) to settle accounts
                    0) if you'd like to exit the program):\s""");

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
