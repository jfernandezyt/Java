package com.company.Keith;

public class Output {

    public static void displayDice(int[] values) {
        //│
        //└
        //┘
        //┌
        //─
        //┐
        String temp = "┌───┐   ┌───┐   ┌───┐   ┌───┐   ┌───┐\n";
        temp += "│ %s │   │ %s │   │ %s │   │ %s │   │ %s │\n";
        temp += "└───┘   └───┘   └───┘   └───┘   └───┘";
        temp = String.format(temp, values[0], values[1], values[2], values[3], values[4]);
        System.out.println(temp);
    }
}
