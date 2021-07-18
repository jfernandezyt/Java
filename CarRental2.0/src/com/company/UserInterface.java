package com.company;

import com.company.Exceptions.*;

import java.util.Scanner;

public class UserInterface {
    private static Scanner sc = new Scanner(System.in);

    public Customer askCustomerInfo() throws InvalidEntry {
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

    public int getMenuChoice(String message) throws InvalidEntry {
        int temp = getNumberInput(message);
        if (temp < 1) {
            throw new InvalidEntry(new InvalidNumberEntry("number is less than 1."));
        }
        return temp;
    }

    public int getNumberInput(String message) throws InvalidEntry {
        System.out.printf("%s ", message);
        int number = sc.nextInt();
        if (number < 1) {
            throw new InvalidNumberEntry("number is less than 1.");
        }
        return number;
    }

    public String getStringInput(String message) throws InvalidEntry {
        System.out.printf("%s ", message);
        String temp = sc.next();
        if (temp.trim().length() == 0) {
            throw new InvalidStringEntry("entry can not be left blank");
        }
        return temp;
    }

    private void handleBooking(int choice, CarRental rental) throws InvalidEntry {
        Customer customer = askCustomerInfo();
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

    private void handleSettling(int choice, CarRental rental) throws InvalidEntry {
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

    public void printDaysResults(CarRental rental) {
        System.out.printf("Income for the day: %s %n%n", rental.getIncome());

        System.out.println("Bookings for the day\n___________________________\n");

        for (Location location : rental.getLocations())
            System.out.println(location.getListOfBookings());

    }

    public void handle(int choice, CarRental rental) throws InvalidEntry {
        switch (choice) {
            case 1:
                do {
                    choice = getMenuChoice("""
                            This is the menu option for booking:
                            1: book by first available car
                            2: book by location ID
                            3: book by car ID
                            4: settle bookings
                            """);
                    if (choice == 4)
                        break;

                    handleBooking(choice, rental);
                } while (true);
                break;
            case 2:
                do {
                    choice = getMenuChoice("""
                            This is the menu option for settling bookings:
                            5: settle by first available booking
                            6: settle by location ID
                            7: settle by car ID
                            8: settle all bookings
                            9: to close the program
                            """);
                    if (choice == 9)
                        break;

                    handleSettling(choice, rental);
                } while (true);
                break;
            default:
        }
    }
}
