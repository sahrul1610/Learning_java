package child;

import parent.Employee;

public class Programmer extends Employee{
    // atribut/property/field
    String programmingLanguage;

    // function/method
    @Override
    public void greeting(){
        super.greeting();
        System.out.println("sekali lagi, nama saya " + name + ", saya jago banget ngoding " + programmingLanguage);
    }

    public void programming(){
        System.out.println("Saya ahli bahasa pemrograman " + programmingLanguage);
    }

    public Programmer(String name, String address, int age, double salary, String programmingLanguage) {
        super(name, address, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public Programmer() {
        
    }
}
