import java.util.List;

import interfaces.Menu;

import menu.MainMenu;

import model.EmployeeManager;

import perent.Employee;

import repository.EmployeeRepository;


public class App {
    public static void main(String[] args) throws Exception {


        EmployeeRepository repository = new EmployeeRepository();
        repository.initializeDummyData();
        List<Employee> employees = repository.getAllEmployees();
        EmployeeManager employeeManager = new EmployeeManager(employees);
        Menu mainMenu = new MainMenu(employeeManager);

        mainMenu.displayMenu();


    }
}
