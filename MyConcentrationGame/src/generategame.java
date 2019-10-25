/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 * This is a concentration game of cards
 *
 * @author Meeth
 * @version 1
 *
 */
public class generategame {

    /**
     * generates the game
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Board b = new Board();// b is the reference of the object type Board
        b.loadBoard();// load board with shuffled cards
        b.inputDollar();// fill the board with cards down
        b.dollarboard();// display board with cards down to the user
        b.playgame();// user plays the game

    }// end of main

}// end of generategame
