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
            Console.nextLine();
        } while (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS);


        for (int i = 0; i < numberOfPlayers; i++) {
            String name = Console.getStringInput("Player" + (i + 1) + " name:");
            players.add(new Player(name, gamesCup));
        }
    }

    private void runTurn(Player currentPlayer) {
        int currentRoll = 0;
        Console.displayMessage(String.format("New turn, it is %s turn !! %n", currentPlayer.getName()));
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
    private void runRound(int roundNumber){

        for (Player activePlayer: players) {
            Console.displayMessage("Current round: " + (roundNumber + 1));
            Console.displayMessage("\n\nCurrent Player Turn: " + activePlayer.getName() + "\n\n");
            runTurn(activePlayer);
        }
    }

    public void runGame() {
        int roundNumber = 0;

        while (roundNumber < ROUNDS) {
            runRound(roundNumber);
            roundNumber++;
        }
        determineWinner();
    }

    private void determineWinner() {
        Player winner = players.get(0);

        for(Player player: players){
            if (winner.getScore() < player.getScore())
                winner = player;

            Console.displayMessage(String.format("Name: %s | Score = %s %n", player.getName(), player.getScore()));
        }
        Console.displayMessage(String.format("Our winner is %s", winner));
    }

    public List<Integer> pickDice(String name) {
        String temp = Console.getNumbersToReRoll(name);
        return Console.parseUserSelections((temp == null) ? "0": temp);
    }

}
