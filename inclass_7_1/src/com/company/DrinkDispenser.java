package com.company;

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

    public List<Syrup> getListOfSyrups(){
        return listOfSyrups;
    }

    public List<Shot> getListOfShots(){
        return listOfShots;
    }

    public void serveDrink(double size, int syrupIndex){
        if(size == 12.0){
            System.out.println(small.dispenseCup() + " " + listOfSyrups.get(syrupIndex).getName());
            listOfSyrups.get(syrupIndex).dispense(size);
        }else if(size == 24.0){
            System.out.println(medium.dispenseCup() + " " + listOfSyrups.get(syrupIndex).getName());
            listOfSyrups.get(syrupIndex).dispense(size);
        }else if(size == 32.0){
            System.out.println(large.dispenseCup() + " " + listOfSyrups.get(syrupIndex).getName());
            listOfSyrups.get(syrupIndex).dispense(size);
        }else{
            System.out.println("Not a valid size");
        }
    }

    public void serveDrink(double size, int syrupIndex, int shotIndex, int shotCount){
        Shot temp = listOfShots.get(shotIndex);
        if(size == 12.0){
            if(small.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount - 1; i++){
                    temp.dispense();
                }
                System.out.println(small.dispenseCup() + " " + temp.dispense() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }

        }else if(size == 24.0){
            if(medium.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount - 1; i++){
                    temp.dispense();
                }
                System.out.println(medium.dispenseCup() + " " + temp.dispense() + " " + listOfSyrups.get(syrupIndex).getName());
                listOfSyrups.get(syrupIndex).dispense(size);
            }
        }else if(size == 32.0){
            if(large.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1){
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
    public int[] lowSyrups(double vol){
        int[] tempArray = new int[listOfSyrups.size()];
        int i = 0;
        int j = 0;

        for (Syrup syrup: listOfSyrups) {
            if (syrup.getAmountOfLiquid() < vol){
                tempArray[i] = j;
                i++;
            }
            j++;
        }
        return tempArray;

    }

    public int[] lowShot(int shots){
        int[] tempArray = new int[listOfShots.size()];
        int i = 0;
        int j = 0;

        for (Shot shot: listOfShots) {
            if (Double.parseDouble(shot.getVolume()) < shots){
                tempArray[i] = j;
                i++;
            }
            j++;
        }
        return tempArray;

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
