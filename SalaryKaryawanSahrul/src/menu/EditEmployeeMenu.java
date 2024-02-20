package menu;



import java.util.Scanner;
import interfaces.Menu;
import model.EmployeeManager;
import model.Placement;
import perent.Employee;

public class EditEmployeeMenu implements Menu {
    private EmployeeManager employeeManager;
    private DataEmployeeMenu dataEmployeeMenu;

    public EditEmployeeMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
        this.dataEmployeeMenu = new DataEmployeeMenu(employeeManager);
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        do {
            dataEmployeeMenu.displayMenu();
            System.out.println("\nEdit Data Karyawan");
            System.out.println("Enter employee ID to edit: ");
            String userInput = scanner.nextLine();

            if (userInput.equals("0")) {
                exit = true; 
            } else {
                String employeeIdToEdit = userInput;
                boolean isEmployeeFound = false;
                for (Employee employee : employeeManager.getAllEmployees()) {
                    if (employee.getEmployeeId().equals(employeeIdToEdit)) {
                        isEmployeeFound = true;
                        break;
                    }
                }

                if (!isEmployeeFound) {
                    System.out.println("Employee with ID " + employeeIdToEdit + " not found. Please try again.");
                    continue; 
                }


                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine();

                int newAge;
                while (true) {
                    try {
                        System.out.print("Enter new age: ");
                        newAge = Integer.parseInt(scanner.nextLine());
                        if (newAge <= 0) {
                            throw new IllegalArgumentException("Age must be a positive integer.");
                        }
                        break; 
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.print("Enter new job description: ");
                String newJobDesc = scanner.nextLine();
                System.out.print("Enter new placement: ");
                String newPlacementCity = scanner.nextLine();
                Placement newPlacement = new Placement(newPlacementCity);

                // Call the editEmployee function from EmployeeManager
                employeeManager.editEmployee(employeeIdToEdit, newName, newAddress, newAge, newJobDesc, newPlacement);
                System.out.println("Employee data updated successfully.");
                exit = true; // Set exit to true to exit the loop after editing is done
            }

        } while (!exit); // Continue until the user chooses to go back to the main menu

        //scanner.close();
    }
}

