package com.company;
//first question is the amount of loan we want to get (principal)
//second question is the annual interest rate (interest rate)
//third question is the amount of years to take the loan out for (period)
//print out the mortgage

public class Main {

    public static void main(String[] args) {
        double principal = Console.readNumber("Principal: ", 1_000.00, 1_000_000.00);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period: ", 1, 30);

        MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, annualInterest, years);
        MortgageReport mortgageReport = new MortgageReport(mortgageCalculator);

        mortgageReport.printMortgage();
        mortgageReport.printPaymentSchedule();
    }


}
