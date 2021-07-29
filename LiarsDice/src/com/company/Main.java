package com.company;

public class Main {
    /**
     *
     * TODO
     *  fix the determining of the turnOrder when a re roll is necessary
     *      - The highest roller ends up behind the second highest roller
     *  refactor code
     *
     */
    public static void main(String[] args) {
	    LiarsDice game = new LiarsDice();
	    game.runGame();
    }
}
