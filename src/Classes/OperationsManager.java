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
 * @author Andres
 */
public class OperationsManager extends Thread {
    
    private float salary;
    private boolean idle;
    private int sixteenHours;
    public static int daysLeft;
    private float accSalary;
    private int dayDurationInMs;
    private VehiclePlant plant;
    private MainUI userInterface;
    private int dayduration;
    private String nameplant;

    public OperationsManager(float salary, int daysLeft, VehiclePlant plant, MainUI userInterface,int dayduration,String nameplant) {
        this.salary = salary;
        this.sixteenHours = 16;
        this.idle = false;
        this.daysLeft = daysLeft;
        this.accSalary = 0;
        this.plant = plant;
        this.userInterface = userInterface;
        this.dayduration = dayduration;
        this.nameplant = nameplant;
        
    }
    
    @Override
    public void run(){
        
        
     
        while (true) {
            try {
            
           // this.userInterface.lambCosts(Long.toString(calculateCosts()));
            Thread.sleep(dayduration);
            
            this.daysLeft--;
            
            if(nameplant.equals("Lamborghini")){
                this.userInterface.daysLeftLamborghini(Integer.toString(daysLeft));
            }else{
                this.userInterface.DaysLeftMaserati(Integer.toString(daysLeft));
            }
            
           
            
            } catch (InterruptedException ex) {
                Logger.getLogger(OperationsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public long calculateCosts() throws InterruptedException {
        
        long totalCosts = 0;
        
        for (int i = 0; i < plant.getWorkers().length; i++) {
            totalCosts += plant.getWorkers()[i].getAccSalary();
        }
        return totalCosts;
    }
    
    public void resetdays(){
        
       daysLeft = 30;
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
