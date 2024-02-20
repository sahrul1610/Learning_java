package menu;

import java.util.List;
import java.util.Scanner;

import interfaces.Menu;
import model.EmployeeManager;
import model.Placement;
import perent.Employee;
import repository.EmployeeRepository;

public class MainMenu implements Menu {

    private EmployeeManager employeeManager;
    private DataEmployeeMenu dataEmployeeMenu;
    private DataPayrollMenu dataPayrollMenu;
    private SearchingMenu searchingMenu;
    private EditEmployeeMenu editEmployeeMenu;
    private AddEmployeeMenu addEmployeeMenu;
    private DeleteEmployeeMenu deleteEmployeeMenu;

    public MainMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
        this.dataEmployeeMenu = new DataEmployeeMenu(employeeManager);
        this.dataPayrollMenu = new DataPayrollMenu(employeeManager);
        this.searchingMenu = new SearchingMenu(employeeManager);
        this.editEmployeeMenu = new EditEmployeeMenu(employeeManager);
        this.addEmployeeMenu = new AddEmployeeMenu(employeeManager);
        this.deleteEmployeeMenu = new DeleteEmployeeMenu(employeeManager);

    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSelamat Datang di Aplikasi Pendataan Karyawan PT. Secret Semut 79");
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Data Employee");
            System.out.println("4. Data Payroll");
            System.out.println("5. Delete Employee");
            System.out.println("6. Searching");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployeeMenu.displayMenu();
                    break;
                case 2:
                    editEmployeeMenu.displayMenu();
                    break;
                case 3:
                    dataEmployeeMenu.displayMenu();
                    break;
                case 4:
                    dataPayrollMenu.displayMenu();
                    break;
                case 5:
                    deleteEmployeeMenu.displayMenu();
                    break;
                case 6:
                    searchingMenu.displayMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

}
