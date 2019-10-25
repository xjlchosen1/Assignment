/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

/**
 * StartDuel starts the fight
 *
 * @author kavya
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Duel duel = new Duel();
        duel.generateFighters();
        duel.startFight(false);
        System.out.println();
        duel.startFight(true);
        System.out.println();
        duel.printBestStrategy();
    }
}
