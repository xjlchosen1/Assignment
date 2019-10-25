/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 * contains cards
 *
 * @author Meeth
 */
public class Cards {

    /**
     * a class of cards
     */
    ArrayList<String> cards = new ArrayList<>(16);

    /**
     * a list of cards to play
     *
     * @return cards
     */
    public ArrayList<String> getcards() {
        cards.add("A");
        cards.add("A");
        cards.add("K");
        cards.add("K");
        cards.add("Q");
        cards.add("Q");
        cards.add("J");
        cards.add("J");
        cards.add("9");
        cards.add("9");
        cards.add("6");
        cards.add("6");
        cards.add("5");
        cards.add("5");
        cards.add("2");
        cards.add("2");
        Collections.shuffle(cards);

        return cards;
    }

}
