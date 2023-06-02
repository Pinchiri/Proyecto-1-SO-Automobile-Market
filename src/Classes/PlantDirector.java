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
    private int dayDuration;
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
    private int costTotal = 0;
    
    private Chart chart;

    
    
    
    public PlantDirector(float salary, int dayduration, VehiclePlant plant, MainUI userInterface,OperationsManager manager, Warehouse warehouse, String nameplant) {
        this.salary = salary;
        this.dayDuration = dayduration;
        this.accSalary = 0;
        this.manager = manager;
        this.userInterface = userInterface;
        this.warehouse = warehouse;
        this.plant = plant;
        this.nameplant = nameplant;
        
        this.chart = chart;
       }
    
    @Override
    public void run(){
        
     
        while (true) {
             try {
             
            payCheck();
          
            
            
            if( this.manager.daysLeft < 0 ){
                
                
                
                manager.resetdays();
            
                if(nameplant.equals("Lamborghini")){
                userInterface.plusLootNumL();
                
                this.userInterface.daysLeftLamborghini(Integer.toString(this.manager.daysLeft));
                this.userInterface.lambEarnings("$" + Long.toString(warehouse.getTotalEarnings()));

                this.plant.calculateCosts();
                costo = this.plant.getTotalCosts();
                ganancia = (int) this.warehouse.getTotalEarnings();
                costo = (int) (costo + this.manager.getAccSalary());
                costo = (int) (costo + this.accSalary);
                this.warehouse.totalEarnings = 0;
                costo = costo - salarioquitado;
                this.salarioquitado = 0;
                this.fault = 0;
                costTotal += costo;
                utility = ganancia - costo;
                costo = 0;
//                chart.updateDataset(plant.getConfig().getDeliveryDays()*userInterface.getLootNumL());
                this.manager.ResetSalario();
                this.accSalary = 0;
                
                this.warehouse.resetcars();
                this.userInterface.MaseAC("0");
                this.userInterface.LamborghiniSC("0");
                this.userInterface.LamborghiniAC("0");
                this.userInterface.MaseAC("0");
                
                this.userInterface.costsL("$" + Integer.toString(costTotal));
                this.userInterface.UtilityL("$" + Integer.toString(utility));
                this.userInterface.faultsQtyL(Integer.toString(this.fault));
                this.userInterface.managerSalaryDiscountL("$" + Integer.toString(this.salarioquitado));
                
                
                
                
                
                
                this.userInterface.directorStatusL("Reiniciando lote");
                
                Thread.sleep(dayDuration);               
                
                } else {
                userInterface.plusLootNumM();
                this.userInterface.DaysLeftMaserati(Integer.toString(this.manager.daysLeft));
                this.userInterface.MaseEarnings("$" + Long.toString(warehouse.getTotalEarnings()));
                this.userInterface.directorStatusM("Reiniciando lote");
                
//                costo = this.warehouse.costototal;
                this.plant.calculateCosts();
                costo = this.plant.getTotalCosts();
                costo = (int) (costo + this.manager.getAccSalary());
                costo = (int) (costo + this.accSalary);
                costo = costo - salarioquitado;
                this.salarioquitado = 0;
                this.fault = 0;

                this.manager.ResetSalario();
                this.accSalary = 0;
                
                
                ganancia = (int) this.warehouse.getTotalEarnings();
                this.warehouse.totalEarnings = 0;
                
                utility = ganancia - costo;
//                chart.updateDataset(plant.getConfig().getDeliveryDays()*userInterface.getLootNumM());
                        
                this.warehouse.resetcars();
                this.userInterface.MaseAC("0");
                this.userInterface.LamborghiniSC("0");
                this.userInterface.LamborghiniAC("0");
                this.userInterface.MaseAC("0");
                          
                this.userInterface.costsM("$" + Integer.toString(costo));
                this.userInterface.UtilityM("$" + Integer.toString(utility));
                this.userInterface.faultsQtyM1MS(Integer.toString(this.fault));
                this.userInterface.managerSalaryDiscountMS("$" + Integer.toString(this.salarioquitado));
                
                
                
                    
                    
                }
                /* 
                
                Codigo para revisar el project manager
                
                
                */
             } else {
                
                costo = this.plant.getTotalCosts();
                ganancia = (int) this.warehouse.getTotalEarnings();
                costo = (int) (costo + this.manager.getAccSalary());
                costo = (int) (costo + this.accSalary);
                utility = ganancia - costo;
                
                
                Random random = new Random();
                
                
                acummulatedTime = 0;
            
                int horaAleatoria = random.nextInt(24);
                int hora = 0;
                capturado = false;
                
                while (acummulatedTime < (this.dayDuration)) {
                        
                        hora++;   

                        if(nameplant.equals("Lamborghini")){      

                        acummulatedTime += this.dayDuration*0.0416;

                        Thread.sleep((long) (this.dayDuration*0.0416));

                            if(hora == horaAleatoria){
                                
                                if(capturado == false) {

                                    this.userInterface.directorStatusL("Watching manager");

                                    Thread.sleep((long) (this.dayDuration*0.01736));
                                    acummulatedTime += this.dayDuration*0.01736;

                                    if(this.manager.isIdle() == false){


                                        this.salarioquitado = this.salarioquitado + 50;
                                        this.fault++;

                                        this.userInterface.faultsQtyL(Integer.toString(this.fault));
                                        this.userInterface.managerSalaryDiscountL("$" + Integer.toString(this.salarioquitado));
                                        capturado = true;

                                    }

                                 this.userInterface.directorStatusL("Working ");
                                
                                }
                            }
                        }
                            else {
                        
                                acummulatedTime += this.dayDuration*0.0416;

                                Thread.sleep((long) (this.dayDuration*0.0416));

                            if(hora == horaAleatoria){
                                
                                if(capturado == false) {

                                    this.userInterface.directorStatusM("Lookings manager");

                                    Thread.sleep((long) (this.dayDuration*0.0196));
                                    acummulatedTime += this.dayDuration*0.0196;

                                    if(this.manager.isIdle() == false){


                                        this.salarioquitado = this.salarioquitado + 50;
                                        this.fault++;

                                        this.userInterface.faultsQtyM1MS(Integer.toString(this.fault));
                                        this.userInterface.managerSalaryDiscountMS("$" + Integer.toString(this.salarioquitado));
                                        capturado = true;

                                    }

                                 this.userInterface.directorStatusM("Working ");
                                
                                
                                }
                            }
                        } 

                        }
            }
        } catch (InterruptedException ex) {
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

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public OperationsManager getManager() {
        return manager;
    }

    public void setManager(OperationsManager manager) {
        this.manager = manager;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }
    
    
}