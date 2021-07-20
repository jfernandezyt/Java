package com.company;

public class Player {
    private final String name;
    //private ScoreCard scoreCard;
    public Cup cup;
    private int highestScore = 0;

    public Player(String name, Cup cup) {
        this.name = name;
        this.cup = cup;
    }

    public int getCurrentScore(){
        int score = 0;
        for (Die die: cup.getDice()) {
            score += die.faceUpValue;
        }
        return score;
    }

    public String getName() {
        return name;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        if(highestScore > this.highestScore)
            this.highestScore = highestScore;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", highestScore=" + highestScore +
                '}';
    }
}
