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
    private int dias = 0;
    
    public PlantDirector(float salary, int dayduration, VehiclePlant plant, MainUI userInterface,OperationsManager manager, Warehouse warehouse) {
        this.salary = salary;
        this.daydurantion = dayduration;
        this.accSalary = 0;
        this.manager = manager;
        this.userInterface = userInterface;
        this.warehouse = warehouse;
        
        
       }
    
    @Override
    public void run(){
        
        System.out.println("Comenzo director");
     
        while (true) {
             try {
            
            
            synchronized(this){
            while(pausar==true){
                    System.out.println("");
                }    
            }  
            
            Thread.sleep(daydurantion);
            
            if(this.manager.daysLeft == 0){
          
                this.dias = config.getDeliveryDays();
                System.out.println(this.dias);
                this.userInterface.daysLeftLamborghini(Integer.toString(this.dias));
                this.userInterface.lambEarnings("$" + Long.toString(warehouse.getTotalEarnings()));
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
    
    
}
