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
    
    //General
    private int dayDuration;
    private int deliveryDays;
    //Lamborghini
    private int initialChasis;
    private int initialWheels;
    private int initialMotors;
    private int initialAccesorys;
    private int initialAssemblers;
    //Maserati
    private int initialChasisM;
    private int initialWheelsM;
    private int initialMotorsM;
    private int initialAccesorysM;
    private int initialAssemblersM;

    public Config(int dayDuration, int deliveryDays, int initialChasis, int initialWheels, int initialMotors, int initialAccesorys, int initialAssemblers, int initialChasisM, int initialWheelsM, int initialMotorsM, int initialAccesorysM, int initialAssemblersM) {
        this.dayDuration = dayDuration;
        this.deliveryDays = deliveryDays;
        this.initialChasis = initialChasis;
        this.initialWheels = initialWheels;
        this.initialMotors = initialMotors;
        this.initialAccesorys = initialAccesorys;
        this.initialAssemblers = initialAssemblers;
        this.initialChasisM = initialChasisM;
        this.initialWheelsM = initialWheelsM;
        this.initialMotorsM = initialMotorsM;
        this.initialAccesorysM = initialAccesorysM;
        this.initialAssemblersM = initialAssemblersM;
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

    public int getInitialAssemblers() {
        return initialAssemblers;
    }

    public void setInitialAssemblers(int initialAssemblers) {
        this.initialAssemblers = initialAssemblers;
    }

    public int getInitialChasisM() {
        return initialChasisM;
    }

    public void setInitialChasisM(int initialChasisM) {
        this.initialChasisM = initialChasisM;
    }

    public int getInitialWheelsM() {
        return initialWheelsM;
    }

    public void setInitialWheelsM(int initialWheelsM) {
        this.initialWheelsM = initialWheelsM;
    }

    public int getInitialMotorsM() {
        return initialMotorsM;
    }

    public void setInitialMotorsM(int initialMotorsM) {
        this.initialMotorsM = initialMotorsM;
    }

    public int getInitialAccesorysM() {
        return initialAccesorysM;
    }

    public void setInitialAccesorysM(int initialAccesorysM) {
        this.initialAccesorysM = initialAccesorysM;
    }

    public int getInitialAssemblersM() {
        return initialAssemblersM;
    }

    public void setInitialAssemblersM(int initialAssemblersM) {
        this.initialAssemblersM = initialAssemblersM;
    }
    
    
}
