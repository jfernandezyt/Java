package com.company;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    private final double principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator(double principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public  double calculateBalance() {

        short numberOfPayments = calculateNumberOfPayments();
        float monthlyInterest = calculateMonthlyInterest();
        double numerator = monthlyInterest * (Math.pow(1 + monthlyInterest, numberOfPayments));
        double denominator = Math.pow(1 + monthlyInterest, numberOfPayments) - 1;

        return (principal * (numerator / denominator));
    }

    public double calculatePaymentSchedule(int numberOfPaymentsMade) {
        short numberOfPayments = calculateNumberOfPayments();
        float monthlyInterest = calculateMonthlyInterest();

        return this.principal * (
                ((Math.pow(1 + monthlyInterest, numberOfPayments))
                        - (Math.pow(1 + monthlyInterest, numberOfPaymentsMade)))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1)
        );
    }

    public short calculateNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float calculateMonthlyInterest() {
        return ((annualInterest / PERCENT) / MONTHS_IN_YEAR);
    }
}