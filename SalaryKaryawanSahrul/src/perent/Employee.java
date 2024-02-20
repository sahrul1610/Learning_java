package perent;


import interfaces.SalaryCalculator;

import model.Placement;

public abstract class Employee extends Person  implements SalaryCalculator{
    private String employeeId;
    private double salary;
    private String jobDesc;
    private Placement placement;

    public Employee(String name, String address, int age, String employeeId, String jobDesc,
            Placement placement) {
        super(name, address, age);
        this.employeeId = employeeId;
        this.jobDesc = jobDesc;
        this.placement = placement;
    }


    public Employee() {

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + getName() + ", address=" + getAddress() +", jobDesc=" + jobDesc + ", placement="
                + placement.getCity() + ", salary=" + salary + "]";
    }

   
    


}
