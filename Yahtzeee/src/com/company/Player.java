package com.company;

public class Player {
    private final String name;
    //private ScoreCard scoreCard;
    public Cup cup;
    public int score = 0;

    public Player(String name, Cup cup) {
        this.name = name;
        this.cup = cup;
    }

    public int updateScore(){
        int roundScore = 0;
        for (Die die: cup.getDice())
            roundScore += die.faceUpValue;
        score += roundScore;
        return roundScore;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }

}
