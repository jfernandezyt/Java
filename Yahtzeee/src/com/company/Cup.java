package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cup {
    /*
    List<Die> dice
     */
    private List<Die> dice = new ArrayList<>();

    public Cup() {
        while(dice.size() < 5){
            dice.add(new Die());
        }
    }

    public void  roll(){
        for(Die die : dice)
            die.roll();

    }
    public void  roll(int unlockedSelection){
        dice.get(unlockedSelection).roll();

    }
    public void  roll(List<Integer> unlockedSelections){
        for (int index: unlockedSelections)
            roll(index);

    }

    public List<Die> getDice() {
        return dice;
    }

    public String displayDice(){
        StringBuilder output = new StringBuilder();
        for(Die die : dice)
            output.append(die.faceUpValue).append(" ");

        return output.toString().trim();
    }
}
