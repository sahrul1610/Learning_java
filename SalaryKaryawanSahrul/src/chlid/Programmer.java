package chlid;

import model.AllowanceEmployee;
import model.Placement;


public class Programmer extends AllowanceEmployee{
    private String programmingLanguage;
    private int experiences;



    public Programmer() {

    }

    public Programmer(String employeeId, String name, String address, int age, String jobDesc, Placement placement,
            String programmingLanguage, int experiences) {

        super(name, address, age, employeeId, jobDesc, placement);
        this.programmingLanguage = programmingLanguage;
        this.experiences = experiences;
        calculateSalary();
        calculateAllowance();
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getExperiences() {
        return experiences;
    }

    public void setExperiences(int experiences) {
        this.experiences = experiences;
    }

    @Override
    public double calculateSalary() {
        double umk = getPlacement().getUmk();
        setSalary(umk * 1.5);
        return getSalary();
    }

    @Override
    public double calculateAllowance() {
        double salary = getSalary(); // Mengambil gaji menggunakan getter
        double allowance;
        
        if (getExperiences() > 4) {
            allowance = salary * 0.2; // 20% dari gaji
        } else {
            allowance = salary * 0.1; // 10% dari gaji
        }
        
        setAllowance(allowance); 
        return allowance; 
    }

    @Override

    public String toString() {
        return "Programmer [employeeId=" + getEmployeeId() + ", name=" + getName() + ", address=" + getAddress()
                + ", age=" + getAge() + ", jobDesc=" + getJobDesc() + ", placement="
                + getPlacement().getCity() + ", programmingLanguage=" + programmingLanguage + ", experiences="
                + experiences + ", allowance=" + getAllowance() + ", salary=" + getSalary() + "]";
    }

}
