package com.company;

import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator mortgageCalculator;
    private NumberFormat currencyInstance;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.print("\n\nPAYMENT SCHEDULE\n__________________\n");
        for(Double number: mortgageCalculator.getRemainingBalances()) {
            currencyInstance = NumberFormat.getCurrencyInstance();
            System.out.println(currencyInstance.format(number));
        }
    }

    public void printMortgage() {
        System.out.print("\nMORTGAGE\n__________________\n");
        System.out.print("\nMonthly Payments: " + currencyInstance.format(mortgageCalculator.calculateBalance()));
    }
}