package com.company;

public class Main {

    public static void main(String[] args) {
        CarRental rental = Navigation.start();

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
