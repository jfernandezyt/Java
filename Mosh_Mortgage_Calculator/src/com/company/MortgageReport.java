package com.company;

import java.text.NumberFormat;

public class MortgageReport {
    private final MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
    }

    public  void printPaymentSchedule() {
        double remainingBalance;
        System.out.print("\n\nPAYMENT SCHEDULE\n__________________\n");

        for (short month = 1; month <= mortgageCalculator.calculateNumberOfPayments(); month++) {
            remainingBalance = mortgageCalculator.calculatePaymentSchedule(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(remainingBalance));
        }
    }

    public  void printMortgage() {
        System.out.print("\nMORTGAGE\n__________________\n");
        System.out.print("\nMonthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgageCalculator.calculateBalance()));
    }
}