package com.company.Keith;

public class Die {
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
