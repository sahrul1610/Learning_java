package model;

import child.Novelis;
import child.Publisher;
import parent.CommercialBook;

public class Novel extends CommercialBook {
    private Novelis author;
    private String genre;

    public Novel(String bookCode, String title, Novelis author, Publisher publisher, String genre) {
        super(bookCode, title, publisher);
        this.author = author;
        this.genre = genre;
        calculatePrice();
    }

    public Novel() {

    }

    public Novelis getAuthor() {
        return author;
    }

    public void setAuthor(Novelis author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void calculatePrice() {

        String rating = author.getRating();
        double productionCost = getPublisher().getProductionCost();

        double price;
        if (rating.equals("New Commer")) {
            price = productionCost * 1.25;
        } else if (rating.equals("Good")) {
            price = productionCost * 1.35;
        } else if (rating.equals("Best Seller")) {
            price = productionCost * 1.5; 
        } else {
            price = productionCost;
        }

        setPrice(price);
    }

    @Override
    public String toString() {
        return "Novel [bookCode=" + getBookCode() + ", title=" + getTitle() + ", author=" + author.getFullName()
                + ", publisher=" + getPublisher().getPublisherName() + ", price="
                + getPrice() + ", genre=" + getGenre() + "]";
    }
}
