package com.company;

import java.util.*;

public class LiarsDice {
    private List<Player> playerList = new ArrayList<>();
    private LinkedList<Player> turnOrder = null;
    private final int MAX_PLAYERS = 10;
    private final int MIN_PLAYERS = 2;
    private Player playerCurrentBid;
    private Map<Integer, Integer> freq = new HashMap<>();

    public LiarsDice() {
        setup();
    }

    private void setup() {
        int numberOfPlayers = 0;

        do {
            numberOfPlayers = Console.getNumberInput("How many players are playing? ");
            Console.nextLine();
        } while (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS);

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = Console.getStringInput("\nPlayer" + (i + 1) + " name: ");
            playerList.add(new Player(name, new Cup()));
        }
        determineOrder();
        displayTurnOrder();
    }

    public void runGame() {
        while (playerList.size() > 1) {
            runRound();
        }
    }

    private void runRound() {
        boolean isRoundDone = false;
        int counter = 0;
        rollAllDice();
        doFrequency();
        displayAllDice();
        while (true) {
            for (int i = 0; i < playerList.size(); i++) {
                if (counter == 0) {
                    isRoundDone = runTurn(playerList.get(i), true);
                } else {
                    isRoundDone = runTurn(playerList.get(i), false);
                }
                if (isRoundDone) break;
                if ((i + 1) == playerList.size()) i = 0;
                counter++;
            }
            if (isRoundDone) break;
        }
    }

    private boolean runTurn(Player currentPlayer, boolean isFirstPlayer) {
        String result;
        if (isFirstPlayer) {
            do {
                //show dice to player
                makeBid(currentPlayer);
                //sout many times to clear the dice for the next player
                return false;
            } while (true);
        }
        do {
            //show dice to player
            result = Console.getStringInput("Would you like to make a bid (bid) or call the previous players bluff (call)?");
            if (result.equals("bid")) {
                makeBid(currentPlayer);
                //sout many times to clear the dice for the next player
                return false;
            }
            if (result.equals("call")) {
                callLiar(currentPlayer);
                return true;
            }
        } while (true);
    }

    private void rollAllDice() {
        for (Player player : playerList) {
            player.roll();
        }
    }

    private void doFrequency() {
        Map<Integer, Integer> freq = new HashMap<>();
        for (Player player : playerList) {
            for (Die die : player.cup.dice) {
                if (!freq.containsKey(die.faceUpValue)) {
                    freq.put(die.faceUpValue, 0);
                }
                freq.put(die.faceUpValue, freq.get(die.faceUpValue) + 1);
            }
        }
        this.freq = freq;
    }

    private void makeBid(Player currentPlayer) {
        do {
            playerCurrentBid = new Player("temp", new Cup());
            playerCurrentBid.makeBid(new int[]{0, 0});
            String result = Console.getStringInput("Please enter the die face up value and frequency of the bid (Ex. 2 x3 or 6 x5): ");
            if (isValidBid(result)) {
                currentPlayer.makeBid(Console.parseBid(result));
                this.playerCurrentBid = currentPlayer;
                return;
            } else {
                Console.displayMessage("\nFormat expected (1 x4) ((Die) x(Frequency))\n\n");
            }
        } while (true);
    }

    private void callLiar(Player currentPlayer) {
        int frequency = freq.get(playerCurrentBid.currentBid.faceUpValue);
        if (frequency < playerCurrentBid.currentBid.frequency) {
            if (!playerCurrentBid.canRemoveDie()) {
                playerList.remove(playerCurrentBid);
                Console.displayMessage("You called their bluff and were correct ! They were removed from the game");
            } else {
                playerCurrentBid.removeDie();
                reOrderTurnList(playerCurrentBid);
                displayTurnOrder();
                Console.displayMessage("You called their bluff and were correct ! They lose a die");
            }
        } else {
            if (!currentPlayer.canRemoveDie()) {
                playerList.remove(currentPlayer);
                Console.displayMessage("You called their bluff and were wrong ! You were removed from the game");
            } else {
                currentPlayer.removeDie();
                reOrderTurnList(currentPlayer);
                displayTurnOrder();
                Console.displayMessage("You called their bluff and were wrong ! You lose a die");
            }
        }
    }

    private boolean isValidBid(String bid) {
        String[] result = bid.split(" x");
        int frequency = -1;
        int faceUpValue = -1;

        if (result.length > 2) {
            return false;
        }
        frequency = Integer.parseInt(result[1]);
        faceUpValue = Integer.parseInt(result[0]);

        if (frequency < playerCurrentBid.currentBid.frequency)
            return false;

        if (faceUpValue < playerCurrentBid.currentBid.faceUpValue &&
                frequency <= playerCurrentBid.currentBid.frequency)
            return false;

        return true;

    }

    private void determineOrder() {
        LinkedHashMap<Player, Integer> map = new LinkedHashMap<>();
        int max = 0;
        Die die = new Die();
        for (Player player : playerList) {
            Console.displayMessage(String.format("%n%s, please hit enter to roll your die.", player.name));
            Console.nextLine();
            die.roll();
            int value = die.faceUpValue;
            Console.displayMessage(String.format("%nYou rolled a %s ! %n", value));
            map.put(player, value);
            if (max < value) {
                max = value;
            }
        }
        boolean reRollNeeded = reRollNeeded(map, max);
        if (reRollNeeded) {
            turnOrder = reRoll(map, max);
        } else {
            turnOrder = new LinkedList<>(map.keySet());
        }
    }

    public LinkedList<Player> reRoll(LinkedHashMap<Player, Integer> map, int oldMax) {
        LinkedHashMap<Player, Integer> clone = new LinkedHashMap<>(map);
        boolean reRollNeeded = true;
        Die die = new Die();
        int newMax = 0;
        while (true) {
            if (reRollNeeded) {
                newMax = 0;
                for (Map.Entry entry : map.entrySet()) {
                    if ((Integer) entry.getValue() == oldMax) {
                        Player player = (Player) entry.getKey();
                        Console.displayMessage(String.format("%n%s, please hit enter to roll your die.", player.name));
                        Console.nextLine();
                        die.roll();
                        int value = die.faceUpValue;
                        Console.displayMessage(String.format("%nYou rolled a %s ! %n", value));
                        if (newMax == 0) {
                            newMax = value;
                            clone.clear();
                        }
                        if (newMax < value) {
                            newMax = value;
                        }
                        clone.put((Player) entry.getKey(), value);
                    }
                }
            } else {
                break;
            }
            reRollNeeded = reRollNeeded(clone, newMax);
        }
        map.putAll(clone);
        return new LinkedList<Player>(map.keySet());
    }

    private boolean reRollNeeded(LinkedHashMap<Player, Integer> map, int max) {
        int count = 0;
        List<Integer> indexToReRoll = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() == max) {
                count++;
            }
        }
        if (count > 1) return true;

        return false;
    }

    private void reOrderTurnList(Player firstPlayer) {
        turnOrder.remove(firstPlayer);
        turnOrder.addFirst(firstPlayer);
    }
    private void displayTurnOrder(){
        System.out.println(turnOrder);
    }
    private void displayAllDice() {
        System.out.println(freq);
    }
