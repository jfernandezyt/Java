package com.company;

import java.util.ArrayList;
import java.util.List;

public class Console {
    public static List<Integer> parseUserSelections(String input) {
        String[] inputArr = input.split(" ");
        List<Integer> selections = new ArrayList<>();
        for (String temp: inputArr)
            selections.add(Integer.parseInt(temp) - 1);

        return selections;
    }
}
