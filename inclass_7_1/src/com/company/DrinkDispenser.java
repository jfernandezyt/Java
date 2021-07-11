package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrinkDispenser {
    private List<Syrup> listOfSyrups;
    private List<Shot> listOfShots;
    public CupHolder small;
    public CupHolder medium;
    public CupHolder large;

    public DrinkDispenser(CupHolder small, CupHolder medium, CupHolder large) {
        this.listOfSyrups = new ArrayList<>();
        this.listOfShots = new ArrayList<>();
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public void serve(CupHolder size, int syrupIndex, int amountDispensing) {
        if (size.getQuantity() > 0)
            System.out.println(size.dispenseCup() + " " + listOfSyrups.get(syrupIndex).dispense(amountDispensing));
        else
            System.out.println("failed.");
    }

    public void serve(CupHolder size, int syrupIndex, int amountDispensing, Shot shot, int shotCount) {
        if (size.getQuantity() > 0 && shot.getVolume() >= shotCount) {
            for (int i = 1; i <= shotCount; i++) {
                if (i == shotCount) {
                    System.out.println(size.dispenseCup() + " " + shot.dispense() + " " + listOfSyrups.get(syrupIndex).dispense(amountDispensing));
                    break;
                }
                shot.dispense();
            }
        } else
            System.out.println("failed.");
    }

    public void serveDrink(String size, int syrupIndex) {
        switch (size) {
            case "Small" -> serve(small, syrupIndex, 12);
            case "Medium" -> serve(medium, syrupIndex, 16);
            case "Large" -> serve(large, syrupIndex, 24);
            default -> System.out.println("Not a valid size.");
        }
    }

    public void serveDrink(String size, int syrupIndex, int shotIndex, int shotCount) {
        switch (size) {
            case "Small" -> serve(small, syrupIndex, 12, listOfShots.get(shotIndex), shotCount);
            case "Medium" -> serve(medium, syrupIndex, 16, listOfShots.get(shotIndex), shotCount);
            case "Large" -> serve(large, syrupIndex, 24, listOfShots.get(shotIndex), shotCount);
            default -> System.out.println("Not a valid size.");
        }
    }

    public Map<String, Integer> lowSyrups(double vol) {
        Map<String, Integer> needToReplaceList = new HashMap<String, Integer>();

        for (int i = 0; i < listOfSyrups.size(); i++)
            if (listOfSyrups.get(i).getCurrentAmountOfLiquid() < vol)
                needToReplaceList.put(listOfSyrups.get(i).getName(), i);

        return needToReplaceList;
    }

    public Map<String, Integer> lowShot(int shots) {
        Map<String, Integer> needToReplaceList = new HashMap<String, Integer>();

        for (int i = 0; i < listOfShots.size(); i++)
            if (listOfShots.get(i).getVolume() < shots)
                needToReplaceList.put(listOfShots.get(i).getName(), i);

        return needToReplaceList;
    }

    public void addSyrup(Syrup newSyrup) {
        listOfSyrups.add(newSyrup);
    }

    public void addShot(Shot newShot) {
        listOfShots.add(newShot);
    }

    public void replaceSyrup(int index, Syrup newSyrup) {
        listOfSyrups.set(index, newSyrup);
    }

    public void replaceShot(int index, Shot newShot) {
        listOfShots.set(index, newShot);
    }

    @Override
    public String toString() {
        System.out.println("Syrups in dispenser:");
        for (Syrup syrup : listOfSyrups) {
            System.out.println(syrup);
        }
        System.out.println();
        System.out.println("Shots in dispenser:");
        for (Shot shot : listOfShots) {
            System.out.println(shot);
        }
        return String.format("\n{cupHolder1: %s, cupHolder2: %s, cupHolder3: %s}", small, medium, large);
    }
}
