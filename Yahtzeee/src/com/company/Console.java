package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> parseUserSelections(String input) {
        String[] inputArr = input.split(" ");
        List<Integer> selections = new ArrayList<>();
        for (String temp: inputArr)
            selections.add(Integer.parseInt(temp) - 1);

        return selections;
    }

    public static String getNumbersToReRoll(String playerName){
        //this is needed to move the terminal cursor to the next readable line
        //when nextLine() is used the terminal cursor is left at the end of the user entry
        //and when nextLine() is used again it just consumes an empty string.
        scanner.nextLine();
        displayMessage("What Numbers would you like to re-roll (Player: " +playerName + ")  (1-5) ? ");
        return scanner.nextLine();
    }
    public static int getNumberInput(String message){
        displayMessage(message);
        return scanner.nextInt();
    }
    public static String getStringInput(String message){
        displayMessage(message);
        return scanner.next();
    }
    public static void displayMessage(String message){
        System.out.print(message);
    }
}
