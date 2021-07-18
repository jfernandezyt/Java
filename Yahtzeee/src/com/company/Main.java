package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Die die1 = new Die();
        Die die2 = new Die();
        int total;
        int newTotal;

        die1.roll();
        die2.roll();
        total = die1.faceUpValue + die2.faceUpValue;
        System.out.println("Will the next number be (h)igher or (l)ower than " + total + "?");
        String input = scanner.next();
        while (true) {
            die1.roll();
            die2.roll();
            newTotal = die1.faceUpValue + die2.faceUpValue;
            if (total == newTotal) {
                System.out.println("same number you lose");
                break;
            }

            boolean isLarger = newTotal > total;
            System.out.println(die1.faceUpValue + " + " + die2.faceUpValue + " = " + (newTotal));
            System.out.println(isLarger ? "Number is higher" : "Number is lower");
            boolean didWin = false;

            if (input.equals("h")) { //guessed higher
                if (isLarger) {
                    didWin = true;
                }
            } else { //guessed lower
                if (!isLarger) {
                    didWin = true;
                }
            }
            System.out.println(didWin ? "you WIN" : "You LOSE");

            if(!didWin)
                break;
            total = newTotal;
            System.out.println("Will the next number be (h)igher or (l)ower than " + total + "?");
            input = scanner.next();
        }
        scanner.close();


    }
}