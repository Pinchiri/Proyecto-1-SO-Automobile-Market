/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Rolando
 */
public class OperationsManager {
    
    private float salary;
    private boolean idle;
    private int idleInterval;
    private int daysLeft;
    private float accSalary;

    public OperationsManager(float salary, int idleInterval, int daysLeft) {
        this.salary = salary;
        this.idleInterval = idleInterval;
        this.idle = false;
        this.daysLeft = daysLeft;
        this.accSalary = 0;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isIdle() {
        return idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public int getIdleInterval() {
        return idleInterval;
    }

    public void setIdleInterval(int idleInterval) {
        this.idleInterval = idleInterval;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }
   
    
    
    
   
}
