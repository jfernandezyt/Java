package com.company;

public class Customer extends BookingObjects{
    private String customerName;
    private int daysRenting;
    private final int customerId;
    private static int numberOfCustomers = 0;

    public Customer(){
        customerId = ++numberOfCustomers;
    }
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
    public int getCustomerId(){return customerId;}

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setDaysRenting(int daysRenting) { this.daysRenting = daysRenting; }

    public String toString(){
        return String.format("{customerId: %s, customerName: %s, daysRenting: %s}", getCustomerId(),getCustomerName(), getDaysRenting());
    }

}
