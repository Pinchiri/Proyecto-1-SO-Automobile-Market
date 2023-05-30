/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Rolando
 */
public class Config {
    
    private int dayDuration;
    private int deliveryDays;
    private int initialChasis;
    private int initialWheels;
    private int initialMotors;
    private int initialAccesorys;

    //Constructor
    public Config(int dayDuration, int deliveryDays, int initialChasis, int initialWheels, int initialMotors, int initialAccesorys) {
        this.dayDuration = dayDuration;
        this.deliveryDays = deliveryDays;
        this.initialChasis = initialChasis;
        this.initialWheels = initialWheels;
        this.initialMotors = initialMotors;
        this.initialAccesorys = initialAccesorys;
    }
    
    //Getters and Setters
    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public int getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(int deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public int getInitialChasis() {
        return initialChasis;
    }

    public void setInitialChasis(int initialChasis) {
        this.initialChasis = initialChasis;
    }

    public int getInitialWheels() {
        return initialWheels;
    }

    public void setInitialWheels(int initialWheels) {
        this.initialWheels = initialWheels;
    }

    public int getInitialMotors() {
        return initialMotors;
    }

    public void setInitialMotors(int initialMotors) {
        this.initialMotors = initialMotors;
    }

    public int getInitialAccesorys() {
        return initialAccesorys;
    }

    public void setInitialAccesorys(int initialAccesorys) {
        this.initialAccesorys = initialAccesorys;
    }
    
    
}
