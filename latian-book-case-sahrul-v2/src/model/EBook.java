package model;

import child.Author;
import child.Publisher;
import parent.CommercialBook;

public class EBook extends CommercialBook{
    private Author author;

    public EBook(String bookCode, String title, Author author, Publisher publisher) {
        super(bookCode, title, publisher);
        this.author = author;
        calculatePrice();
    }

    public EBook(){

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    
    @Override
    public void calculatePrice() {
        
        double result = getPublisher().getProductionCost() * 1.2;
        setPrice(result);
    }

    @Override
    // public String toString() {
    //     return "EBook [author=" + author + "]";
    // }

    public String toString() {
        return "EBook [bookCode=" + getBookCode() + ", title=" + getTitle() + ", author=" + author.getFullName() + ", publisher=" + getPublisher().getPublisherName() + ", price="
                + getPrice() + "]";
    }
    
}
