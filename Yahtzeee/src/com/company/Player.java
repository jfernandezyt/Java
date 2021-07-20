package com.company;

public class Player {
    private final String name;
    //private ScoreCard scoreCard;
    private Cup cup;
    public int highestScore = 0;

    public Player(String name, Cup cup) {
        this.name = name;
        this.cup = cup;
    }

    public Cup getCup() {
        return cup;
    }

    public int getCurrentScore(){
        int score = 0;
        for (Die die: cup.getDice()) {
            score += die.faceUpValue;
        }
        return score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cup=" + cup +
                ", highestScore=" + highestScore +
                '}';
    }
}
