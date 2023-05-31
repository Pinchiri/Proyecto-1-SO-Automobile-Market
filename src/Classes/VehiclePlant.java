/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import UserInterface.MainUI;
import java.util.concurrent.Semaphore;



import UserInterface.MainUI;

/**
 *
 * @author Rolando
 */
public class VehiclePlant {
    private String name;
    //Workers
    private int maxWorkerQty;
    private int chasisWorkers;
    private int bodyWorkers;
    private int motorWorkers;
    private int wheelWorkers;
    private int accessoryWorkers;
    private int assemblers;
    private Worker[] workers;
    
    private long dayDurationInMs;
    public Warehouse warehouse;
    public Semaphore mutex;

    public MainUI userInterface;
    
    private Config config;
            
    
    public VehiclePlant (String name, MainUI userInterface, Config config) {

        this.config = config;
        this.name = name;
        this.dayDurationInMs = config.getDayDuration();
 
        this.warehouse = new Warehouse(name,25, 20, 55, 35, 10, userInterface);
        this.mutex = new Semaphore(1);
        this.userInterface = userInterface;

        
        if (getName().equals("Lamborghini")) {
            this.maxWorkerQty = 18;
            
        }
        else {
            this.maxWorkerQty = 10;

        }
        
        this.workers = new Worker[maxWorkerQty];
        
        this.chasisWorkers = 1;
        this.bodyWorkers = 1;
        this.motorWorkers = 1;
        this.wheelWorkers = 1;

        this.accessoryWorkers = 1;
        this.assemblers = 1;
        
        initializeWorkers();
          
    }
    
   
    
    public void initializeWorkers(){
        
        int arrayIndex = 0;
        
        OperationsManager manager = new OperationsManager(20, config.getDeliveryDays(), this, this.userInterface,config.getDayDuration(),this.name);
        PlantDirector director = new PlantDirector(30,config.getDayDuration(),this,this.userInterface,manager,this.warehouse,this.name);
        manager.start();
        director.start();
        

        //Chasis workers
        for (int i = 0; i < getChasisWorkers(); i++) {
            if (getName().equals("Lamborghini")) {
                Worker worker = new Worker(0.25f, 10, getDayDurationInMs(), "chasis",this);
                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            } else {
                Worker worker = new Worker(0.5f, 10, getDayDurationInMs(), "chasis",this);
                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            }
        }
       
        //Car Body Workers
        for (int i = 0; i <= getBodyWorkers(); i++) {
            if (getName().equals("Lamborghini")) {
                Worker worker = new Worker(0.25f, 20, getDayDurationInMs(), "carBody",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            } else {
                Worker worker = new Worker(0.5f, 20, getDayDurationInMs(), "carBody",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            }
  
        }
        
        
        //Motor Workers
        for (int i = 0; i < getMotorWorkers(); i++) {

            if (getName().equals("Lamborghini")) {
                Worker worker = new Worker(1f, 20, getDayDurationInMs(), "motors",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            } else {

                Worker worker = new Worker(3f, 20, getDayDurationInMs(), "motors",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            }

        }
        

        //Wheel Workers
        for (int i = 0; i < getWheelWorkers(); i++) {
            if (getName().equals("Lamborghini")) {

                Worker worker = new Worker(5f, 20, getDayDurationInMs(), "wheel",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            } else {

                Worker worker = new Worker(3f, 20, getDayDurationInMs(), "wheel",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            }
            
            //Operations Manager
            
            
        }
        
        //Accesory Workers
        for (int i = 0; i < getAccessoryWorkers(); i++) {
            if (getName().equals("Lamborghini")) {

                Worker worker = new Worker(0.5f, 20, getDayDurationInMs(), "accesory",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            } else {

                Worker worker = new Worker(0.34f, 20, getDayDurationInMs(), "accesory",this);

                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            }  
        }
        
        for (int i = 0; i < getAssemblers() ; i++) {
            if (getName().equals("Lamborghini")) {
                Worker worker = new Worker(0.5f, 20, getDayDurationInMs(), "assembler",this);
                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            } else {
                Worker worker = new Worker(0.34f, 20, getDayDurationInMs(), "assembler",this);
                worker.start();
                workers[arrayIndex] = worker;
                arrayIndex++;
            }
        }
        

    }
    
    
    
 
    
    public void ResumeWorker(){
       
       for (int i = 0; i < workers.length; i++) {
            Worker worker = workers[i];
            worker.reanudar();
        }
   
    }
    
     public void StopWorker(){
       
       for (int i = 0; i < workers.length; i++) {
            Worker worker = workers[i];
            worker.stop();
        }
   
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxWorkerQty() {
        return maxWorkerQty;
    }

    public void setMaxWorkerQty(int maxWorkerQty) {
        this.maxWorkerQty = maxWorkerQty;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public long getDayDurationInMs() {
        return dayDurationInMs;
    }

    public void setDayDurationInMs(long dayDurationInMs) {
        this.dayDurationInMs = dayDurationInMs;
    }

    public int getChasisWorkers() {
        return chasisWorkers;
    }

    public void setChasisWorkers(int chasisWorkers) {
        this.chasisWorkers = chasisWorkers;
    }

    public int getBodyWorkers() {
        return bodyWorkers;
    }

    public void setBodyWorkers(int bodyWorkers) {
        this.bodyWorkers = bodyWorkers;
    }

    public int getMotorWorkers() {
        return motorWorkers;
    }

    public void setMotorWorkers(int motorWorkers) {
        this.motorWorkers = motorWorkers;
    }

    public int getWheelWorkers() {
        return wheelWorkers;
    }

    public void setWheelWorkers(int wheelWorkers) {
        this.wheelWorkers = wheelWorkers;
    }

    public int getAccessoryWorkers() {
        return accessoryWorkers;
    }

    public void setAccessoryWorkers(int accessoryWorkers) {
        this.accessoryWorkers = accessoryWorkers;
    }

    public int getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(int assemblers) {
        this.assemblers = assemblers;
    }

    
    
}
