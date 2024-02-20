package chlid;


import model.AllowanceEmployee;
import model.Placement;


public class ProjectLeader extends AllowanceEmployee {
    private int totalProjects;
    //private double allowance;

    

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
        getAllowance();
    }

    public int getTotalProjects() {
        return totalProjects;
    }
    public void setTotalProjects(int totalProjects) {
        this.totalProjects = totalProjects;
    }

    @Override
    public double calculateSalary() {
        double umk = getPlacement().getUmk();
        setSalary(umk* 2);
        return getSalary(); // 200% dari UMK
    }

    @Override
    public double calculateAllowance() {
        double salary = getSalary(); 
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
    public String toString() {
        return "ProjectLeader [employeeId=" + getEmployeeId() + ", name=" + getName() + ", address=" + getAddress() +", age=" + getAge() +", jobDesc=" + getJobDesc() + ", placement="
                + getPlacement().getCity() + ", totalProjects=" + totalProjects + ", allowance=" + getAllowance() + ", salary=" + getSalary() + "]";
    }
}
