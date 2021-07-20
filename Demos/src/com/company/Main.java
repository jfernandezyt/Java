package com.company;

import com.company.Mike.Console;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        }

        Thread.sleep(5000);

        Console.clearConsole();
    }
}


