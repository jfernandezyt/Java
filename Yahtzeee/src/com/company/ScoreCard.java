package com.company;

import java.util.*;

public class ScoreCard {
    private LinkedHashMap<String, Integer> rows;

    public ScoreCard() {
        rows = new LinkedHashMap<>();
        rows.put("ones", -1);
        rows.put("twos", -1);
        rows.put("threes", -1);
        rows.put("fours", -1);
        rows.put("fives", -1);
        rows.put("sixes", -1);
        rows.put("bonus", -1);
        rows.put("3 of a kind", -1);
        rows.put("4 of a kind", -1);
        rows.put("Full House", -1);
        rows.put("SM straight", -1);
        rows.put("LG straight", -1);
        rows.put("Yahtzee", -1);
        rows.put("Chance", -1);
//        rows.putAll(
//                Map.of("ones", -1,
//                        "twos", -1,
//                        "threes", -1,
//                        "fours", -1,
//                        "fives", -1,
//                        "sixes", -1,
//                        "bonus", -1,
//                        "3 of a kind", -1,
//                        "4 of a kind", -1,
//                        "Full house", -1)
//        );
//        rows.putAll(
//                Map.of("SM straight", -1,
//                        "LG straight", -1,
//                        "Yahtzee", -1,
//                        "Chance", -1)
//        );
    }

    public void showPossibleScores(Cup currentCup) {
        LinkedHashMap<Integer, Integer> freq = new LinkedHashMap<>();
        currentCup.getDice().stream()
                .map(die -> die.faceUpValue)
                .forEach((dieValue) -> {
                    if (!freq.containsKey(dieValue)) {
                        freq.put(dieValue, 1);
                    } else {
                        freq.put(dieValue, freq.get(dieValue) + 1);
                    }
                });
        LinkedHashMap<String, Integer> possibleScoresUpper = calculateUpperSection(freq);
        LinkedHashMap<String, Integer> possibleScoresLower = calculateLowerSection(freq);
        LinkedHashMap<String, Integer> mergedResults = merge(possibleScoresUpper, possibleScoresLower);
        Console.displayMessage(mergedResults.toString());
    }

    private LinkedHashMap<String, Integer> calculateLowerSection(LinkedHashMap<Integer, Integer> freq) {
        LinkedHashMap<String, Integer> possibleScores = new LinkedHashMap<>();

        if (freq.containsValue(5)) {
            if (rows.get("Yahtzee") == -1) {
                possibleScores.put("Yahtzee", 50);
            } else {
                //logic for a second Yahtzee ?
            }
        } else if (freq.size() > 3 && rows.get("SM straight") == -1 || freq.size() > 3 && rows.get("LG straight") == -1) {
            if (freq.size() == 5) {

                possibleScores.put("LG straight", 40);
            } else if (freq.size() == 4) {

                List<Integer> list = new ArrayList<Integer>(freq.values());
                boolean isSMStraight = isSmallStraight(list);
                if (isSMStraight) {
                    possibleScores.put("SM straight", 30);
                }
            }
        } else if (rows.get("Full House") == -1 && freq.containsValue(3) && freq.containsValue(2)) {
            possibleScores.put("Full House", 25);
            if(rows.get("3 of a kind") == -1){
                int sum = 0;
                for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                    sum += (entry.getKey() * entry.getValue());
                }
                possibleScores.put("3 of a kind", sum);
            }

        } else if (rows.get("4 of a kind") == -1 || rows.get("3 of a kind") == -1) {
            System.out.println("poop");
            int sum = 0;
            if (freq.containsValue(4)) {
                for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                    sum += (entry.getKey() * entry.getValue());
                }
                possibleScores.put("4 of a kind", sum);
                if (rows.get("3 of a kind") == -1) {
                    possibleScores.put("3 of a kind", sum);
                }
            } else if (freq.containsValue(3)) {
                sum = 0;
                for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                    sum += (entry.getKey() * entry.getValue());
                }
                possibleScores.put("3 of a kind", sum);
            }
        }
        return possibleScores;
    }

    private LinkedHashMap<String, Integer> calculateUpperSection(LinkedHashMap<Integer, Integer> freq) {
        LinkedHashMap<String, Integer> possibleScores = new LinkedHashMap<>();

        for (Map.Entry entry : freq.entrySet()) {
            if ((Integer) entry.getKey() == 1 && rows.get("ones") == -1) {
                possibleScores.put("ones", (Integer) entry.getValue());
            } else if ((Integer) entry.getKey() == 2 && rows.get("twos") == -1) {
                possibleScores.put("twos", ((Integer) entry.getValue()) * 2);
            } else if ((Integer) entry.getKey() == 3 && rows.get("threes") == -1) {
                possibleScores.put("threes", ((Integer) entry.getValue()) * 3);
            } else if ((Integer) entry.getKey() == 4 && rows.get("fours") == -1) {
                possibleScores.put("fours", ((Integer) entry.getValue()) * 4);
            } else if ((Integer) entry.getKey() == 5 && rows.get("fives") == -1) {
                possibleScores.put("fives", ((Integer) entry.getValue()) * 5);
            } else if ((Integer) entry.getKey() == 6 && rows.get("sixes") == -1) {
                possibleScores.put("sixes", ((Integer) entry.getValue()) * 6);
            }
        }

        return possibleScores;
    }

    private LinkedHashMap<String, Integer> merge(LinkedHashMap<String, Integer> first, LinkedHashMap<String, Integer> second) {
        LinkedHashMap<String, Integer> newList = new LinkedHashMap<>();

        first.forEach(newList::put);
        second.forEach(newList::put);

        return newList;
    }

    public void markScore(String key) {

    }

    private boolean isSmallStraight(List<Integer> list) {
        boolean isSMStraight = false;
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i == 3) {
                break;
            } else {
                if (list.get(i + 1) - list.get(i) == 1) {
                    isSMStraight = true;
                } else {
                    isSMStraight = false;
                    break;
                }
            }

        }
        return isSMStraight;
    }

    public void displayScoreCard() {
        for (Map.Entry<String, Integer> entry : rows.entrySet()) {
            System.out.println(entry);
        }
    }
}
