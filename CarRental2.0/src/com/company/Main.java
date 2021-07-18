package com.company;

import com.company.Exceptions.InvalidEntry;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        int numberOfLocations = 0;
        int carsPerLocation = 0;
        try {
            numberOfLocations = userInterface.getNumberInput("Number of locations for this Car Rental company ?");
            carsPerLocation = userInterface.getNumberInput("Number of cars per location for this Car Rental company ?");
        } catch (InvalidEntry invalidEntry) {
            System.out.println(invalidEntry.getMessage());
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
                choice = userInterface.getMenuChoice("""
                        Please choose between booking or settling:
                        1: booking
                        2: settling
                        3: terminate program and print days results""");
                if(choice == 3)
                    break;

                userInterface.handle(choice, rental);
            }while(true);
        } catch (InvalidEntry invalidEntry) {
            invalidEntry.printStackTrace();
        }
        if(rental != null)
            userInterface.printDaysResults(rental);
    }
}
