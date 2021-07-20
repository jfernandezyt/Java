package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cup myCup = new Cup();
        Scanner scanner = new Scanner(System.in);
        String input;

        myCup.roll();

        input = scanner.nextLine();
        myCup.roll(Console.parseUserSelections(input));

    }
}