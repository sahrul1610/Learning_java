package model;

import java.util.Iterator;
import java.util.List;

import chlid.Analyst;
import chlid.Programmer;
import chlid.ProjectLeader;
import interfaces.EmployeeManagement;
import perent.Employee;

public class EmployeeManager implements EmployeeManagement {
    private List<Employee> employees;
    // private int nextEmployeeNumber;

    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
        // this.nextEmployeeNumber = employees.size() + 1;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        
    }


    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void editEmployee(String employeeId, String newName, String newAddress, int newAge, String newJobDesc,
            Placement newPlacement) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(employeeId)) {
                // Mengubah informasi karyawan
                employee.setName(newName);
                employee.setAddress(newAddress);
                employee.setAge(newAge);
                employee.setJobDesc(newJobDesc);
                employee.setPlacement(newPlacement);

                // Menghitung ulang gaji karyawan setelah perubahan informasi
                employee.setSalary(employee.calculateSalary());
                break;
            }
        }
    }

    @Override
    // public void deleteEmployee(String employeeId) {
    //     employees.removeIf(employee -> employee.getEmployeeId().equals(employeeId));
    // }

    public boolean deleteEmployee(String employeeId) {
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
            Employee employee = iterator.next();
            if (employee.getEmployeeId().equals(employeeId)) {
                iterator.remove();
                return true; // Return true jika karyawan berhasil dihapus
            }
        }
        return false; // Return false jika karyawan tidak ditemukan
    }

    @Override
    public void searchEmployeeByPlacement(String placementCity) {
        boolean found = false;
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-12s | %-10s | %-12s | %-12s | %-20s | %-14s |%n", "No", "Employee Id", "Name",
                "Address", "Age", "Job Desc", "Placement");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");

        int count = 1;
        for (Employee employee : employees) {
            if (employee.getPlacement().getCity().equalsIgnoreCase(placementCity)) {

                System.out.printf("| %-4d | %-12s | %-10s | %-12s | %-12d | %-20s | %-14s |%n",
                        count++,
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getAddress(),
                        employee.getAge(),
                        employee.getJobDesc(),
                        employee.getPlacement().getCity());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in " + placementCity);
        }

        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void displayAllEmployees() {
        int count = 1;
        for (Employee employee : employees) {
            System.out.printf("|%-4d|%-12s|%-10s|%-12s|%-12s|%-20s|%-14s|%n", count++, employee.getEmployeeId(),
                    employee.getName(), employee.getAddress(), employee.getAge(), employee.getJobDesc(),
                    employee.getPlacement().getCity());
            System.out.println(
                    "--------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void displayPayroll() {
        double totalPayroll = 0;
        int index = 1;
        for (Employee employee : employees) {
            double allowance = calculateAllowance(employee); // Menentukan nilai allowance
            totalPayroll += (employee.getSalary() + allowance);
            System.out.printf("|%-4d|%-12s|%-12s|%-20s|%-20s|%-12.2f|%-10.2f|%n", index++, employee.getEmployeeId(),
                    employee.getName(), employee.getJobDesc(), employee.getPlacement().getCity(), allowance,
                    employee.getSalary());
            System.out.println(
                    "--------------------------------------------------------------------------------------------------");
        }
        System.out.printf("|%-4s|%-78s|%-12.2f|%n", "", "Total Payroll", totalPayroll);
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
    }

    private double calculateAllowance(Employee employee) {
        if (employee instanceof Programmer) {
            return ((Programmer) employee).getAllowance();
        } else if (employee instanceof ProjectLeader) {
            return ((ProjectLeader) employee).getAllowance();
        } else if (employee instanceof Analyst) {
            return ((Analyst) employee).getAllowance();
        } else {
            return 0; // EmployeeGeneral tidak memiliki allowance
        }
    }

}