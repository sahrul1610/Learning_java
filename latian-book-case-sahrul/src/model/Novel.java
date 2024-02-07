package model;


import child.Novelis;
import child.Publisher;
import parent.CommercialBook;

public class Novel extends CommercialBook{
    private Novelis author;
    private String genre;



    // Constructor
    public Novel(String bookCode, String title, Novelis author, Publisher publisher, double price, String genre) {
        super(bookCode, title, publisher, price);
        this.author = author;
        this.genre = genre;
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
        // Logika perhitungan harga Novel
    }



    @Override
    public String toString() {
        return "Novel [author=" + author + ", genre=" + genre + "]";
    }
}
