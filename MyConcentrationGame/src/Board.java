/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Meeth
 * @version 1
 */
public class Board {

    PackOfCards p;// p is the reference type of the object of type PackOfCards

    /**
     * class of Board having PackOfCards as the attribute
     */
    public Board() {
        p = new PackOfCards();// p is initialized
        grid = new String[ROWS][COLUMNS];

    }

    /**
     * number of rows
     */
    public static final int ROWS = 4;      // number of rows

    /**
     * number of columns
     */
    public static final int COLUMNS = 4;      // number of columns

    int x1, y1, x2, y2;
    int count = 8;
    private final String[][] grid;                // the grid itself, a 2-D array of String

    private final String[][] dollar = new String[4][4];

    /**
     * loads the board with shuffled cards
     */
    public void loadBoard() {
        ArrayList<String> shuffle = new ArrayList<>();
        shuffle = p.c.getcards();
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = shuffle.get(index++);

            }
        }

    }

    /**
     * display board with cards
     */
    public void displayboard() {
        System.out.print("\t1" + "\t2" + "\t3" + "\t4" + "\n");
        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 4; j++) {

                System.out.print("\t" + grid[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * prompts the user to play the game
     */
    public void playgame() {

        while (count > 0) {
            userInput();

            System.out.print("\t1" + "\t2" + "\t3" + "\t4" + "\n");
            for (int i = 1; i <= 4; i++) {
                System.out.print(i);
                for (int j = 1; j <= 4; j++) {
                    if ((i == x1 && j == y1) || (i == x2 && j == y2)) {
                        System.out.print("\t" + grid[i - 1][j - 1]);
                    } else {

                        System.out.print("\t" + dollar[i - 1][j - 1]);
                    }

                }
                System.out.println();
            }
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
            }
            for (int k = 0; k < 30; k++) {
                System.out.println();
            }
            updateBoard();
        }

    }

    /**
     * loads the boards with cards faced down
     */
    public void dollarboard() {

        System.out.print("\t1" + "\t2" + "\t3" + "\t4" + "\n");
        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 4; j++) {
                System.out.print("\t" + dollar[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * fills the boards with dollar sign to hide the card identity
     */
    public void inputDollar() {
        for (int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                dollar[m][n] = "$";
            }
        }
    }

    /**
     * updates the board if cards chosen match
     */
    public void updateBoard() {

        if (grid[x1 - 1][y1 - 1].equals(grid[x2 - 1][y2 - 1])) {
            dollar[x1 - 1][y1 - 1] = grid[x1 - 1][y1 - 1];
            dollar[x2 - 1][y2 - 1] = grid[x2 - 1][y2 - 1];
            count--;

        }
        System.out.print("\t1" + "\t2" + "\t3" + "\t4" + "\n");
        for (int m = 0; m < 4; m++) {
            System.out.print(m + 1);
            for (int n = 0; n < 4; n++) {
                System.out.print("\t" + dollar[m][n]);
            }
            System.out.println();
        }

    }

    /**
     * asks the user to input the coordinates
     */
    public void userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first coordinate for the first card");
        y1 = sc.nextInt();
        while ((y1 < 1 || y1 > 4) && (y1 != 0)) {

            System.out.println("Incorrect input, please enter numbers between 1-4");

            y1 = sc.nextInt();
        }
        System.out.println("Enter second coordinate for first card");
        x1 = sc.nextInt();
        while ((x1 < 1 || x1 > 4 && x1 != 0)) {
            System.out.println("Incorrect input, please enter numbers between 1-4");

            x1 = sc.nextInt();
        }

        System.out.println("Enter first coordinate for the second card");
        y2 = sc.nextInt();
        while ((y2 < 1 || y2 > 4 && y2 != 0)) {
            System.out.println("Incorrect input, please enter numbers between 1-4");

            y2 = sc.nextInt();
        }
        System.out.println("Enter second coordinate for the second card");
        x2 = sc.nextInt();
        while ((x2 < 1 || x2 > 4 && x2 != 0)) {
            System.out.println("Incorrect input, please enter numbers between 1-4");

            x2 = sc.nextInt();
        }
        if (y1 == y2 && x1 == x2) {
            System.out.println("The same card is chosen twice");
            userInput();
        }
    }

    /*public void userInput() {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        x1 = Integer.parseInt((numbers[0]));
        y1 = Integer.parseInt((numbers[1]));
        x2 = Integer.parseInt((numbers[2]));
        y2 = Integer.parseInt((numbers[3]));
    }*/
}
