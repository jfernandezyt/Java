package com.company;

import java.util.List;

public class Game {
    private List<Player> players;

    public Game(List<Player> players){
        this.players = players;
    }

    public void setup(){

    }
    public void runTurn(){

    }
    public Player getPlayer(int index){
        return players.get(index);
    }
    public void runGame(){

    }
    public void determineWinner(){

    }
}
