package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DrinkDispenser drinkDispenser = new DrinkDispenser(
                new CupHolder("Small", 3),
                new CupHolder("Medium", 5),
                new CupHolder("Large", 2));

        //Add all the syrups
        drinkDispenser.addSyrup(new Syrup("Sprite", 500));
        drinkDispenser.addSyrup(new Syrup("Coke", 340));
        drinkDispenser.addSyrup(new Syrup("Fanta", 200));
        drinkDispenser.addSyrup(new Syrup("Coke Vanilla", 50));
        drinkDispenser.addSyrup(new Syrup("Fruit Punch", 600));
        drinkDispenser.addSyrup(new Syrup("Grape", 100));

        //Add all the shots of flavorings
        drinkDispenser.addShot(new Shot("Vanilla", 100));
        drinkDispenser.addShot(new Shot("Strawberry", 50));
        drinkDispenser.addShot(new Shot("Blueberry", 25));

        //Start to serve the drinks
        drinkDispenser.serveDrink("Small", 0);
        drinkDispenser.serveDrink("Large", 4);
        drinkDispenser.serveDrink("Medium", 2,0, 4);
        drinkDispenser.serveDrink("Medium", 5, 1, 10);//fails not enough vanilla flavoring
        drinkDispenser.serveDrink("Large", 2);
        drinkDispenser.serveDrink("Small", 3);
        drinkDispenser.serveDrink("Medium", 1,2, 2);
        drinkDispenser.serveDrink("Medium", 5, 0, 6);
        drinkDispenser.serveDrink("Large", 3);//fails not enough Large cups

        //refill the large cupholder with 20 cups
        drinkDispenser.large.refill(20);
        System.out.println(drinkDispenser.large.getQuantity());

        /*********************************************************************************************************************************************************/

        Map<String, Integer> replaceShotsList = drinkDispenser.lowShot(150);//check all the shots and if they are under 150 it will return a HashMap of the shots needed to be changed

        if(replaceShotsList.size() > 0){
            for (Map.Entry<String, Integer> entry: replaceShotsList.entrySet()) {
                drinkDispenser.replaceShot(entry.getValue(), new Shot(entry.getKey(), 150));
            }
        }

        /***********************************************************************************************************************************************************/

        Map<String, Integer> replaceSyrupsList = drinkDispenser.lowSyrups(250);//check all the syrups and if they are under 250 it will return a HashMap of the shots needed to be changed

        if(replaceShotsList.size() > 0){
            for (Map.Entry<String, Integer> entry: replaceSyrupsList.entrySet()) {
                drinkDispenser.replaceSyrup(entry.getValue(), new Syrup(entry.getKey(), 250));
            }
        }

        /**********************************************************************************************************************************************************/

        //print out the drink dispenser to show the result
        System.out.println(drinkDispenser);
    }
}
