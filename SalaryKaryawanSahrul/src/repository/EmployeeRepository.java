package repository;
import java.util.ArrayList;
import java.util.List;

import chlid.Analyst;
import chlid.Programmer;
import chlid.ProjectLeader;
import model.EmployeeGeneral;
import model.Placement;
import perent.Employee;
public class EmployeeRepository {
    private List<Employee> employees;
    private List<Placement> placements;

    public EmployeeRepository() {
        employees = new ArrayList<>();
        placements = new ArrayList<>();
        // Initialize with dummy data
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
    public List<Placement> getAllPlacement() {
        return placements;
    }

    public void addEmployee(Employee employee) {
        // Add employee logic
    }

    public void editEmployee(String employeeId, String newPlacement) {
        // Edit employee logic
    }

    public void deleteEmployee(String employeeId) {
        // Delete employee logic
    }

    // public List<Employee> searchEmployeesByPlacement(String placement) {
    //     // Search logic
    // }

    public void addPlacement(Placement placement) {
        placements.add(placement);
    }

    public void initializeDummyData(){
        
        Placement garutPlacement = new Placement("Garut", 1961085.0);
        Placement bandungPlacement = new Placement("Bandung", 3742276.0);
        Placement jakartaPlacement = new Placement("Jakarta", 4453935.0);
        Placement bekasiPlacement = new Placement("Bekasi", 4782935.0);
        Placement bogorPlacement = new Placement("Bogor", 4330249.0);

        addPlacement(garutPlacement);
        addPlacement(bandungPlacement);
        addPlacement(jakartaPlacement);
        addPlacement(bekasiPlacement);
        addPlacement(bogorPlacement);
        // employees.add(new Programmer("Prog-001", "Budi", 0, "Bandung",  25, "Back End Dev", "Jakarta", "Java",  2));
        // employees.add(new Programmer("Prog-002", "Ani", "Bandung",  30, "Front End Dev", "Bandung", "React Js",  6));
        // employees.add(new Programmer("Prog-003", "Ujang", "Jakarta",  28, "Full Stack Dev", "Bandung", "Kotlin",  4));

        employees.add(new EmployeeGeneral("Susi", "Bandung", 27, "Emp-001", "Admin", jakartaPlacement));
        employees.add(new EmployeeGeneral("Anto", "Bandung", 35, "Emp-002", "Office Boy", bandungPlacement));
        employees.add(new EmployeeGeneral("Riman", "Jakarta", 28, "Emp-003", "Human Resource Dev", bandungPlacement));

        employees.add(new Programmer("Prog-001", "Budi", "Bandung", 25, "Back End Dev", jakartaPlacement, "Java", 2));
        employees.add(new Programmer("Prog-002", "Ani", "Bandung", 30, "Front End Dev", bandungPlacement, "React Js", 6));
        employees.add(new Programmer("Prog-003", "Ujang", "Jakarta", 28, "Full Stack Dev", bandungPlacement, "Kotlin", 4));

         employees.add(new ProjectLeader("PL-001", "Ahmad", "Bandung", 25, "Project Leader", garutPlacement, 2));
        employees.add(new ProjectLeader("PL-002", "Dani", "Bandung", 30, "Scrum Master", bekasiPlacement, 1));
        employees.add(new ProjectLeader("PL-003", "Cecep", "Jakarta", 28, "Project Owner", bogorPlacement, 4));

        employees.add(new Analyst("AL-001", "Indah", "Garut", 25, "Analyst", jakartaPlacement));
        employees.add(new Analyst("AL-002", "Puspa", "Bandung", 30, "Analyst", bekasiPlacement));
        employees.add(new Analyst("AL-003", "Sari", "Jakarta", 28, "Analyst", bogorPlacement));
    }
}
