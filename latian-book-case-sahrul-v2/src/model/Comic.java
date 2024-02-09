package model;

import child.Mangaka;
import child.Publisher;
import parent.CommercialBook;

public class Comic extends CommercialBook {
    private Mangaka author;
    private boolean volumeSeries;
    private double tax;

    public Comic(String bookCode, String title, Mangaka author, Publisher publisher, boolean volumeSeries) {
        super(bookCode, title, publisher);
        this.author = author;
        this.volumeSeries = volumeSeries;
        calculatePrice();
        calculateTax();
    }

    public Comic() {

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

        double productionCost = getPublisher().getProductionCost();
        double price;

        if (author.getRating().equals("New Commer")) {
            if (isVolumeSeries()) {
                price = productionCost * 1.35;
            } else {
                price = productionCost * 1.25;
            }
        } else if (author.getRating().equals("Good")) {
            if (isVolumeSeries()) {
                price = productionCost * 1.45;
            } else {
                price = productionCost * 1.30;
            }
        } else { // Best Seller
            if (isVolumeSeries()) {
                price = productionCost * 1.50;
            } else {
                price = productionCost * 1.40;
            }
        }

        setPrice(price);
    }

    public void calculateTax() {
        double comicPrice = getPrice();
        double tax = comicPrice * 0.05;
        setTax(tax);
    }

    @Override
    public String toString() {
        return "Comic [bookCode=" + getBookCode() + ", title=" + getTitle() + ", author=" + author.getFullName()
                + ", publisher=" + getPublisher().getPublisherName() + ", price="
                + getPrice() + ", tax=" + getTax() + ", volumeSeries=" + volumeSeries + "]";
    }
}
