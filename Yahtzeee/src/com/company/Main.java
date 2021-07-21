package com.company;


public class Main {

    public static void main(String[] args) {
        Yahtzee myGame = new Yahtzee();

        myGame.runGame();

        Player winner = myGame.determineWinner();

        Console.displayMessage(String.format("%s won this round with a score of %s", winner.getName(), winner.getScore()));
    }
}