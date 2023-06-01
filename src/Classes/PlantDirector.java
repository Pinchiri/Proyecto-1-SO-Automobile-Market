/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import static Classes.OperationsManager.daysLeft;
import UserInterface.MainUI;
import static UserInterface.MainUI.config;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
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
    private String nameplant;
    
    public PlantDirector(float salary, int dayduration, VehiclePlant plant, MainUI userInterface,OperationsManager manager, Warehouse warehouse, String nameplant) {
        this.salary = salary;
        this.daydurantion = dayduration;
        this.accSalary = 0;
        this.manager = manager;
        this.userInterface = userInterface;
        this.warehouse = warehouse;
        this.nameplant = nameplant;
        
        
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



                    if(nameplant.equals("Lamborghini")){

                    this.userInterface.daysLeftLamborghini(Integer.toString(this.dias));
                    this.userInterface.lambEarnings("$" + Long.toString(warehouse.getTotalEarnings()));

                    manager.resetdays();
                
                } else {
                
                    this.userInterface.DaysLeftMaserati(Integer.toString(daysLeft));
                    this.userInterface.MaseEarnings("$" + Long.toString(warehouse.getTotalEarnings()));

                    manager.resetdays();

                    
                    
                }
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
