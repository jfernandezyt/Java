package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DrinkDispenser {
    private List<Syrup> listOfSyrups;
    private List<Shot> listOfShots;
    private CupHolder small;
    private CupHolder medium;
    private CupHolder large;

    public DrinkDispenser(List<Syrup> listOfSyrups, List<Shot> listOfShots, CupHolder small, CupHolder medium, CupHolder large){
        this.listOfSyrups = listOfSyrups;
        this.listOfShots = listOfShots;
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public void serveDrink(double size, int syrupIndex){
        if(size == 12.0){
            if(small.getQuantity() < 1 || listOfSyrups.get(syrupIndex).getAmountOfLiquid() < 1){
                System.out.println("failed");
            }else {
                System.out.println(small.dispenseCup() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }
        }else if(size == 24.0){
            if(medium.getQuantity() < 1 || listOfSyrups.get(syrupIndex).getAmountOfLiquid() < 1){
                System.out.println("failed");
            }else {
                System.out.println(medium.dispenseCup() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }
        }else if(size == 32.0){
            if(large.getQuantity() < 1 || listOfSyrups.get(syrupIndex).getAmountOfLiquid() < 1){
                System.out.println("failed");
            }else {
                System.out.println(large.dispenseCup() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }
        }else{
            System.out.println("Not a valid size");
        }
    }

    public void serveDrink(double size, int syrupIndex, int shotIndex, int shotCount){
        Shot temp = listOfShots.get(shotIndex);
        if(size == 12.0){
            if(small.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1 || listOfSyrups.get(syrupIndex).getAmountOfLiquid() < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount - 1; i++){
                    temp.dispense();
                }
                System.out.println(small.dispenseCup() + " " + temp.dispense() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }

        }else if(size == 24.0){
            if(medium.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1 || listOfSyrups.get(syrupIndex).getAmountOfLiquid() < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount - 1; i++){
                    temp.dispense();
                }
                System.out.println(medium.dispenseCup() + " " + temp.dispense() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }
        }else if(size == 32.0){
            if(large.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1 || listOfSyrups.get(syrupIndex).getAmountOfLiquid() < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount - 1; i++){
                    temp.dispense();
                }
                System.out.println(large.dispenseCup() + " " + temp.dispense() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }
        }




    }
    public List<Integer> lowSyrups(double vol){
        List<Integer> tempList = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        for (Syrup syrup: listOfSyrups) {
            if (syrup.getAmountOfLiquid() < vol){
                tempList.add(j);
                i++;
            }
            j++;
        }
        return tempList;

    }

    public List<Integer> lowShot(int shots){
        List<Integer> tempList = new ArrayList<Integer>();
        int i = 0;
        int j = 0;

        for (Shot shot: listOfShots) {
            if (Double.parseDouble(shot.getVolume()) < shots){
                tempList.add(j);
                i++;
            }
            j++;
        }
        return tempList;

    }

    public void addSyrup(Syrup newSyrup){
        listOfSyrups.add(newSyrup);
    }
    public void addShot(Shot newShot){
        listOfShots.add(newShot);
    }

    public void replaceSyrup(int index, Syrup newSyrup){
        listOfSyrups.set(index, newSyrup);
    }
    public void replaceShot(int index, Shot newShot){
        listOfShots.set(index, newShot);
    }


    public String displayDispenser(){
        System.out.println("Syrups in dispenser:");
        for (Syrup syrup: listOfSyrups ) {
            System.out.println(syrup);
        }
        System.out.println();
        System.out.println("Shots in dispenser:");
        for (Shot shot: listOfShots ) {
            System.out.println(shot);
        }
        return String.format("{cupHolder1: %s, cupHolder2: %s, cupHolder3: %s}", small, medium, large);
    }
}
