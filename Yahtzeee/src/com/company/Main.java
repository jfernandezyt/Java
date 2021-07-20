package com.company;

import java.util.*;

public class Main {
    //Next item on the list is completing Turn class and
    //using it in the main method

    public static void main(String[] args) {

        //Create the games Cup
        Cup gamesCup = new Cup();

        int turn = 0;
        int playerTurn = 0;

        //Get Number of players playing
        int numberOfPlayers = Console.getNumberInput("How many players are playing?");

        //Empty array list to add all the created players
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++){
            String name  = Console.getStringInput("Player" + (i+1) + " name:");
            playerList.add(new Player(name, gamesCup));
        }

        //initialize the game with the collected players
        Game myGame = new Game(playerList);

        while (turn < numberOfPlayers) {
            //Initial roll of each player to start their turn to have dice to choose to keep or not
            //This counts as a turn
            myGame.getPlayer(turn).getCup().roll();

            //Create Player, Cup variables to hold the current player in the turn and the cup
            //For readability's sake
            Player currentPlayer = myGame.getPlayer(turn);
            Cup cup = myGame.getPlayer(turn).getCup();

            while (playerTurn < 3) {
                Console.displayMessage(cup.displayDice() + "\n");
                cup.roll(Console.parseUserSelections(Console.getNumbersToReRoll()));

                //Get current score and set the highestScore if temp score is bigger than highestScore
                int temp = currentPlayer.getCurrentScore();
                if(temp > currentPlayer.highestScore)
                    currentPlayer.highestScore = temp;

                playerTurn++;
            }
            turn++;
        }

        //This was simulating the winner. Actually needs to be done in Game;
//        Player winner = null;
//        for(int i = 0; i < playerList.size(); i++){
//            if(winner == null)
//                winner = playerList.get(i);
//            else{
//                if(winner.highestScore <  playerList.get(i).highestScore)
//                    winner = playerList.get(i);
//            }
//        }
//        System.out.println(winner);

    }
}