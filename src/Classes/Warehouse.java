/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

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
    public int carstandar;
    public int carwithaccesory;
     
    public int maxChasisQty;
    public int maxCarBodyQty;
    public int maxWheelsQty;
    public int maxMotorQty;
    public int maxAccessoryQty;
    public String nameplant;
    public int contador = 0;


    private MainUI userInterface;
    
    public Warehouse(String nameplant,int maxChasis, int maxCarBodyQty, int maxMotor, int maxWheels,  int maxAccessory, MainUI userInterface){

        this.maxChasisQty = maxChasis;
        this.maxCarBodyQty = maxCarBodyQty;
        this.maxWheelsQty = maxWheels;
        this.maxMotorQty = maxMotor;
        this.maxAccessoryQty = maxAccessory;
        this.nameplant = nameplant;


        this.userInterface = userInterface;

        
        this.chasisQty = 0;
        this.carBodyQty = 0;
        this.wheelsQty = 0;
        this.motorQty = 0;
        this.accessoryQty = 0;
        this.carstandar = 0;
        this.carwithaccesory = 0;
        
    }
    
    public void test(){
        System.out.println("Estoy en warehouse");
    }
    
    public void updateStorage(String workerType, int finishedPart) {
        
        switch (workerType) {
            
            case "assembler":
                
                if(nameplant == "Lamborghini"){
                    if(contador>3) {
                        if (this.carBodyQty >= 1 && this.chasisQty >= 2 && this.motorQty >= 6 && this.wheelsQty >= 5 && this.accessoryQty >= 1) {
                                contador = 0;
                                this.carwithaccesory++;
                                this.carBodyQty = this.carBodyQty - 4;
                                this.chasisQty = this.chasisQty - 2;
                                this.motorQty = this.motorQty - 6;
                                this.wheelsQty = this.wheelsQty - 5;
                                this.accessoryQty = this.accessoryQty - 1;
                             
                        }else {
                                System.out.println("");
                         }
                    }else {
                        if(this.carBodyQty >= 1 && this.chasisQty >= 2 && this.motorQty >= 6 && this.wheelsQty >= 5) {
                                contador++;
                                System.out.println("LLEGO");
                                this.carstandar++;
                                userInterface.LamborghiniAssembler(Integer.toString(this.carstandar));
                                this.carBodyQty = this.carBodyQty - 4;
                                this.chasisQty = this.chasisQty - 2;
                                this.motorQty = this.motorQty - 6;
                                this.wheelsQty = this.wheelsQty - 5;
                                
                                
                                
                        }else {
                           System.out.println("");
                         }
                        
                    }
                }else{
                    if(contador>2) {
                        if (this.carBodyQty >= 1 && this.chasisQty >= 1 && this.motorQty >= 2 && this.wheelsQty >= 4 && this.accessoryQty >= 3) {
                                contador = 0;
                                this.carwithaccesory++;
                                this.carBodyQty = this.carBodyQty - 1;
                                this.chasisQty = this.chasisQty - 1;
                                this.motorQty = this.motorQty - 2;
                                this.wheelsQty = this.wheelsQty - 4;
                                this.accessoryQty = this.accessoryQty - 3;
                        }else {
                                System.out.println("");
                         }
                    }else {
                        if(this.carBodyQty >= 1 && this.chasisQty >= 1 && this.motorQty >= 2 && this.wheelsQty >= 4) {
                                contador++;
                                this.carstandar++;
                                this.carBodyQty = this.carBodyQty - 1;
                                this.chasisQty = this.chasisQty - 1;
                                this.motorQty = this.motorQty - 2;
                                this.wheelsQty = this.wheelsQty - 4;
                                 System.out.println("LLEGO2");
                                
                        }else {
                           System.out.println("");
                         }
                        
                }
                }
                
               
                
                
                break;
            
            case "chasis":
                
                if (this.chasisQty < this.maxChasisQty) {
                    this.chasisQty += finishedPart;
                    
            
                    
                    
                    userInterface.LamborghiniChasis(Integer.toString(this.chasisQty));
                }
                
                
                break;
            case "wheel":
                
                if (this.wheelsQty < this.maxWheelsQty) {
                    this.wheelsQty += finishedPart;
                    String wheels = Integer.toString(this.wheelsQty);
                    
       
                    
                    userInterface.LamborghiniWheels(Integer.toString(this.wheelsQty));
                    
                   
                    
                }
                
 
                break;
                
            case "motors":
                
                if (this.motorQty < this.maxMotorQty) {
                    this.motorQty += finishedPart;
                    

                    userInterface.LamborghiniMotor(Integer.toString(this.motorQty));
                }
                
                break;
                
            case "accesory":
                
                if (this.accessoryQty < this.maxAccessoryQty) {
                    this.accessoryQty += finishedPart;
                    
                 
                    userInterface.LamborghiniAccesory(Integer.toString(this.accessoryQty));
                }
                
                break;
                
            case "carBody":
                if (this.carBodyQty < this.maxCarBodyQty) {
                    this.carBodyQty += finishedPart;
                    
                 
                    userInterface.LamborghinicarBody(Integer.toString(this.carBodyQty));

                }
                
            default:
                break;
        }
    }
    
}
