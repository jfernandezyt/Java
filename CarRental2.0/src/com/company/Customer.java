package com.company;

public class Customer {
    private String customerName;
    private int daysRenting;
    private final int customerID;
    private static int numberOfCustomers = 0;

    public Customer(String customerName, int daysRenting) {
        this.customerName = customerName;
        this.daysRenting = daysRenting;
        customerID = ++numberOfCustomers;
    }

    public int getDaysRenting() {
        return daysRenting;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", daysRenting=" + daysRenting +
                ", customerID=" + customerID +
                '}';
    }
}
