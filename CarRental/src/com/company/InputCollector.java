package com.company;

import java.util.Scanner;

public class InputCollector {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputString(String prompt){
        System.out.printf("%s: ", prompt);
        return scanner.nextLine();
    }
    public static int getInputNumber(String prompt){
        String result = String.format("%s: ", prompt);
        System.out.print(result);
        return scanner.nextInt();
    }

    public static Customer createCustomer(){
        String customerName = InputCollector.getInputString("Enter the Customer Name");
        int numberOfDaysRenting = InputCollector.getInputNumber("Alright, " + customerName +" please enter the number of days renting");

        if(customerName.length() > 0 && numberOfDaysRenting > 0)
            return new Customer(customerName, numberOfDaysRenting);
        return null;
    }

    public static CarRental createLocation(){
        int numOfLocations = InputCollector.getInputNumber("Please enter the amount of locations for this Rental Company");
        int numOfCars = InputCollector.getInputNumber("Please enter the amount of vehicles per location");

        if(numOfLocations > 0 && numOfCars > 0)
            return new CarRental(numOfLocations, numOfCars);
        return null;
    }

}
