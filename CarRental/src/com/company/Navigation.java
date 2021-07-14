package com.company;

import java.util.Scanner;

public class Navigation {
    private  final static Scanner scanner = new Scanner(System.in);

    public static int getUserBookingChoice() {
        System.out.print("""
                Please enter the method of booking \s
                1) for first available
                2) for booking by Location id
                3) book by car id
                4) to settle accounts
                0) if you'd like to exit the program):\s""");

        try{
            return scanner.nextInt();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int getUserSettlingChoice() {
        System.out.print("""
                Please choose the method of settling\s
                5) to settle the first booking,\s
                6) to settle by location ID,\s
                7) to settle by car ID,\s
                8) settle by customer name,\s
                9) settle all bookings,\s
                10) to go back to booking menu):\s""");
        try{
            return scanner.nextInt();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 10;
    }
}

