/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import UserInterface.MainUI;

/**
 *
 * @author Rolando
 */
public class Warehouse {
    public int chasisQty;
    public int carBodyQty;
    public int wheelsQty;
    public int motorQty;
    public int accessoryQty;
     
    public int maxChasisQty;
    public int maxCarBodyQty;
    public int maxWheelsQty;
    public int maxMotorQty;
    public int maxAccessoryQty;
    
    private MainUI userInterface;
    
    public Warehouse(int maxChasis, int maxCarBodyQty, int maxMotor, int maxWheels,  int maxAccessory, MainUI userInterface){
        this.maxChasisQty = maxChasis;
        this.maxCarBodyQty = maxCarBodyQty;
        this.maxWheelsQty = maxWheels;
        this.maxMotorQty = maxMotor;
        this.maxAccessoryQty = maxAccessory;
        this.userInterface = userInterface;
        
        this.chasisQty = 0;
        this.carBodyQty = 0;
        this.wheelsQty = 0;
        this.motorQty = 0;
        this.accessoryQty = 0;
        
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
                
                if (this.maxMotorQty < this.maxMotorQty) {
                    this.maxMotorQty += finishedPart;
                    
                    System.out.println(this.maxMotorQty);
                }
                
                break;
                
            case "accesory":
                
                if (this.accessoryQty < this.maxAccessoryQty) {
                    this.accessoryQty += finishedPart;
                    
                    System.out.println(this.accessoryQty);
                }
                
                break;
                
            case "carBody":
                if (this.carBodyQty < this.maxCarBodyQty) {
                    this.carBodyQty += finishedPart;
                    
                    System.out.println(this.carBodyQty);
                }
                
            default:
                break;
        }
    }
    
}
