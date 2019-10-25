/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

/**
 * Duel class generates the fighters and starts the fight
 *
 * @author kavya
 */
public class Duel {

    private final Fighter Gandalf = new Fighter();

    private final Fighter Merlin = new Fighter();

    private final Fighter Dumbledore = new Fighter();

    private static final Double GANDALF = 1.0 / 3.0;

    private static final Double MERLIN = 1.0 / 2.0;

    private static final Double DUMBLEDORE = 0.95;

    private int numberOfPeopleAlive = 3;

    private boolean isG = true, isM = false, isD = false;

    private int winsGandalf, winsMerlin, winsDumbledore;

    private boolean firstShot;

    private void setStrategy(boolean shot) {
        firstShot = shot;
    }

    private void resetFights() {
        winsGandalf = 0;
        winsMerlin = 0;
        winsDumbledore = 0;
    }

    /**
     * creates the three required fighters
     */
    public void generateFighters() {
        createFighter(Gandalf, "Gandalf", GANDALF);
        createFighter(Merlin, "Merlin", MERLIN);
        createFighter(Dumbledore, "Dumbledore", DUMBLEDORE);
    }

    private void createFighter(Fighter fighter, String name, Double shooting_accuracy) {
        fighter.setDetails(name, shooting_accuracy, true);
    }

    /**
     * startFight starts the fight
     *
     * @param shot sets if the first shot is to be intentionally missed
     */
    public void startFight(boolean shot) {
        for (int i = 0; i < 10000; i++) {
            setStrategy(shot);
            isM = true;
            while (numberOfPeopleAlive > 1) {
                if (Gandalf.isAlive() && isG && !firstShot) {

                    isG = false;
                    isM = true;
                    if (Dumbledore.isAlive()) {
                        Gandalf.shootAtTarget(Dumbledore);
                        checkDumbledoreLifeStatus();
                    } else if (Merlin.isAlive()) {
                        Gandalf.shootAtTarget(Merlin);
                        checkMerlinLifeStatus();
                    }

                } else if (Merlin.isAlive() && isM) {
                    isM = false;
                    isD = true;
                    if (Dumbledore.isAlive()) {
                        Merlin.shootAtTarget(Dumbledore);
                        checkLifeStatusDumbledoreSecond();
                    } else if (Gandalf.isAlive()) {
                        Merlin.shootAtTarget(Gandalf);
                        checkGandalfLifeStatus();
                    }
                } else if (Dumbledore.isAlive() && isD) {
                    isG = true;
                    firstShot = false;
                    isD = false;
                    if (Merlin.isAlive()) {
                        Dumbledore.shootAtTarget(Merlin);
                        checkMerlinLifeStatus();
                    } else if (Gandalf.isAlive()) {
                        Dumbledore.shootAtTarget(Gandalf);
                        checkGandalfLifeStatus();
                    }
                }
            }

            calculateWins();
            resetValues();
        }
        displayLeadershipTable();
        resetFights();
    }

    private void checkGandalfLifeStatus() {
        if (Gandalf.isAlive()) {
            isG = true;
        } else {
            numberOfPeopleAlive--;
            isG = false;
        }
    }

    private void checkDumbledoreLifeStatus() {
        if (Dumbledore.isAlive()) {
            isD = true;
        } else {
            numberOfPeopleAlive--;
            isD = false;
        }
    }

    private void checkMerlinLifeStatus() {
        if (Merlin.isAlive()) {
            isM = true;
        } else {
            numberOfPeopleAlive--;
            isM = false;
        }
    }

    private void checkLifeStatusDumbledoreSecond() {

        if (Dumbledore.isAlive()) {
            isD = true;
        } else {
            numberOfPeopleAlive--;
            isD = false;
            isG = true;
            firstShot = false;
        }

    }

    private void calculateWins() {
        if (Gandalf.isAlive()) {
            winsGandalf++;
        }

        if (Merlin.isAlive()) {
            winsMerlin++;
        }

        if (Dumbledore.isAlive()) {
            winsDumbledore++;
        }
    }

    private void resetValues() {
        isG = true;
        isM = false;
        isD = false;
        Gandalf.setAlive(true);
        Merlin.setAlive(true);
        Dumbledore.setAlive(true);
        numberOfPeopleAlive = 3;
    }

    /**
     * Displays the result of the Duel for both the strategies
     */
    public void displayLeadershipTable() {
        System.out.println("LEADERBOARD - AFTER 10000 DUELS");
        System.out.printf("%-20s%-20s%-20s\n", "Contestant", "Number of wins", "winning percentage(in %)");
        System.out.printf("%-20s%-20d%-20.2f\n", "Gandalf", winsGandalf, getPercentage(winsGandalf));
        System.out.printf("%-20s%-20d%-20.2f\n", "Merlin", winsMerlin, getPercentage(winsMerlin));
        System.out.printf("%-20s%-20d%-20.2f\n", "DumbleDore", winsDumbledore, getPercentage(winsDumbledore));

    }

    private double getPercentage(int wins) {
        double percent = (double) wins / 10000;
        return percent * 100;
    }

    /**
     * This method prints the best strategy and other details
     */
    public void printBestStrategy() {
        System.out.println("The second strategy of intentionally missing the "
                + "first shot is better for Gandalf.");
        System.out.println("In the first Strategy Merlin, an average shooter, "
                + "has better chances of winning.");
        System.out.println("In the second one Gandalf, worst shooter, has "
                + "better chances of winning.");
        System.out.println("Best Shooter is Dumbledore but because of the order"
                + " of the game, he is unlikely to win the duel.");

    }
}
