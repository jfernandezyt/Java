package com.company;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    public void roll(Player currentPlayer) {
        currentPlayer.cup.roll();
    }

//    public void roll(int selection, Player currentPlayer) {
//        currentPlayer.getCup().roll(selection);
//    }

    public void roll(List<Integer> listOfSelections, Player currentPlayer) {
        for (int selection : listOfSelections)
            currentPlayer.cup.roll(selection);

    }

    public List<Integer> pickDice() {
        return Console.parseUserSelections(Console.getNumbersToReRoll());
    }

    public void endTurn(List<Integer> scores, Player currentPlayer) {
        int highScore = 0;
        for (int score : scores) {
            if (highScore < score)
                highScore = score;
        }
        currentPlayer.setHighestScore(highScore);
    }

    public void runTurn(Player player) {
        if (player.getHighestScore() == 0)
            roll(player);
        else {
            Console.displayMessage("Which dice would you like to re-roll ?");
            roll(pickDice(), player);
        }
    }
}
