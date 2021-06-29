package com.company;

import java.util.Scanner;

public class InputCollector {


    public InputCollector(){

    }
    public static void printNextLine(){
        System.out.println();
    }

    public static String getCustomerName(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Customer Name: ");
        return scanner.next();
    }

    public static int getAmountOfRentingDays(String customerName){
        Scanner scanner = new Scanner(System.in);

        String result = String.format("Alright %s please enter the number of days renting: ", customerName);
        System.out.print(result);

        return scanner.nextInt();
    }

    public static int getNumberOfLocations(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the amount of locations for this Rental Company: ");
        return scanner.nextInt();
    }

    public static int getCarsPerLocation(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the amount of vehicles per location: ");
        return scanner.nextInt();
    }

    public static  int getChosenOption(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the method of booking ( 1) for first available, 2) for booking by Location id, 3) book by car id, 4) to settle accounts, 0) if you'd like to exit the program): ");
        return scanner.nextInt();
    }
    public static int getLocationId(int numOfLoc, String type){
        Scanner scanner = new Scanner(System.in);

        if(type.equals("booking")){
            System.out.print("Please enter the location ID you'd like to book from (between 1 - " + numOfLoc + "): ");
        }else if(type.equals("settling")){
            System.out.print("Please enter the location ID of the location who's accounts you'd like to settle (between 1 - " + numOfLoc + "): ");
        }

        return (scanner.nextInt() - 1);
    }

    public static int getCarId(int numOfCars, String type){
        Scanner scanner = new Scanner(System.in);

        if(type.equals("booking")){
            System.out.print("Please enter the car ID you'd like to book (between 1 - " +  numOfCars + "): ");
        }else if(type.equals("settling")){
            System.out.print("Please enter the car ID of the account you'd like to settle (between 1 - " +  numOfCars + "): ");
        }


        return scanner.nextInt();
    }


    public static int settleMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose the method of settling ( 5) to settle the first booking, 6) to settle by location ID, 7) to settle by car ID, 8) settle by customer name, 9) settle all bookings, 10) to go back to booking menu): ");
        return scanner.nextInt();
    }


}
