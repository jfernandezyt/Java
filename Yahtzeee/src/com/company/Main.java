package com.company;


import java.util.Arrays;
/*TODO
 *  add a method to total all the scores on the scorecard
 *  add the bonus points method somewhere to update the bonus points row in scorecard
 *  add a more user friendly display for the nulls in the scorecard
 *  on the final roll of a turn the user should be able to see which rows haven't been marked yet, in case they need to mark one of the fields as a 0*/
public class Main {

    public static void main(String[] args) {
        Yahtzee myGame = new Yahtzee();

        myGame.runGame();
    }
}