package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DrinkDispenser drinkDispenser = new DrinkDispenser(new ArrayList<Syrup>(),
                new ArrayList<Shot>(),
                new CupHolder("Small", 3),
                new CupHolder("Medium", 5),
                new CupHolder("Large", 2));
        //System.out.println(drinkDispenser);
        drinkDispenser.addSyrup(new Syrup("Sprite", 500));
        drinkDispenser.addSyrup(new Syrup("Coke", 340));
        drinkDispenser.addSyrup(new Syrup("Fanta", 200));
        drinkDispenser.addSyrup(new Syrup("Coke Vanilla", 50));
        drinkDispenser.addSyrup(new Syrup("Fruit Punch", 600));
        drinkDispenser.addSyrup(new Syrup("Grape", 100));

        drinkDispenser.addShot(new Shot("Vanilla", 100));
        drinkDispenser.addShot(new Shot("Strawberry", 50));
        drinkDispenser.addShot(new Shot("Blueberry", 25));

        //System.out.println(drinkDispenser);

        drinkDispenser.serveDrink("Small", 0);
        drinkDispenser.serveDrink("Large", 4);
        drinkDispenser.serveDrink("Medium", 2,0, 4);
        drinkDispenser.serveDrink("Medium", 5, 1, 10);
        drinkDispenser.serveDrink("Large", 2);
        drinkDispenser.serveDrink("Small", 3);
        drinkDispenser.serveDrink("Medium", 1,2, 2);
        drinkDispenser.serveDrink("Medium", 5, 0, 6);

        //System.out.println(drinkDispenser);


        drinkDispenser.serveDrink("Large", 3);

        drinkDispenser.large.refill(20);
        System.out.println();
        System.out.println(drinkDispenser.large);


        drinkDispenser.replaceShot(1, new Shot("Chocolate", 150));
        drinkDispenser.replaceSyrup(5, new Syrup("Grape", 1000));

        System.out.println(drinkDispenser);
    }
}
