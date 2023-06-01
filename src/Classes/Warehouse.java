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
    public int carStandard;
    public int carWithAccesory;
    
    public long totalEarnings;
     
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

        this.totalEarnings = 0;

        this.userInterface = userInterface;

        
        this.chasisQty = 0;
        this.carBodyQty = 0;
        this.wheelsQty = 0;
        this.motorQty = 0;
        this.accessoryQty = 0;
        this.carStandard = 0;
        this.carWithAccesory = 0;
        
    }

    public void updateStorage(String workerType, int finishedPart) {
        
        switch (workerType) {
            
            case "assembler":
                
                if(nameplant.equals("Lamborghini")){
                    if(contador == 3) {
                        if ((this.carBodyQty >= 1) && (this.chasisQty >= 2) && (this.motorQty >= 6) && (this.wheelsQty >= 5) && (this.accessoryQty >= 1)) {
                                contador = 0;
                                this.carWithAccesory++;
                                totalEarnings += 750000;
                                
                                
                                this.userInterface.LamborghiniAC(Integer.toString(this.carWithAccesory));
                                this.carBodyQty = this.carBodyQty - 4;
                                this.chasisQty = this.chasisQty - 2;
                                this.motorQty = this.motorQty - 6;
                                this.wheelsQty = this.wheelsQty - 5;
                                this.accessoryQty = this.accessoryQty - 1;
                             
                        }else {
                                System.out.println("");
                         }
                    }else {
                        if((this.carBodyQty >= 1) && (this.chasisQty >= 2) && (this.motorQty >= 6) && (this.wheelsQty >= 5)) {
                                contador++;
                                this.carStandard++;
                                totalEarnings += 400000;
                                
                                
                                this.userInterface.LamborghiniSC(Integer.toString(this.carStandard));
  
                                this.carBodyQty = this.carBodyQty - 4;
                                this.chasisQty = this.chasisQty - 2;
                                this.motorQty = this.motorQty - 6;
                                this.wheelsQty = this.wheelsQty - 5;
                                
                                
                                
                        }else {
                           System.out.println("");
                         }
                        
                    }
                }else{
                    
                    if(contador == 2) {
                        if ((this.carBodyQty >= 1) && (this.chasisQty >= 1) && (this.motorQty >= 2) && (this.wheelsQty >= 4) && (this.accessoryQty >= 3)) {
                                contador = 0;
                                this.carWithAccesory++;
                                totalEarnings += 700000;
                           
                                
                                this.userInterface.MaseAC(Integer.toString(this.carWithAccesory));
                                this.carBodyQty = this.carBodyQty - 1;
                                this.chasisQty = this.chasisQty - 1;
                                this.motorQty = this.motorQty - 2;
                                this.wheelsQty = this.wheelsQty - 4;
                                this.accessoryQty = this.accessoryQty - 3;
                        }else {
                                System.out.println("");
                         }
                    }else {
                        if((this.carBodyQty >= 1) && (this.chasisQty >= 1) && (this.motorQty >= 2) && (this.wheelsQty >= 4)) {
                                contador++;
                                this.carStandard++;
                                totalEarnings += 350000;
                              
                                
                                this.userInterface.MaseSC(Integer.toString(this.carStandard));
                                
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
                    
                    if (this.nameplant.equals("Lamborghini")) {
                        userInterface.LamborghiniChasis(Integer.toString(this.chasisQty));
                    } else {
                        userInterface.MaseChasis(Integer.toString(this.chasisQty));
                    }
                    
                }
                break;
                
            case "wheel":
                
                if (this.wheelsQty < this.maxWheelsQty) {
                    this.wheelsQty += finishedPart;
                    
                    if(this.wheelsQty >= this.maxWheelsQty ){
                        this.wheelsQty = this.maxWheelsQty;
                    }
                    
                    if (this.nameplant.equals("Lamborghini")) {
                        userInterface.LamborghiniWheels(Integer.toString(this.wheelsQty));
                    } else {
                        userInterface.MaseWheels(Integer.toString(this.wheelsQty));
                    }   
                }
                
 
                break;
                
            case "motors":
                
                if (this.motorQty < this.maxMotorQty) {
                    this.motorQty += finishedPart;
                    
                    if (this.nameplant.equals("Lamborghini")) {
                        userInterface.LamborghiniMotor(Integer.toString(this.motorQty));
                    } else {
                        userInterface.MaseMotor(Integer.toString(this.motorQty));

                    }
                }
                
                break;
                
            case "accesory":
                
                if (this.accessoryQty < this.maxAccessoryQty) {
                    this.accessoryQty += finishedPart;
                    
                    if (this.nameplant.equals("Lamborghini")) {
                        userInterface.LamborghiniAccesory(Integer.toString(this.accessoryQty));

                    } else {
                        userInterface.MaseAccesory(Integer.toString(this.accessoryQty));  
                    }
                    
                }
                
                break;
                
            case "carBody":
                if (this.carBodyQty < this.maxCarBodyQty) {
                    this.carBodyQty += finishedPart;
                   
                    
                    if (this.nameplant.equals("Lamborghini")) {
                        userInterface.LamborghinicarBody(Integer.toString(this.carBodyQty));  
                    } else {
                        userInterface.MaseCarBody(Integer.toString(this.carBodyQty));  
                    }
                    

                }
                
            default:
                break;
        }
    }

    public long getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(long totalEarnings) {
        this.totalEarnings = totalEarnings;
    }    
    
}
