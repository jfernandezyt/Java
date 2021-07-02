package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DrinkDispenser drinkDispenser = new DrinkDispenser(new ArrayList<Syrup>(),
                new ArrayList<Shot>(),
                new CupHolder(12, 3),
                new CupHolder(24, 5),
                new CupHolder(32, 2));
    }
}
