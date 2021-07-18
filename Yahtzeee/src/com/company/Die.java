package com.company;

public class Die {
    /*
    @fields
    int numberOfSides
    int faceUpValue

    @constructors
    Default - set numberOfSides to 6
    1 param - take in numberOfSides and set numberOfSides

    @methods
    Should have a roll method, even though the Cup or Person do the action of the roll
    the Die should be responsible for assigning a value to its faceUpValue member variable

    roll() - assign a random number between 1(min)-numbberOfSides(max)
    */
    private int numberOfSides;
    public int faceUpValue;

    public Die() {
        numberOfSides = 6;
    }

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public void roll(){
        faceUpValue = (int) ((Math.random() * numberOfSides) + 1);
    }
}
