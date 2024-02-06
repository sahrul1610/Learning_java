import java.util.Scanner;

import child.Driver;
import child.Programmer;
import parent.Person;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); // Kita membuat object. Kata kunci pembuatan object -> new

        // intansiasi / isntance
        Person person = new Person();

        person.name = "Hilman";
        person.address = "Cimahi";
        person.age = 21;

        System.out.println(person.name);
        System.out.println(person.address);
        System.out.println(person.age);
        person.greeting();

        System.out.println();

        Person person1 = new Person("Fahmi", "Bandung", 24);
        System.out.println(person1.name);
        System.out.println(person1.address);
        System.out.println(person1.age);
        person1.greeting();

        System.out.println();

        Person person2 = new Person("Ahmad", 17);
        person2.greeting();
        System.out.println();

        person2.age = 8;
        person2.setAddress();
        person2.greeting();

        System.out.println();
        System.out.println("===========================");
        System.out.println();

        Driver driver = new Driver("Asep", "Cihapelas", 20, 20000, "SIM A");
        driver.greeting();
        driver.driving();
        driver.age = 17;
        
        Driver driver2 = new Driver("Carl Jonson", 17, 20000, "SIM C");
        driver2.greeting();
        driver2.driving();
        driver2.age = 36;

        driver.setAddress();
        driver2.setAddress();

        System.out.println("===========================");
        driver.greeting();
        driver2.greeting();
        System.out.println();
        System.out.println("========= object programmer =========");
        System.out.println();
        Programmer programmer = new Programmer("William", "Lampung", 25, 4_000_000, "Java");
        programmer.greeting();

        input.close();
    }
}
