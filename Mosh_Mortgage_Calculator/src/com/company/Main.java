package com.company;
//first question is the amount of loan we want to get (principal)
//second question is the annual interest rate (interest rate)
//third question is the amount of years to take the loan out for (period)
//print out the mortgage

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Principal: ");
            double principal = scanner.nextDouble();
            System.out.print("Annual Interest Rate: ");
            float interest = ((scanner.nextFloat() / 100) / 12);
            System.out.print("Period: ");
            int period = (scanner.nextInt() * 12);

            double numerator = interest * (Math.pow(1 + interest, period));
            double denominator = Math.pow(1 + interest, period) - 1;

            double mortgage = principal * (numerator/denominator);

            System.out.print("\nMortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
