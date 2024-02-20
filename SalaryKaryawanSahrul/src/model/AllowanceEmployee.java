package model;

import interfaces.AllowanceCalculator;
import perent.Employee;

public abstract class AllowanceEmployee extends Employee implements AllowanceCalculator{
    private double allowance;

    public AllowanceEmployee(String name, String address, int age, String employeeId, String jobDesc,
            Placement placement) {
        super(name, address, age, employeeId, jobDesc, placement);
        // this.allowance = allowance;
    }

    public AllowanceEmployee(){}
    
    public AllowanceEmployee(double allowance) {
        this.allowance = allowance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return "AllowanceEmployee [allowance=" + allowance + "]";
    }

 
    
}
