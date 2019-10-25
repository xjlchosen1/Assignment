/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

import java.util.Random;

/**
 * Fighter class has the attributes related to the fighter
 *
 * @author kavya
 */
public class Fighter {

    private String name;

    private double accuracy;

    private boolean isAlive;

    private Double getProbability() {
        Random random = new Random();
        return random.nextDouble();
    }

    /**
     * sets the details of the fighter
     *
     * @param name name of the fighter
     * @param shooting_accuracy accuracy with which the fighter shoots
     * @param status if a fighter is dead or alive
     */
    public void setDetails(String name, double shooting_accuracy, boolean status) {
        setName(name);
        setAccuracy(shooting_accuracy);
        setAlive(status);
    }

    /**
     * this method shoots at the given target
     *
     * @param target a fighter at which a shot is taken
     */
    public void shootAtTarget(Fighter target) {
        Double probability = getProbability();
        if (probability <= accuracy) {
            target.setAlive(false);
        }
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name of the fighter
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return accuracy
     */
    public double getAccuracy() {
        return accuracy;
    }

    /**
     * sets accuracy
     *
     * @param accuracy
     */
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    /**
     *
     * @return isAlive
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * sets the life status
     *
     * @param alive
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}
