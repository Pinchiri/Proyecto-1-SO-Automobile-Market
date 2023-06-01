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
    public int daysLeft;
    private float accSalary;
    private int dayDurationInMs;
    private VehiclePlant plant;
    private MainUI userInterface;
    private int dayduration;
    private String nameplant;
    public float acummulatedTime = 0;
    public Config configurar;

    public OperationsManager(float salary, int daysLeft, VehiclePlant plant, MainUI userInterface,int dayduration,String nameplant,Config configurar) {
        this.salary = salary;
        this.sixteenHours = 16;
        this.idle = false;
        this.configurar = configurar;
        
        
        this.daysLeft = daysLeft;
        this.accSalary = 0;
        this.plant = plant;
        this.userInterface = userInterface;
        this.dayduration = dayduration;
        this.nameplant = nameplant;
        
        this.configurar = new Config();
        
    }
    
    @Override
    public void run(){
        
        
     
        while (true) {
            try {
            
           // this.userInterface.lambCosts(Long.toString(calculateCosts()));
           acummulatedTime = 0;
           
           
           payCheck();
           
           while (acummulatedTime < (this.dayduration*0.67)) {
          
         if(nameplant.equals("Lamborghini")){      
            if (idle) {
                acummulatedTime += dayduration*0.0208;
                idle = false;
                Thread.sleep((long) (dayduration*0.0208));
                userInterface.managerStatusL("Watching Formula 1");
                
            } else {
                acummulatedTime += dayduration*0.0208;
                idle = true; 
                Thread.sleep((long) (dayduration*0.0208));
                userInterface.managerStatusL("Working accountability");
                
            }
           
                
         }else {
             if (idle) {
                acummulatedTime += dayduration*0.0208;
                idle = false;
                Thread.sleep((long) (dayduration*0.0208));
                userInterface.managerStatusM1("Watching Formula 1");
                
            } else {
                acummulatedTime += dayduration*0.0208;
                idle = true; 
                Thread.sleep((long) (dayduration*0.0208));
                userInterface.managerStatusM1("Working accountability");
                
            }
           
         }            
          
      }
           
            
            
            
            this.daysLeft--;
            
            if(nameplant.equals("Lamborghini")){
                this.userInterface.daysLeftLamborghini(Integer.toString(this.daysLeft));
                userInterface.managerStatusL("Changing days"); 
            }else{
                this.userInterface.DaysLeftMaserati(Integer.toString(this.daysLeft));
                userInterface.managerStatusM1("Changing days");
            }
            Thread.sleep((long) (this.dayduration*0.33));
           
            
            } catch (InterruptedException ex) {
                Logger.getLogger(OperationsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    
    public void resetdays(){
  
        daysLeft = configurar.getDeliveryDays();
       
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
    
    public void payCheck() {
        this.accSalary += this.salary*24;
    }
    
    public void ResetSalario(){
        this.accSalary = 0;
    }
   
    
    
    
   
}
