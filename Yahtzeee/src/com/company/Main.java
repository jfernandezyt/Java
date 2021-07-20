package com.company;


public class Main {

    public static void main(String[] args) {
        Yahtzee myYahtzee = new Yahtzee();

        for (Player player: myYahtzee.getPlayers())
            myYahtzee.runGame(new Turn(), player);

        Player winner = myYahtzee.determineWinner();

        Console.displayMessage(String.format("%s won this round with a score of %s", winner.getName(), winner.getHighestScore()));
    }
}