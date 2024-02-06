package child;

import parent.Employee;

public class Teacher extends Employee{
    // atribut/property/field
    String subject;

    // function/method
    public void greeting(){
        System.out.println("Halo!, nama saya " + name + ", saya berusia " + age);
        System.out.println("Saya tinggal di " + address);
    }

    public void teaching(){
        System.out.println("Saya mengajar pelajaran " + subject);
    }

    public Teacher(String name, String address, int age, double salary, String subject) {
        super(name, address, age, salary);
        this.subject = subject;
    }

    public Teacher() {
        
    }
}
