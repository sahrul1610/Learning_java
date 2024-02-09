package child;

import parent.Person;

public class Author extends Person{

    public Author(String firstName, String lastName, String country, int age) {
        super(firstName, lastName, country, age);
    }

    public Author(){
        
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

}
