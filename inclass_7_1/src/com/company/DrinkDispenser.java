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

    public void serveDrink(String size, int syrupIndex){
        if(size.equals("small")){
            System.out.println(small.getVolumePerCup() + " " + listOfSyrups.get(syrupIndex).getName());
        }else if(size.equals("medium")){
            System.out.println(medium.getVolumePerCup() + " " + listOfSyrups.get(syrupIndex).getName());
        }else if(size.equals("large")){
            System.out.println(large.getVolumePerCup() + " " + listOfSyrups.get(syrupIndex).getName());
        }else{
            System.out.println("Not a valid size");
        }
    }

    public void serveDrink(String size, int syrupIndex, int shotIndex, int shotCount){
        Shot temp = listOfShots.get(shotIndex);
        if(size.equals("small")){
            if(small.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount; i++){
                    temp.dispense();
                }
                System.out.println(small.getVolumePerCup() + " " + temp.getName() + " " + listOfSyrups.get(syrupIndex).getName());
            }

        }else if(size.equals("medium")){
            if(medium.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount; i++){
                    temp.dispense();
                }
                System.out.println(medium.getVolumePerCup() + " " + temp.getName() + " " + listOfSyrups.get(syrupIndex).getName());
            }
        }else if(size.equals("large")){
            if(large.getQuantity() < 1 || Double.parseDouble(temp.getVolume()) < 1){
                System.out.println("failed");
            }else{
                for(int i = 0; i < shotCount; i++){
                    temp.dispense();
                }
                System.out.println(large.getVolumePerCup() + " " + temp.getName() + " " + listOfSyrups.get(syrupIndex).getName());
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
}
