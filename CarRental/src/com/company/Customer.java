package com.company;

public class Customer{
    private final String customerName;
    private final int daysRenting;
    private final int customerId;
    private static int numberOfCustomers = 0;

    public Customer(String customerName, int daysRenting){
        this.customerName = customerName;
        this.daysRenting = daysRenting;
        customerId = ++numberOfCustomers;
    }

    public String getCustomerName() {
        return customerName;
    }
    public int getDaysRenting() {
        return daysRenting;
    }

    public String toString(){
        return String.format("{customerId: %s, customerName: %s, daysRenting: %s}", customerId, customerName, daysRenting);
    }

}
