package parent;

public class Employee extends Person {
    double salary;

    public Employee(String name, String address, int age, double salary) {
        super(name, address, age);
        this.salary = salary;
    }

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public Employee() {
        
    }
}
