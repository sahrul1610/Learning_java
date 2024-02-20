package menu;

import java.util.Scanner;

import interfaces.Menu;
import model.EmployeeManager;

public class DataEmployeeMenu implements Menu {
    private EmployeeManager employeeManager;

    public DataEmployeeMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Override
    public void displayMenu() {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("                                Data Employee                                   ");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("|%-4s|%-12s|%-10s|%-12s|%-12s|%-20s|%-14s|%n", "No", "Employee Id", "Name", "Address", "Age", "Job Desc", "Placement");
        System.out.println("--------------------------------------------------------------------------------------------");
        // Tampilkan data employee
        employeeManager.displayAllEmployees();
        System.out.println("0\tKembali Ke Main Menu");

    }
}
