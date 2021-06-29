package com.company;

class Practice {
    public static boolean isLeapYear(int year){
        if(year % 4 != 0){
            return false;
        }
        if(year % 100  == 0){
            if(year % 400 == 0){
                return true;
            }
            return false;
        }
        return true;
    }

    public static int Fib(int pos){
        int next = 1;
        int fib = 0;
        int afterNext;
        for(int i= 0; i <= pos; i++){

            if(i != pos ) {
                afterNext = fib + next;
                fib = next;
                next = afterNext;
            }
        }
        return fib;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Fib: " + Practice.Fib(6));
        System.out.println("isleapyear: " + Practice.isLeapYear(2400));
    }
}
