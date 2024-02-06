package parent;


public class Person{
    // atribut/property/field
    public String name;
    public String address;
    public int age;

    // function/method
    public void greeting(){
        System.out.println("Halo!, nama saya " + name + ", saya berusia " + age);
        System.out.println("Saya tinggal di " + address);
    }

    // Constructor
    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.address = setAddressByAge();
    }    

    public Person() {
        
    }

    public void setAddress(){
        this.address = setAddressByAge();
    }

    public String setAddressByAge(){
        if (age <= 10) {
            return "Bandung";
        }else if (age <= 20){
            return "Cimahi";
        }
        return "Jakarta";
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + ", age=" + age + "]";
    }
}
