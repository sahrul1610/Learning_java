package model;


import child.Mangaka;
import child.Publisher;
import parent.CommercialBook;

public class Comic extends CommercialBook {
    private Mangaka author;
    private boolean volumeSeries;
    private double tax;

    public Comic(String bookCode, String title, Mangaka author, Publisher publisher, double price, boolean volumeSeries, double tax) {
        super(bookCode, title, publisher, price);
        this.author = author;
        this.volumeSeries = volumeSeries;
        this.tax = tax;
    }

    public boolean isVolumeSeries() {
        return volumeSeries;
    }

    public void setVolumeSeries(boolean volumeSeries) {
        this.volumeSeries = volumeSeries;
    }

    public double getTax() {
        return tax;
    }

    public Mangaka getAuthor() {
        return author;
    }

    public void setAuthor(Mangaka author) {
        this.author = author;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void calculatePrice() {

    }
    
    public void calculateTax() {
    }

    @Override
    public String toString() {
        return "Comic [author=" + author + ", volumeSeries=" + volumeSeries + ", tax=" + tax + "]";
    }
}
