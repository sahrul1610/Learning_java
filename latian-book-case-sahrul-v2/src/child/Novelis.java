package child;

// import parent.Person;

public class Novelis extends Author {

    private boolean serial;
    private String rating;

    public Novelis(String firstName, String lastName, String country, int age, boolean serial, String rating) {
        super(firstName, lastName, country, age);
        this.serial = serial;
        this.rating = rating;
    }

    public Novelis(){
        
    }

    public boolean isSerial() {
        return serial;
    }

    public void setSerial(boolean serial) {
        this.serial = serial;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    // public String getFullName() {
    //     return getFirstName() + " " + getLastName();
    // }


    @Override
    public String toString() {
        return "Novelis [firstName= " + getFirstName() + ", lastName= " + getLastName() + ", country= " + getCountry()
                + ", age= " + getAge()
                + ",serial= " + serial + ", rating= " + rating + "]";
    }


}
