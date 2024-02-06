package model;

import child.Author;
import child.Publisher;
import parent.CommercialBook;

public class EBook extends CommercialBook{
    private Author author;

    public EBook(String bookCode, String title, Author author, Publisher publisher, double price) {
        super(bookCode, title, publisher, price);
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void calculatePrice() {
        // Logika perhitungan harga E-Book
        // Misalnya, dapat ditambahkan biaya tambahan untuk format digital, dll.
    }

    @Override
    public String toString() {
        return "EBook [author=" + author + "]";
    }
}