//    public void setTurnOrder() {
//        Die die = new Die();
//        Map<Player, Integer> playerRolls = new HashMap<>();
//        for (Player player : playerList) {
//            Console.displayMessage("Roll the die to determine order (Enter to roll)");
//            Console.nextLine();
//            die.roll();
//            Console.displayMessage(String.format("%n%nYou rolled a %s", die.faceUpValue));
//            playerRolls.put(player, die.faceUpValue);
//        }
//        Map<Integer, Map.Entry<Player, Integer>> map =  new HashMap<>();
//        int counter = 0;
//        for(Map.Entry entry: playerRolls.entrySet()){
//            map.put(counter, entry);
//            counter++;
//        }
//        playerRolls = sortByValue(playerRolls);
//        List<Integer> list = (List<Integer>) playerRolls.values();
//        if(map.get(0).getValue().equals(map.get(1).getValue())){
//            int counter = 0;
//            while(true){
//                if(counter > 1) counter = 0;
//                Console.displayMessage("Roll the die to determine order (Enter to roll)");
//                Console.nextLine();
//                die.roll();
//                Console.displayMessage(String.format("%n%nYou rolled a %s", die.faceUpValue));
//                map.put(counter);
//                counter++l
//            }
//        }
//
//    }
//
//    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
//        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
//        list.sort((Comparator<? super Map.Entry<K, V>>) Map.Entry.comparingByValue().reversed());
//
//        Map<K, V> result = new LinkedHashMap<>();
//        for (Map.Entry<K, V> entry : list) {
//            result.put(entry.getKey(), entry.getValue());
//        }
//
//        return result;
//    }
}
