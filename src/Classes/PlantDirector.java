/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import UserInterface.MainUI;
import static UserInterface.MainUI.config;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rolando
 */
public class PlantDirector extends Thread {
    
    private float salary;
    private float ganancialote;
    private float accSalary;
    private VehiclePlant plant;
    private MainUI userInterface;
    private OperationsManager manager;
    private Warehouse warehouse;
    private int daydurantion;
    private boolean pausar = false;
    
    
    public PlantDirector(float salary, int dayduration, VehiclePlant plant, MainUI userInterface,OperationsManager manager, Warehouse warehouse) {
        this.salary = salary;
        this.daydurantion = dayduration;
        this.accSalary = 0;
        this.manager = manager;
        this.userInterface = userInterface;
        this.warehouse = warehouse;
        
        
       }
    
    
    public void run(){    
     
        while (true) {
             try {
            
            
            synchronized(this){
            while(pausar==true){
                    System.out.println("");
                }    
            }  
            
            sleep(daydurantion);
            
            if(manager.daysLeft == 0){
                resetdays();
                this.userInterface.DayLeftLamborghini(Integer.toString(manager.daysLeft));
            }else{
                /* 
                
                Codigo para revisar el project manager
                
                
                */
            }
            
            
            
            } catch (InterruptedException ex) {
                Logger.getLogger(OperationsManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }
    
    public void pausar(){
        this.pausar = true;
    }
    
    public void reanudar(){
        this.pausar = false;
    }
 

    public void payCheck() {
        this.accSalary += this.salary;
    }
    
    public void resetdays(){
        manager.daysLeft = config.getDeliveryDays();
    }
}
