package chlid;

import interfaces.AllowanceCalculator;
import model.Placement;
import perent.Employee;

public class ProjectLeader extends Employee implements AllowanceCalculator{
    private int totalProjects;
    private double allowance;

    // public ProjectLeader(String name, String address, int age, String employeeId, double salary, String jobDesc,
    //         String placement, int totalProjects, double allowance) {
    //     super(name, address, age, employeeId, jobDesc, placement);
    //     this.totalProjects = totalProjects;
    //     this.allowance = allowance;
    // }
    

    public ProjectLeader() {

    }
    
    public ProjectLeader(String employeeId, String name, String address, int age,  String jobDesc, Placement placement,
            int totalProjects) {
        super(name, address, age, employeeId, jobDesc, placement);
        this.totalProjects = totalProjects;
        //this.allowance = allowance;
        calculateSalary();
        calculateAllowance();
    }

    

    public ProjectLeader(int totalProjects, double allowance) {
        this.totalProjects = totalProjects;
        this.allowance = allowance;
    }

    public int getTotalProjects() {
        return totalProjects;
    }
    public void setTotalProjects(int totalProjects) {
        this.totalProjects = totalProjects;
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
        setSalary(umk* 2);
        return getSalary(); // 200% dari UMK
    }
    @Override
    // public double calculateAllowance() {

    //     if (totalProjects >= 2) {
    //         return getSalary() * 0.15; // 15% dari salary
    //     } else {
    //         return getSalary() * 0.05; // 5% dari salary
    //     }
    // }

    public double calculateAllowance() {
        double salary = getSalary(); // Mengambil gaji menggunakan getter
        double allowance;
        
        if (totalProjects >= 2) {
            allowance = salary *  0.15;// 20% dari gaji
        } else {
            allowance = salary * 0.05;  // 10% dari gaji
        }
        
        setAllowance(allowance); 
        return allowance; 
    }

    @Override
    // public String toString() {
    //     return "ProjectLeader [totalProjects=" + totalProjects + ", allowance=" + allowance + "]";
    // }
    
    public String toString() {
        return "ProjectLeader [employeeId=" + getEmployeeId() + ", name=" + getName() + ", address=" + getAddress() +", age=" + getAge() +", jobDesc=" + getJobDesc() + ", placement="
                + getPlacement().getCity() + ", totalProjects=" + totalProjects + ", allowance=" + allowance + ", salary=" + getSalary() + "]";
    }
}
