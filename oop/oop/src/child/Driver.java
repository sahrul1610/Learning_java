package child;

import parent.Employee;

public class Driver extends Employee {
    // atribut/property/field
    String licenseType;

    // function/method

    public void driving(){
        System.out.println("Saya menggunakan " + licenseType);
    }

    

    // public Driver(String name, String address, int age, double salary, String licenseType) {
    //     this.name = name;
    //     this.address = address;
    //     this.age = age;
    //     this.salary = salary;
    //     this.licenseType = licenseType;
    // }

    public Driver(String name, String address, int age, double salary, String licenseType) {
        super(name, address, age, salary);
        this.licenseType = licenseType;
    }

    public Driver(String name, int age, double salary, String licenseType) {
        super(name, age, salary);
        this.licenseType = licenseType;
    }

    public Driver() {
        
    }
}
