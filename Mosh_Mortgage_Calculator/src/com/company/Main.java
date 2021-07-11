package com.company;
//first question is the amount of loan we want to get (principal)
//second question is the annual interest rate (interest rate)
//third question is the amount of years to take the loan out for (period)
//print out the mortgage

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        double principal = readNumber("Principal: ", 1_000.00, 1_000_000.00);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period: ", 1, 30);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }



    private static void printPaymentSchedule(double principal, float annualInterest, byte years) {
        double remainingBalance;
        System.out.print("\n\nPAYMENT SCHEDULE\n__________________\n");

        for (short month = 1; month <= calculateNumberOfPayments(years); month++) {
            remainingBalance = calculatePaymentSchedule(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }

    private static void printMortgage(double principal, float annualInterest, byte years) {
        System.out.print("\nMORTGAGE\n__________________\n");
        System.out.print("\nMonthly Payments: " + NumberFormat.getCurrencyInstance().format(calculateMortgage(principal, annualInterest, years)));
    }

    public static double calculateMortgage(double principal, float annualInterest, byte years) {

        short numberOfPayments = calculateNumberOfPayments(years);
        float monthlyInterest = calculateMonthlyInterest(annualInterest);
        double numerator = monthlyInterest * (Math.pow(1 + monthlyInterest, numberOfPayments));
        double denominator = Math.pow(1 + monthlyInterest, numberOfPayments) - 1;

        return (principal * (numerator / denominator));
    }

    public static double calculatePaymentSchedule(double principal, float annualInterest, byte years, int numberOfPaymentsMade) {
        short numberOfPayments = calculateNumberOfPayments(years);
        float monthlyInterest = calculateMonthlyInterest(annualInterest);

        return principal * (
                ((Math.pow(1 + monthlyInterest, numberOfPayments))
                        - (Math.pow(1 + monthlyInterest, numberOfPaymentsMade)))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1)
        );
    }

    public static short calculateNumberOfPayments(byte years) {
        return (short) (years * MONTHS_IN_YEAR);
    }

    public static float calculateMonthlyInterest(float annualInterest) {
        return ((annualInterest / PERCENT) / MONTHS_IN_YEAR);
    }

    public static double readNumber(String question, double min, double max) {
        Scanner scanner = new Scanner(System.in);
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
