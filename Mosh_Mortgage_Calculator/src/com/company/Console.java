package com.company;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber(String question, double min, double max) {
        double temp;
        while (true) {
            System.out.print(question);
            try {
                temp = scanner.nextDouble();
                if (temp >= min && temp <= max)
                    break;
                else
                    System.out.print("Enter a value between " + min + " and " + max + "\n");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return temp;
    }
}
