/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import UserInterface.MainUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rolando
 */
public class OperationsManager extends Thread {
    
    private float salary;
    private boolean idle;
    private int sixteenHours;
    private int daysLeft;
    private float accSalary;
    private int dayDurationInMs;
    private VehiclePlant plant;
    private MainUI userInterface;

    public OperationsManager(float salary, int daysLeft, VehiclePlant plant, MainUI userInterface) {
        this.salary = salary;
        this.sixteenHours = 16;
        this.idle = false;
        this.daysLeft = daysLeft;
        this.accSalary = 0;
        this.plant = plant;
    }
    
    @Override
    public void run(){
        
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (true) {
            try {
            
            this.userInterface.lambCosts(Long.toString(calculateCosts()));
            sleep(getDayDurationInMs());
            
            
            } catch (InterruptedException ex) {
                Logger.getLogger(OperationsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public long calculateCosts() {
        
        long totalCosts = 0;
        
        for (int i = 0; i < plant.getWorkers().length; i++) {
            totalCosts += plant.getWorkers()[i].getAccSalary();
        }
        return totalCosts;
    }
    
    //Getters and Setters
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public float getAccSalary() {
        return accSalary;
    }

    public void setAccSalary(float accSalary) {
        this.accSalary = accSalary;
    }

    public int getDayDurationInMs() {
        return dayDurationInMs;
    }

    public void setDayDurationInMs(int dayDurationInMs) {
        this.dayDurationInMs = dayDurationInMs;
    }
   
    
    
    
   
}
