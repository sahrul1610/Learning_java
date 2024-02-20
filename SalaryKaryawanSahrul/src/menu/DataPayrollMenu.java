package menu;

import java.util.Scanner;

import interfaces.Menu;
import model.EmployeeManager;

public class DataPayrollMenu implements Menu {
    private EmployeeManager employeeManager;

    public DataPayrollMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println(
                    "--------------------------------------------------------------------------------------------------");
            System.out.println(
                    "                                       Menu Data Payroll                                          ");
            System.out.println(
                    "--------------------------------------------------------------------------------------------------");
            System.out.printf("|%-4s|%-12s|%-12s|%-20s|%-20s|%-12s|%-10s|%n", "No", "Employee Id", "Name", "Job Desc",
                    "Placement", "Allowance", "Salary");
            System.out.println(
                    "--------------------------------------------------------------------------------------------------");
            employeeManager.displayPayroll();
            System.out.println("0\tKembali Ke Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // ...
        } while (choice != 0);

        // scanner.close();
    }
}
