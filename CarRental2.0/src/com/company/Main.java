package com.company;

import com.company.Exception.InvalidEntry;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int numberOfLocations = 0;
        int carsPerLocation = 0;
        try {
            numberOfLocations = UserInterface.getNumberInput("Number of locations for this Car Rental company ?");
            carsPerLocation = UserInterface.getNumberInput("Number of cars per location for this Car Rental company ?");
        } catch (InvalidEntry invalidEntry) {
            invalidEntry.printStackTrace();
        }

        List<Location> locations = null;
        if (numberOfLocations > 0 && carsPerLocation > 0) {
            locations = new ArrayList<>();
            for (int i = 0; i < numberOfLocations; i++) {
                List<Car> fleet = new ArrayList<>();
                for (int j = 0; j < carsPerLocation; j++) {
                    fleet.add(new Car((j + 1) * 5));
                }
                locations.add(new Location(fleet, new ArrayList<>()));
            }
        }
        CarRental rental = null;
        if (locations != null) {
            rental = new CarRental(locations);
        }

        try {
            int choice;
            do {
                choice = UserInterface.getMenuChoice("""
                This is the menu option for booking:
                1: book by first available car
                2: book by location ID
                3: book by car ID
                4: settle bookings
                """);
                if(choice == 4)
                    break;
                UserInterface.handleBooking(choice, rental);

            }while(true);

            do {
                choice = UserInterface.getMenuChoice("""
                This is the menu option for settling bookings:
                5: settle by first available booking
                6: settle by location ID
                7: settle by car ID
                8: settle all bookings
                9: to close the program
                """);
                UserInterface.handleSettling(choice, rental);
                if(choice == 9)
                    break;
            }while(true);

        } catch (InvalidEntry invalidEntry) {
            invalidEntry.printStackTrace();
        }



    }
}
