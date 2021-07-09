package com.company;

public class Cat extends Animal{
    private String pattern;
    private boolean wasStray;
    private boolean isNice;
    private String noise;

    public Cat(String pattern, boolean wasStray, boolean isNice, int legs, String size, boolean isFixed, String name, String furColor){
        super(legs, size, isFixed, name, furColor);
        this.pattern = pattern;
        this.wasStray = wasStray;
        this.isNice = isNice;
    }

    public boolean getIsNice() {
        return isNice;
    }

    public boolean getIsWasStray() {
        return wasStray;
    }

    public String getPattern() {
        return pattern;
    }

    public void setNice(boolean nice) {
        isNice = nice;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setWasStray(boolean wasStray) {
        this.wasStray = wasStray;
    }

    public void speak(){
        if(!noise.isEmpty()){
            System.out.println("meeeow");

        }else{
            System.out.println(noise);
        }

    }

    public String toString(){
        return String.format("{legs: %s, size: %s, isFixed: %s, name: %s, furColor: %s, pattern: %s, nice: %s, stray: %s}", getLegs(), getSize(), isFixed(), getName(), getFurColor(), getPattern(), getIsNice(), getIsWasStray());
    }
}
