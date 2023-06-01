/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import UserInterface.MainUI;
import static UserInterface.MainUI.config;
import static java.lang.Thread.sleep;
import java.util.Random;
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
    private String nameplant;
    public float acummulatedTime = 0;
    private int salarioquitado = 0;
    private int fault = 0;
    private boolean capturado = false;
    private int costo = 0;
    private int ganancia = 0;
    private int utility = 0;
    

    
    
    
    public PlantDirector(float salary, int dayduration, VehiclePlant plant, MainUI userInterface,OperationsManager manager, Warehouse warehouse, String nameplant) {
        this.salary = salary;
        this.daydurantion = dayduration;
        this.accSalary = 0;
        this.manager = manager;
        this.userInterface = userInterface;
        this.warehouse = warehouse;
        this.plant = plant;
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
            payCheck();
            Thread.sleep(daydurantion);
            System.out.println(this.manager.daysLeft);
            
            if(this.manager.daysLeft <= 0){
          

                
                manager.resetdays();
            
                if(nameplant.equals("Lamborghini")){
                
                this.userInterface.daysLeftLamborghini(Integer.toString(this.manager.daysLeft));
                this.userInterface.lambEarnings("$" + Long.toString(warehouse.getTotalEarnings()));
                
                costo = this.warehouse.costototal;
                ganancia = (int) this.warehouse.getTotalEarnings();
                costo = costo - salarioquitado;
                this.salarioquitado = 0;
                this.fault = 0;
                
                utility = ganancia - costo;
                
                this.warehouse.resetcars();
                this.userInterface.MaseAC("0");
                this.userInterface.LamborghiniSC("0");
                
                this.userInterface.costsL(Integer.toString(costo));
                this.userInterface.UtilityL(Integer.toString(utility));
                this.userInterface.faultsQtyL(Integer.toString(this.fault));
                this.userInterface.managerSalaryDiscountL(Integer.toString(this.salarioquitado));
                
                
                
                
                
                
                this.userInterface.directorStatusL("Reiniciando lote");
                
                
                
                
                
                }else{
                
                this.userInterface.DaysLeftMaserati(Integer.toString(this.manager.daysLeft));
                this.userInterface.MaseEarnings("$" + Long.toString(warehouse.getTotalEarnings()));
                this.userInterface.directorStatusM("Reiniciando lote");
                
                costo = (int) this.plant.calculateCosts();
                costo = (int) (costo + this.manager.getAccSalary());
                costo = (int) (costo + this.accSalary);
                costo = costo - salarioquitado;
                this.salarioquitado = 0;
                this.fault = 0;
                
                this.manager.ResetSalario();
                this.accSalary = 0;
                
                
                ganancia = (int) this.warehouse.getTotalEarnings();
                
                utility = ganancia - costo;
                
                this.warehouse.resetcars();
                this.userInterface.MaseAC("0");
                this.userInterface.LamborghiniSC("0");
                
                this.userInterface.costsM(Integer.toString(costo));
                this.userInterface.UtilityM(Integer.toString(utility));
                this.userInterface.faultsQtyM1MS(Integer.toString(this.fault));
                this.userInterface.managerSalaryDiscountMS(Integer.toString(this.salarioquitado));
                
                
                
                    
                    
                }
                /* 
                
                Codigo para revisar el project manager
                
                
                */
             }else {
                
                
                
                Random random = new Random();
                
                
                acummulatedTime = 0;
            
                int horaAleatoria = random.nextInt(24);
                int hora = 0;
                capturado = false;
                
                while (acummulatedTime < (this.daydurantion)) {
                        
                        hora++;   

                        if(nameplant.equals("Lamborghini")){      

                        acummulatedTime += this.daydurantion*0.0416;

                        Thread.sleep((long) (this.daydurantion*0.0416));

                            if(hora == horaAleatoria){
                                
                                if(capturado == false) {

                                    this.userInterface.directorStatusL("Lookings manager");

                                    Thread.sleep((long) (this.daydurantion*0.0196));
                                    acummulatedTime += this.daydurantion*0.0196;

                                    if(this.manager.isIdle() == false){


                                        this.salarioquitado = this.salarioquitado + 50;
                                        this.fault++;

                                        this.userInterface.faultsQtyL(Integer.toString(this.fault));
                                        this.userInterface.managerSalaryDiscountL(Integer.toString(this.salarioquitado));
                                        capturado = true;

                                    }

                                 this.userInterface.directorStatusL("Working ");
                                
                                }
                            }
                        }
                            else {
                        
                                acummulatedTime += this.daydurantion*0.0416;

                        Thread.sleep((long) (this.daydurantion*0.0416));

                            if(hora == horaAleatoria){
                                
                                if(capturado == false) {

                                    this.userInterface.directorStatusM("Lookings manager");

                                    Thread.sleep((long) (this.daydurantion*0.0196));
                                    acummulatedTime += this.daydurantion*0.0196;

                                    if(this.manager.isIdle() == false){


                                        this.salarioquitado = this.salarioquitado + 50;
                                        this.fault++;

                                        this.userInterface.faultsQtyM1MS(Integer.toString(this.fault));
                                        this.userInterface.managerSalaryDiscountMS(Integer.toString(this.salarioquitado));
                                        capturado = true;

                                    }

                                 this.userInterface.directorStatusM("Working ");
                                
                                
                                }}} 

                        }}
        }   catch (InterruptedException ex) {
                Logger.getLogger(PlantDirector.class.getName()).log(Level.SEVERE, null, ex);
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
        this.accSalary += this.salary*24;
    }
    
    
}