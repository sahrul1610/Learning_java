package chlid;

import model.AllowanceEmployee;
import model.Placement;


public class Analyst extends AllowanceEmployee{
    private double allowance;

    public Analyst() {

    }

    public Analyst(String employeeId, String name, String address, int age, String jobDesc, Placement placement) {
        super(name, address, age, employeeId, jobDesc, placement);
        calculateSalary();
        this.allowance = calculateAllowance();
    }

    public Analyst(double allowance) {
        this.allowance = allowance;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        double umk = getPlacement().getUmk();
        //return umk * 1.6; // 160% dari UMK
        setSalary(umk * 1.6);
        return getSalary();
    }

    @Override
    public double calculateAllowance() {
        return getSalary() * 0.05; // 5% dari salary
    }

    @Override
    public String toString() {
        return "Analyst [employeeId=" + getEmployeeId() + ", name=" + getName() + ", address=" + getAddress()
                + ", age=" + getAge() + ", jobDesc=" + getJobDesc() + ", placement="
                + getPlacement().getCity() + ", allowance=" + allowance + ", salary=" + getSalary() + "]";
    }
}
