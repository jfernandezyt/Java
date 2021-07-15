package com.company;

import com.company.Exception.InvalidEntry;
import com.company.Exception.InvalidNumberEntry;
import com.company.Exception.InvalidStringEntry;

import java.util.Scanner;

public class UserInterface {
    private static Scanner sc = new Scanner(System.in);

    public static Customer askCustomerInfo() throws InvalidEntry {
        String name = getStringInput("Enter Customer name:");
        int numberOfDaysRenting = getNumberInput("Enter number of days renting:");
        if (numberOfDaysRenting < 1) {
            throw new InvalidEntry(new InvalidNumberEntry("number is less than 1."));
        }
        if (name.trim().length() == 0) {
            throw new InvalidEntry(new InvalidStringEntry("entry can not be left blank"));
        }
        return new Customer(name, numberOfDaysRenting);
    }

    public static int getMenuChoice(String message) throws InvalidEntry {
        int temp = getNumberInput(message);
        if (temp < 1) {
            throw new InvalidEntry(new InvalidNumberEntry("number is less than 1."));
        }
        return temp;
    }

    public static int getNumberInput(String message) throws InvalidEntry {
        System.out.printf("%s ", message);
        int number = sc.nextInt();
        if (number < 1) {
            throw new InvalidNumberEntry("number is less than 1.");
        }
        return number;
    }

    public static String getStringInput(String message) throws InvalidEntry {
        System.out.printf("%s ", message);
        String temp = sc.next();
        if (temp.trim().length() == 0) {
            throw new InvalidStringEntry("entry can not be left blank");
        }
        return temp;
    }

    public static void handleBooking(int choice, CarRental rental) throws InvalidEntry {
        Customer customer = null;
        customer = askCustomerInfo();
        switch (choice) {
            case 1:
                rental.bookFirstAvailable(customer);
                break;
            case 2:
                int locationID = getNumberInput("Enter the location ID:");
                rental.bookByLocationID(customer, locationID);
                break;
            case 3:
                int carID = getNumberInput("Enter the car ID:");
                rental.bookByCarID(customer, carID);
                break;
            default:

        }
    }

    public static void handleSettling(int choice, CarRental rental) throws InvalidEntry {
        switch (choice) {
            case 5:
                rental.settleFirstBooking();
                break;
            case 6:
                int settleLocationID = getNumberInput("Enter the location ID:");
                rental.settleByLocationID(settleLocationID);
                break;
            case 7:
                int settleCarID = getNumberInput("Enter the car ID:");
                rental.settleByCarID(settleCarID);
                break;
            case 8:
                rental.settleAll();
                break;
            default:
        }
    }

    public static void printDaysResults(CarRental rental) {
        System.out.printf("Income for the day: %s %n%n", rental.getIncome());

        System.out.println("Bookings for the day\n___________________________\n");

        for (Location location : rental.getLocations())
            System.out.println(location.getListOfBookings());

    }

}
