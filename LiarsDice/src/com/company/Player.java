package com.company;

public class Player {
    public final String name;
    public Cup cup;
    public Bid currentBid;

    public Player(String name, Cup cup) {
        this.name = name;
        this.cup = cup;
    }

    public void makeBid(int[] array) {
        int faceUpValue = array[0];
        int frequency = array[1];
        currentBid = new Bid(faceUpValue, frequency);
    }
    public void removeDie() {
        cup.dice.remove(cup.dice.size() -1);
    }
    public void roll() {
        for (Die die : cup.dice)
            die.roll();

    }
    public void showDice(){

    }

    public boolean canRemoveDie(){
        return ((cup.dice.size() - 1) > 0);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", currentBid=" + currentBid +
                '}';
    }
}
