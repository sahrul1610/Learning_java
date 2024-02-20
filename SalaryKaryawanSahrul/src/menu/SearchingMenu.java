package menu;

import java.util.Scanner;

import interfaces.Menu;
import model.EmployeeManager;

public class SearchingMenu implements Menu {
    private EmployeeManager employeeManager;

    public SearchingMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSearching Data Karyawan");
            System.out.println("1. Search By Placement");
            System.out.println("0. Back To Main Menu");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter your choice: ");
                scanner.next(); 
            }
            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    searchByPlacement();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        // scanner.close();
    }

    private void searchByPlacement() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kota Penempatan: ");
        String placementCity = scanner.nextLine();
        employeeManager.searchEmployeeByPlacement(placementCity);

        // Tutup scanner
        // scanner.close();
    }

}
