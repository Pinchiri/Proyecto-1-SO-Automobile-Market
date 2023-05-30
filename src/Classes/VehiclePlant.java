/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import UserInterface.MainUI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Rolando
 */
public class VehiclePlant {
    String name;
    private int maxWorkerQty;
    private Worker[] workers;
    private long dayDurationInMs;
    public Warehouse warehouse;
    public Semaphore mutex;
    public MainUI userInterface;
            
    
    public VehiclePlant (String name, int maxWorkers, long dayDuration, MainUI userInterface) {
        this.name = name;
        this.maxWorkerQty = maxWorkers;
        this.dayDurationInMs = dayDuration;
        this.workers = new Worker[maxWorkerQty];
        this.warehouse = new Warehouse(25, 20, 55, 35, 10, userInterface);
        this.mutex = new Semaphore(1);
        this.userInterface = userInterface;
        
        initializeWorkers();
        
        
    }
    
    public void initializeWorkers(){
        for (int i = 0; i < this.maxWorkerQty; i++) {
            Worker worker = new Worker(0.34f, 20, this.dayDurationInMs, "chasis", this);
            worker.start();
            workers[i] = worker;
        }
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
}
