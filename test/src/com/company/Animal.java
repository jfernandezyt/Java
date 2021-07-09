package com.company;
public class Animal {
    private int legs;
    private String size;
    private boolean isFixed;
    private String name;
    private String furColor;

    public Animal (){

    }
    public Animal(int legs, String size, boolean isFixed, String name, String furColor){
        this.legs = legs;
        this.size = size;
        this.isFixed = isFixed;
        this.name = name;
        this.furColor = furColor;
    }

    public void speak(){
        System.out.println("---");
    }

    public int getLegs() {
        return legs;
    }

    public String getSize(){
        return size;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public String getName() {
        return name;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
}
