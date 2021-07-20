package com.company.Mike;

public class Console {
    public static void clearConsole() {
        for (int clear = 0; clear < 1000; clear++) {
            System.out.println("\b");
        }
    }
}

/*
final String os = System.getProperty("os.name");
        if (os.contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
------------------------------------------------------------------------

public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
}

--------------------------------------------------------------------------

Runtime.getRuntime().exec("cls");


-------------------------------------------------------------------------

new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

*/