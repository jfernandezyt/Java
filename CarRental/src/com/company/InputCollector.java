package com.company;

import java.util.Scanner;

public class InputCollector {

    public static void printNextLine(){
        System.out.println();
    }

    public static String getInputString(String prompt){
        Scanner scanner = new Scanner(System.in);

        String result = String.format("%s: ", prompt);
        System.out.print(result);

        return scanner.nextLine();
    }
    public static int getInputNumber(String prompt){
        Scanner scanner = new Scanner(System.in);

        String result = String.format("%s: ", prompt);
        System.out.print(result);

        return scanner.nextInt();
    }
    public static void display(String message){
        System.out.print(message);
    }


}
