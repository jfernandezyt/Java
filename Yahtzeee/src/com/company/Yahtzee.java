package com.company;

import java.util.ArrayList;
import java.util.List;

public class Yahtzee {
    private List<Player> players = new ArrayList<>();

    public Yahtzee() {
        setup();
    }

    private void setup() {
        //Create the games Cup
        Cup gamesCup = new Cup();

        //Get Number of players playing
        int numberOfPlayers = Console.getNumberInput("How many players are playing?");

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = Console.getStringInput("Player" + (i + 1) + " name:");
            players.add(new Player(name, gamesCup));
        }
    }

    private void runTurn(Player currentPlayer, Turn turn) {
        List<Integer> scores = new ArrayList<>();

        turn.runTurn(currentPlayer);
        Console.displayMessage(currentPlayer.cup.displayDice());
        scores.add(currentPlayer.getCurrentScore());

        turn.endTurn(scores, currentPlayer);
    }

//    public Player getPlayer(int index) {
//        return players.get(index);
//    }

    public void runGame(Turn turn, Player player) {
        runTurn(player, turn);
    }

    public Player determineWinner() {
        Player winner = null;
        for (Player player : players) {
            if (winner == null)
                winner = player;

            if (winner.getHighestScore() < player.getHighestScore())
                winner = player;
        }
        return winner;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
