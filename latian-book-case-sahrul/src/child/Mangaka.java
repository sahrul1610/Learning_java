package child;

import parent.Person;

public class Mangaka extends Person {

    private String rating;

    public Mangaka(String firstName, String lastName, String country, int age, String rating) {
        super(firstName, lastName, country, age);
        this.rating = rating;
    }

    // @Override
    public void greeting() {
        System.out.println("Halo!, nama saya " + getFullName() + ", saya berusia " + getAge());
        System.out.println("Saya tinggal di " + getCountry() + " memilik rating " + rating);
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    // public String toString() {
    // return "Mangaka [rating=" + rating + "]";
    // }
    @Override
    public String toString() {
        return "Mangaka [firstName= " + getFirstName() + ", lastName= " + getFullName() + ", country= " + getCountry()
                + ", age= " + getAge()
                + ", rating= " + rating + "]";
    }

}
