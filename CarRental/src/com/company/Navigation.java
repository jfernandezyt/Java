package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Navigation {
    private static Scanner scanner = new Scanner(System.in);

    public static void getUserBookingChoice() {
        System.out.print("""
                Please enter the method of booking \s
                1) for first available
                2) for booking by Location id
                3) book by car id
                4) to settle accounts
                0) if you'd like to exit the program):\s""");
        handleBooking(scanner.nextInt());
    }

    public static void getUserSettlingChoice() {
        System.out.print("""
                Please choose the method of settling\s
                5) to settle the first booking,\s
                6) to settle by location ID,\s
                7) to settle by car ID,\s
                8) settle by customer name,\s
                9) settle all bookings,\s
                10) to go back to booking menu):\s""");
        handleSettling(scanner.nextInt());
    }

    private static void handleSettling(int nextInt) {
        String result;
        List<String> listResult;
    }

    private static void handleBooking(int chosenMenuOption, CarRental rental) {
        Booking booking;
        List<Booking> bookingsList = new ArrayList<>();
        String customerName = InputCollector.getInputString("Enter the Customer Name");
        int numberOfDaysRenting = InputCollector.getInputNumber("Alright, " + customerName + " please enter the number of days renting: ");
        Customer customer = new Customer(customerName, numberOfDaysRenting);

        switch (chosenMenuOption) {
            case 1:
                booking = rental.bookByFirstAvailable(customer);

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                getUserSettlingChoice();
                break;
            default:
                break;
        }
    }

    private void executeBooking(String bookingType, CarRental rental) {
        Booking booking;
        List<Booking> bookingsList = new ArrayList<>();
        String customerName = InputCollector.getInputString("Enter the Customer Name");
        int numberOfDaysRenting = InputCollector.getInputNumber("Alright, " + customerName + " please enter the number of days renting: ");
        Customer customer = new Customer(customerName, numberOfDaysRenting);

        if (bookingType.equals("FirstAvailable")) {
            booking = rental.bookByFirstAvailable(customer);
        } else if (bookingType.equals("LocationId")) {
            int locationId = InputCollector.getInputNumber("Please enter the location ID you'd like to book from (between 1 - " + rental.getNumberOfLocations() + "):");
            booking = rental.bookByLocationId(customer, locationId);
        } else if (bookingType.equals("CarId")) {
            int carId = InputCollector.getInputNumber("Please enter the car ID you'd like to book (between 1 - " +  Car.getNumberOfCars() + "): ");
            booking = rental.bookByCarId(customer, carId);
        }

        if (booking.getBookingId()) {
            rental.setIncome(booking.getBookingCost());
            bookingsList.add(booking);
            Output.printString("You successfully booked your vehicle " + customer.getCustomerName() + " !");
        } else
            Output.printString("Unfortunately, there was an error when trying to process your request, please try again.");

    }
}

