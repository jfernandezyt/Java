package com.company;

public class Output {

    public static void displayDice(int value) {
        // ⏺
        //｜
        //⎯
        String displayingDie = "";

        switch (value) {
            case 1:
                displayingDie = """
                         ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
                        |             ｜
                        |             ｜
                        |      ⏺      ｜
                        |              ｜
                        |             ｜
                        |⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯｜""";
                break;
            case 2:
                displayingDie = """
                        _______________
                        |      \u23fa       |
                        |             |
                        |             |
                        |             |
                        | \u23fa      |
                        |_____________|""";
                break;
            case 3:
                displayingDie = """
                        _______________
                        |      \u23fa |
                        |             |
                        |    \u23fa   |
                        |             |
                        | \u23fa      |
                        |_____________|""";
                break;
            case 4:
                displayingDie = """
                        _______________
                        |\u23fa \u23fa|
                        |             |
                        |             |
                        |             |
                        |\u23fa \u23fa|
                        |_____________|""";
                break;
            case 5:
                displayingDie = """
                        _______________
                        |\u23fa \u23fa|
                        |             |
                        |    \u23fa   |
                        |             |
                        |\u23fa \u23fa|
                        |_____________|""";
                break;
            case 6:
                displayingDie = """
                        _______________
                        |\u23fa \u23fa|
                        |             |
                        |\u23fa \u23fa|
                        |             |
                        |\u23fa \u23fa|
                        |_____________|""";
                break;
            default:

        }
        System.out.println(displayingDie);

    }
}
