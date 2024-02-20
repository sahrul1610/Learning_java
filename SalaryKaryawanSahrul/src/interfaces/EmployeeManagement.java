package interfaces;

import model.Placement;
import perent.Employee;

public interface EmployeeManagement {

    void addEmployee(Employee employee);
    //void editEmployee(String employeeId, Placement newPlacement);
    void editEmployee(String employeeId, String newName, String newAddress, int newAge, String newJobDesc, Placement newPlacement);
    //void deleteEmployee(String employeeId);
    boolean deleteEmployee(String employeeId);
    void searchEmployeeByPlacement(String placement);
    void displayAllEmployees();
    void displayPayroll();
}