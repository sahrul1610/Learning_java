package model;

import perent.Employee;

public class EmployeeGeneral extends Employee {
    public EmployeeGeneral(String name, String address, int age, String employeeId, String jobDesc,
            Placement placement) {
        super(name, address, age, employeeId, jobDesc, placement);
        calculateSalary();
    }

    @Override
    public double calculateSalary() {
        double umk = getPlacement().getUmk();
        // return umk * 0.2;
        setSalary(umk * 0.2);
        return getSalary();
    }
}
