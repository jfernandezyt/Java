package com.company;

import java.util.ArrayList;
import java.util.List;

public class Yahtzee {
    private final List<Player> players = new ArrayList<>();

    public Yahtzee() {
        setup();
    }

    private void setup() {
        Cup gamesCup = new Cup();

        int numberOfPlayers = Console.getNumberInput("How many players are playing? ");

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = Console.getStringInput("Player" + (i + 1) + " name:");
            players.add(new Player(name, gamesCup));
        }
    }

    private int runTurn(Player currentPlayer) {
        int turnScore = 0;
        int currentRolls = 0;

        while (currentRolls < 5) {
            int rollScore;
            if (currentRolls == 0) {
                currentPlayer.cup.roll();
                Console.displayMessage(currentPlayer.cup.displayDice() + "\n");
                currentPlayer.cup.roll(pickDice(currentPlayer.getName()));
                turnScore += rollScore = currentPlayer.updateScore();
            } else {
                Console.displayMessage(currentPlayer.cup.displayDice() + "\n");
                currentPlayer.cup.roll(pickDice(currentPlayer.getName()));
                turnScore += rollScore = currentPlayer.updateScore();
            }
            Console.displayMessage("\nThis turn in round score: " + rollScore + "\n\n");
            currentRolls++;
        }
        return turnScore;
    }

    public void runGame() {
        for (Player player : players) {
            Console.displayMessage("\n\nCurrent Player Turn: " + player.getName() + "\n\n");
            int turnScore = runTurn(player);
            Console.displayMessage("End of round score " + turnScore + "\n");
        }

    }

    public Player determineWinner() {
        Player winner = null;
        for (Player player : players) {
            if (winner == null) {
                winner = player;
                continue;
            }
            if (winner.getScore() < player.getScore())
                winner = player;
        }
        return winner;
    }

    public List<Integer> pickDice(String name) {
        return Console.parseUserSelections(Console.getNumbersToReRoll(name));
    }
}
