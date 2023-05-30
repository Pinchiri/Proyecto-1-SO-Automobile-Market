/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<<<<<<< HEAD
package classes;
package UserInterface.MainUI;
=======
package Classes;
>>>>>>> rolando

import UserInterface.MainUI;
import java.util.concurrent.Semaphore;



import UserInterface.MainUI;

/**
 *
 * @author Rolando
 */
public class VehiclePlant {
    String name;
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
<<<<<<< HEAD
    public MainUI interfaz;
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration, MainUI interfaz) {
=======
    public MainUI userInterface;
            
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration, MainUI userInterface) {
>>>>>>> rolando
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.workers = new Worker[maxWorkerQty];
<<<<<<< HEAD
        this.warehouse = new Warehouse(1,1,7,1,1,interfaz);
        this.mutex = new Semaphore(1);
        this.interfaz = interfaz;
        
        
=======
        this.warehouse = new Warehouse(25, 20, 55, 35, 10, userInterface);
        this.mutex = new Semaphore(1);
        this.userInterface = userInterface;
        
        this.maxWorkerQty = 1;
        this.chasisWorkers = 1;
        this.bodyWorkers = 1;
        this.motorWorkers = 1;
        this.wheelWorkers = 1;
        this.accessoryWorkers = 1;
        this.assemblers = 1;
>>>>>>> rolando
        
        
        
    }
    
   
    
    public void initializeWorkers(){
<<<<<<< HEAD
       /* for (int i = 0; i<this.maxWorkerQty; i++) { */
            Worker worker = new Worker(0.34f, 20, this.dayDurationInMs, "wheels", this);
            worker.start();
        /*    workers[i] = worker; */
       /* }*/
=======
        
        int arrayIndex = 0;
        //Chasis workers
        for (int i = 0; i < getChasisWorkers(); i++) {
            Worker worker = new Worker(0.34f, 20, getDayDurationInMs(), "chasis", this);
            worker.start();
            workers[arrayIndex] = worker;
            arrayIndex++;
        }
        
        //Car Body Workers
        for (int i = 0; i < getBodyWorkers(); i++) {
            Worker worker = new Worker(0.34f, 20, getDayDurationInMs(), "body", this);
            worker.start();
            workers[arrayIndex] = worker;
            arrayIndex++;
        }
        
        //Motor Workers
        for (int i = 0; i < getMotorWorkers(); i++) {
            Worker worker = new Worker(0.34f, 20, getDayDurationInMs(), "motor", this);
            worker.start();
            workers[arrayIndex] = worker;
            arrayIndex++;
        }
        

        //Car Body Workers
        for (int i = 0; i < getWheelWorkers(); i++) {
            Worker worker = new Worker(0.34f, 20, getDayDurationInMs(), "wheel", this);
            worker.start();
            workers[arrayIndex] = worker;
            arrayIndex++;
        }
        

        //Car Body Workers
        for (int i = 0; i < getAccessoryWorkers(); i++) {
            Worker worker = new Worker(0.34f, 20, getDayDurationInMs(), "accesory", this);
            worker.start();
            workers[arrayIndex] = worker;
            arrayIndex++;
        }
>>>>>>> rolando
    }
    
    
    public void PausaWorker(){
       
       for (int i = 0; i < workers.length; i++) {
            Worker worker = workers[i];
            worker.pausar();
        }
   
    }
    
    
    public void ResumeWorker(){
       
       for (int i = 0; i < workers.length; i++) {
            Worker worker = workers[i];
            worker.reanudar();
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
