package com.company;


import java.util.Arrays;
/*TODO
 *  calculate bonus points
 *  calculate the chance
 *  add multiple Yahtzee logic
 *  add user interface for all new implementations*/
public class Main {

    public static void main(String[] args) {
//        Yahtzee myGame = new Yahtzee();
//
//        myGame.runGame();
        Die die1 = new Die();
        Die die2 = new Die();
        Die die3 = new Die();
        Die die4 = new Die();
        Die die5 = new Die();
        die1.faceUpValue = 1;
        die2.faceUpValue = 1;
        die3.faceUpValue = 4;
        die4.faceUpValue = 4;
        die5.faceUpValue = 4;


        ScoreCard sc = new ScoreCard();

        sc.showPossibleScores(new Cup(Arrays.asList(
                die1,
                die2,
                die3,
                die4,
                die5))
        );
    }
}