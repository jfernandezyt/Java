package com.company;

import java.util.ArrayList;
import java.util.List;

public class Yahtzee {
    private final List<Player> players = new ArrayList<>();
    private final int AMOUNT_OF_ROLLS_PER_TURN = 3;
    private final int ROUNDS = 5;
    private final int MAX_PLAYERS = 6;
    private final int MIN_PLAYERS = 1;


    public Yahtzee() {
        setup();
    }

    private void setup() {
        Cup gamesCup = new Cup();
        int numberOfPlayers = 0;

        do {
            numberOfPlayers = Console.getNumberInput("How many players are playing? ");
        } while (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS);


        for (int i = 0; i < numberOfPlayers; i++) {
            String name = Console.getStringInput("Player" + (i + 1) + " name:");
            players.add(new Player(name, gamesCup));
        }
    }

    private void runTurn(Player currentPlayer) {
        int currentRoll = 0;

        while (currentRoll < AMOUNT_OF_ROLLS_PER_TURN) {
            if (currentRoll == 0) {
                currentPlayer.cup.roll();
                Console.displayMessage(currentPlayer.cup.displayDice() + "\n");
                currentPlayer.cup.roll(pickDice(currentPlayer.getName()));
            } else {
                Console.displayMessage(currentPlayer.cup.displayDice() + "\n");
                currentPlayer.cup.roll(pickDice(currentPlayer.getName()));
            }
            currentRoll++;
        }
        Console.displayMessage("\nScore this turn: " + currentPlayer.updateScore() + "\n\n");
    }

    public void runGame() {
        int roundNumber = 0;

        while (roundNumber < ROUNDS) {
            for (int i = 0; i < players.size(); i++) {
                Console.displayMessage("Current round: " + (roundNumber + 1));
                Console.displayMessage("\n\nCurrent Player Turn: " + players.get(i).getName() + "\n\n");
                runTurn(players.get(i));
            }
            roundNumber++;
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
