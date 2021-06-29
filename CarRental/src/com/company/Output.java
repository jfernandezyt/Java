package com.company;

public class Output {

    public static void printSuccess(String name){
        System.out.println("You successfully booked your vehicle " + name+ " !");
    }

    public static void printFailure(String... name){
        if(name.length > 0){
            System.out.println("Unfortunately, " + name[0] + " there was an error when trying to process your request, please try again.");
        }else{
            System.out.println("Unfortunately, there was an error when trying to process your request, please try again.");
        }

    }
    public static void printString(String sToPrint){
        System.out.println(sToPrint);
    }
}
