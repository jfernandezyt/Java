package com.company;

public class Dog extends Animal{
    private String breed;
    private int snoutLength;
    private int length;

    public Dog(String breed, int snoutLength, int length, int legs, String size, boolean isFixed, String name, String furColor){
        super(legs, size, isFixed, name, furColor);
        this.breed = breed;
        this.snoutLength = snoutLength;
        this.length = length;
    }

    public void speak(){
        System.out.println("woof");
    }

    public int getSnoutLength() {
        return snoutLength;
    }

    public String getBreed() {
        return breed;
    }

    public int getLength() {
        return length;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSnoutLength(int snoutLength) {
        this.snoutLength = snoutLength;
    }

    public String toString(){
        return String.format("{legs: %s, size: %s, isFixed: %s, name: %s, furColor: %s, breed: %s, snoutLength: %s, length: %s}", getLegs(), getSize(), isFixed(), getName(), getFurColor(), getBreed(), getSnoutLength(), getLength());
    }
}

/// private int legs;
//    private String size;
//    private boolean isFixed;
//    private String name;
//    private String furColor;
