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
        int amountOfDice = 0;
        do {
            numberOfPlayers = Console.getNumberInput("How many players are playing? ");
            Console.nextLine();
        } while (numberOfPlayers < MIN_PLAYERS || numberOfPlayers > MAX_PLAYERS);
        amountOfDice = Console.getNumberInput("\nHow many dice per player ?");
        Console.nextLine();
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = Console.getStringInput("\nPlayer" + (i + 1) + " name: ");
            playerList.add(new Player(name, new Cup(amountOfDice)));
        }
        playerCurrentBid = new Player("temp", new Cup(0));
        playerCurrentBid.makeBid(new int[]{0,1});
        determineOrder();
        displayTurnOrder();
    }

    public void runGame() {
        while (playerList.size() > 1) {
            runRound();

        }
        Console.displayMessage(String.format("%s, was the last player standing, They win the game !", playerList.get(0).name));
    }
    private void runRound() {
        boolean isRoundDone = false;
        int counter = 0;
        rollAllDice();
        doFrequency();
        while (true) {
            for (int i = 0; i < turnOrder.size(); i++) {
                Console.displayMessage(String.format("%nIt is now %s's turn !%n", turnOrder.get(i).name));
                if (playerCurrentBid != null) {
                    showCurrentBid();
                }
                Console.displayMessage("\nHere is/are your die/dice:\n");
                turnOrder.get(i).cup.displayDice();
                Console.displayMessage("\n\n");
                if (counter == 0) {
                    showRemainingPlayers();
                    showDiceCount();
                    isRoundDone = runTurn(turnOrder.get(i), true);
                    Console.clearBoard();
                } else {
                    showRemainingPlayers();
                    showDiceCount();
                    isRoundDone = runTurn(turnOrder.get(i), false);
                    Console.clearBoard();
                }
                if (isRoundDone) break;
                if ((i + 1) == turnOrder.size()) i = 0;
                counter++;
            }
            if (isRoundDone) break;
        }
        playerCurrentBid = null;

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
        if (playerCurrentBid == null) {
            playerCurrentBid = new Player("temp", new Cup(0));
            playerCurrentBid.makeBid(new int[]{0,1});
        }
        do {
            String result = Console.getStringInput("Please enter the die face up value and frequency of the bid (Ex. 2 x3 or 6 x5): ");
            boolean isValid = isValidBid(result);
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
        int frequency = 0;
        if (freq.containsKey(playerCurrentBid.currentBid.faceUpValue)) {
            frequency = freq.get(playerCurrentBid.currentBid.faceUpValue);
        } else {
            removeDieCurrentBid(currentPlayer);
            return;
        }

        if (playerCurrentBid.currentBid.frequency > frequency) {
            removeDieCurrentBid(currentPlayer);
        } else {
            if (!currentPlayer.canRemoveDie()) {
                playerList.remove(currentPlayer);
                turnOrder.remove(playerCurrentBid);
                Console.displayMessage(String.format("%n---- %s called %s's bluff and was wrong ! %s was removed from the game ----", currentPlayer.name, playerCurrentBid.name, currentPlayer.name));
                Console.displayMessage(String.format("%nThe last bid was die: %s | frequency %s",
                        playerCurrentBid.currentBid.faceUpValue, playerCurrentBid.currentBid.frequency));
            } else {
                currentPlayer.removeDie();
                reOrderTurnList(currentPlayer);
                displayTurnOrder();
                Console.displayMessage(String.format("%n---- %s called %s's bluff and was wrong ! %s loses a die ----", currentPlayer.name, playerCurrentBid.name, currentPlayer.name));
                Console.displayMessage(String.format("%nThe last bid was die: %s | frequency %s",
                        playerCurrentBid.currentBid.faceUpValue, playerCurrentBid.currentBid.frequency));
            }
        }
    }

    private boolean isValidBid(String bid) {
        String[] result = bid.split(" x");
        int frequency = -1;
        int faceUpValue = -1;

        if (result.length != 2) {
            return false;
        }
        frequency = Integer.parseInt(result[1]);
        faceUpValue = Integer.parseInt(result[0]);

        if (frequency < playerCurrentBid.currentBid.frequency) {
            Console.displayMessage("\nThe frequency of the bid needs to be increased\n");
            return false;
        }

        if (faceUpValue <= playerCurrentBid.currentBid.faceUpValue &&
                frequency <= playerCurrentBid.currentBid.frequency) {
            Console.displayMessage("\nThe frequency or the face up value of the bid needs to be increased\n");
            return false;
        }

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
            reRoll(map, max);
        } else {
            map = sortByValue(map);
            turnOrder = new LinkedList<>(map.keySet());
        }
    }

    private void reRoll(LinkedHashMap<Player, Integer> map, int oldMax) {
        LinkedHashMap<Player, Integer> reRollers = new LinkedHashMap<>(map);
        LinkedHashMap<Player, Integer> nonReRollers = new LinkedHashMap<>(map);
        boolean reRollNeeded = true;
        Die die = new Die();
        int newMax = 0;
        while (true) {
            if (reRollNeeded) {
                newMax = 0;
                for (Map.Entry entry : map.entrySet()) {
                    if ((Integer) entry.getValue() == oldMax) {
                        nonReRollers.remove((Player) entry.getKey());
                        Player player = (Player) entry.getKey();
                        Console.displayMessage(String.format("%n%s, please hit enter to roll your die.", player.name));
                        Console.nextLine();
                        die.roll();
                        int value = die.faceUpValue;
                        Console.displayMessage(String.format("%nYou rolled a %s ! %n", value));
                        if (newMax == 0) {
                            newMax = value;
                            reRollers.clear();
                        }
                        if (newMax < value) {
                            newMax = value;
                        }
                        reRollers.put((Player) entry.getKey(), value);
                    }
                }
            } else {
                break;
            }
            reRollNeeded = reRollNeeded(reRollers, newMax);
        }
        sortByValue(reRollers);
        setTurnOrder(reRollers);
        sortByValue(nonReRollers);
        setTurnOrder(nonReRollers);
    }

    private void setTurnOrder(LinkedHashMap<Player, Integer> map) {
        if (turnOrder == null) turnOrder = new LinkedList<>();
        for (Map.Entry entry : map.entrySet()) {
            turnOrder.add((Player) entry.getKey());
        }
    }

    private boolean reRollNeeded(LinkedHashMap<Player, Integer> map, int max) {
        int count = 0;
        List<String> names = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer) entry.getValue() == max) {
                names.add(entry.getKey().toString());
                count++;
            }
        }
        if (names.size() > 1) {
            Console.displayMessage("\nThere was a tie, these players need to re-roll: \n");
            for (String name : names) {
                Console.displayMessage(name + "\n");
            }
            Console.nextLine();
            return true;
        }

        return false;
    }

    private void reOrderTurnList(Player firstPlayer) {
        turnOrder.remove(firstPlayer);
        turnOrder.addFirst(firstPlayer);
    }

    private void displayTurnOrder() {
        Console.displayMessage("\nTurn order: \n");
        for (Player player : turnOrder) {
            Console.displayMessage(player.name + "\n");
        }

    }

    private <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortByValue(LinkedHashMap<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (Map.Entry e1, Map.Entry e2) -> (Integer) e2.getValue() - (Integer) e1.getValue());

        LinkedHashMap<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private void showDiceCount() {
        int counter = 0;
        for (Player player : turnOrder) {
            counter += player.cup.dice.size();
        }
        Console.displayMessage(String.format("%nThere are %s dice on the board.%n%n", counter));
    }

    private void showRemainingPlayers() {
        for (Player player : turnOrder) {
            Console.displayMessage(String.format("[Player: %s | DiceRemaining: %s] \t", player.name, player.cup.dice.size()));
        }
        Console.displayMessage("\n\n");
    }

    private void showCurrentBid() {
        Console.displayMessage(String.format("%nCurrent bid is: die[%s], frequency[%s]%n",
                playerCurrentBid.currentBid.faceUpValue, playerCurrentBid.currentBid.frequency));
    }

    private void removeDieCurrentBid(Player currentPlayer) {
        if (!playerCurrentBid.canRemoveDie()) {
            playerList.remove(playerCurrentBid);
            turnOrder.remove(playerCurrentBid);
            Console.displayMessage(String.format("%n---- %s called %s's bluff and was right ! %s was removed from the game ----", currentPlayer.name, playerCurrentBid.name, playerCurrentBid.name));
            Console.displayMessage(String.format("%nThe last bid was die: %s | frequency %s",
                    playerCurrentBid.currentBid.faceUpValue, playerCurrentBid.currentBid.frequency));
        } else {
            playerCurrentBid.removeDie();
            reOrderTurnList(playerCurrentBid);
            displayTurnOrder();
            Console.displayMessage(String.format("%n---- %s called %s's bluff and was right ! %s loses a die -----", currentPlayer.name, playerCurrentBid.name, playerCurrentBid.name));
            Console.displayMessage(String.format("%nThe last bid was die: %s | frequency %s",
                    playerCurrentBid.currentBid.faceUpValue, playerCurrentBid.currentBid.frequency));
        }

    }
}
