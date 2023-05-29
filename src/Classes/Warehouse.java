/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Rolando
 */
public class Warehouse {
    public int chasisQty;
    public int wheelsQty;
    public int motorQty;
    public int accesoryQty;
    
    
    public int maxChasisQty;
    public int maxWheelsQty;
    public int maxmotorQty;
    public int maxaccesoryQty;
    
    public Warehouse(int maxChasis, int maxWheels, int maxMotor, int maxAccesory){
        this.maxChasisQty = maxChasis;
        this.maxWheelsQty = maxWheels;
        this.maxmotorQty = maxMotor;
        this.maxaccesoryQty = maxAccesory;
        
        this.chasisQty = 0;
        this.wheelsQty = 0;
        this.motorQty = 0;
        this.accesoryQty = 0;
        
    }
    
    public void test(){
        System.out.println("Estoy en warehouse");
    }
    
    public void updateStorage(String workerType, int finishedPart) {
        
        switch (workerType) {
            case "chasis":
                
                if (this.chasisQty < this.maxChasisQty) {
                    this.chasisQty += finishedPart;
                    
                    System.out.println(this.chasisQty);
                }
                
                
                break;
            case "wheels":
                
                if (this.wheelsQty < this.maxWheelsQty) {
                    this.wheelsQty += finishedPart;
                    
                    System.out.println(this.wheelsQty);
                }
                
 
                break;
                
            case "motors":
                
                if (this.maxmotorQty < this.maxmotorQty) {
                    this.maxmotorQty += finishedPart;
                    
                    System.out.println(this.maxmotorQty);
                }
                
                break;
                
            case "accesory":
                
                if (this.accesoryQty < this.accesoryQty) {
                    this.accesoryQty += finishedPart;
                    
                    System.out.println(this.accesoryQty);
                }
                
                break;
        // el resto de contadores
            default:
                break;
        }
    }
    
}
