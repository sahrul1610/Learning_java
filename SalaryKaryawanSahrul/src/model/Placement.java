package model;

public class Placement {
    private String city;
    private double umk;

    public Placement(String city, double umk) {
        this.city = city;
        this.umk = umk;
    }

    public Placement(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public double getUmk() {
        return umk;
    }
    public void setUmk(double umk) {
        this.umk = umk;
    }
    @Override
    public String toString() {
        return "Placement [city=" + city + ", umk=" + umk + "]";
    }

    
}
