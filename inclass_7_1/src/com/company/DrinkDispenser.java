package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class DrinkDispenser {
    private List<Syrup> listOfSyrups;
    private List<Shot> listOfShots;
    public CupHolder small;
    public CupHolder medium;
    public CupHolder large;

    public DrinkDispenser(List<Syrup> listOfSyrups, List<Shot> listOfShots, CupHolder small, CupHolder medium, CupHolder large) {
        this.listOfSyrups = listOfSyrups;
        this.listOfShots = listOfShots;
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public void serveDrink(String size, int syrupIndex) {
        if (size.equals("Small")) {
            if (small.getQuantity() < 1) {
                System.out.println("failed");
            } else {
                System.out.println(small.dispenseCup() + " " + listOfSyrups.get(syrupIndex).dispense(5));
            }
        } else if (size.equals("Medium")) {
            if (medium.getQuantity() < 1) {
                System.out.println("failed");
            } else {
                System.out.println(medium.dispenseCup() + " " + listOfSyrups.get(syrupIndex).dispense(8));
            }
        } else if (size.equals("Large")) {
            if (large.getQuantity() < 1) {
                System.out.println("failed");
            } else {
                System.out.println(large.dispenseCup() + " " + listOfSyrups.get(syrupIndex).dispense(12));
            }
        } else {
            System.out.println("Not a valid size");
        }
    }

    public void serveDrink(String size, int syrupIndex, int shotIndex, int shotCount) {
        Shot shot = listOfShots.get(shotIndex);
        if (size.equals("Small")) {
            if (small.getQuantity() < 1 || shot.getVolume() < shotCount) {
                System.out.println("failed");
            } else {
                for (int i = 0; i < shotCount - 1; i++) {
                    shot.dispense();
                }
                if (shot.getVolume() - 1 > 0) {
                    System.out.println(medium.dispenseCup() + " " + shot.dispense() + " " + listOfSyrups.get(syrupIndex).dispense(8));
                } else {
                    System.out.println("failed");
                }
            }

        } else if (size.equals("Medium")) {
            if (medium.getQuantity() < 1 || shot.getVolume() < shotCount) {
                System.out.println("failed");
            } else {
                for (int i = 0; i < shotCount - 1; i++) {
                    shot.dispense();
                }
                if (shot.getVolume() - 1 > 0) {
                    System.out.println(medium.dispenseCup() + " " + shot.dispense() + " " + listOfSyrups.get(syrupIndex).dispense(8));
                } else {
                    System.out.println("failed");
                }

            }
        } else if (size.equals("Large")) {
            if (large.getQuantity() < 1 || shot.getVolume() < shotCount) {
                System.out.println("failed");
            } else {
                for (int i = 0; i < shotCount - 1; i++) {
                    shot.dispense();
                }
                if (shot.getVolume() - 1 > 0) {
                    System.out.println(medium.dispenseCup() + " " + shot.dispense() + " " + listOfSyrups.get(syrupIndex).dispense(8));
                } else {
                    System.out.println("failed");
                }
            }
        } else {
            System.out.println("Not a valid size");
        }


    }

    public List<Integer> lowSyrups(double vol) {
        List<Integer> needToReplaceList = new ArrayList<Integer>();

        for (int i = 0; i < listOfSyrups.size(); i++) {
            if (listOfSyrups.get(i).getCurrentAmountOfLiquid() < vol) {
                needToReplaceList.add(i);
            }
        }
        return needToReplaceList;

    }

    public List<Integer> lowShot(int shots) {
        List<Integer> needToReplaceList = new ArrayList<Integer>();

        for (int i = 0; i < listOfShots.size(); i++) {
            if (listOfShots.get(i).getVolume() < shots) {
                needToReplaceList.add(i);
            }
        }
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
