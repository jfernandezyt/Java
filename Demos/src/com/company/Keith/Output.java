package com.company.Keith;

public class Output {

    public static void displayDice(int value) {
        // ⏺
        //｜
        //⎯
        String displayingDie = "";

        switch (value) {
            case 1:
                displayingDie = """
                        _______________
                        |             |
                        |             |
                        |      ⏺      |
                        |             |
                        |             |
                        |_____________|""";
                break;
            case 2:
                displayingDie = """
                        _______________
                        |            ⏺|
                        |             |
                        |             |
                        |             |
                        |⏺            |
                        |_____________|""";
                break;
            case 3:
                displayingDie = """
                        _______________
                        |            ⏺|
                        |             |
                        |      ⏺      |
                        |             |
                        |⏺            |
                        |_____________|""";
                break;
            case 4:
                displayingDie = """
                        _______________
                        |⏺          ⏺|
                        |             |
                        |             |
                        |             |
                        |⏺          ⏺|
                        |_____________|""";
                break;
            case 5:
                displayingDie = """
                        _______________
                        |⏺          ⏺|
                        |             |
                        |      ⏺      |
                        |             |
                        |⏺          ⏺|
                        |_____________|""";
                break;
            case 6:
                displayingDie = """
                        _______________
                        |⏺          ⏺|
                        |             |
                        |⏺          ⏺|
                        |             |
                        |⏺          ⏺|
                        |_____________|""";
                break;
            default:

        }
        System.out.println(displayingDie + "\t");

    }
}
