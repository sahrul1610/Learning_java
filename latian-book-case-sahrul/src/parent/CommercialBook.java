package parent;
import child.Publisher;


public class CommercialBook {
    
    private String bookCode;
    private String title;
    private Publisher publisher;
    private double price;
    
    public CommercialBook(String bookCode, String title, Publisher publisher, double price) {
        this.bookCode = bookCode;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CommercialBook [bookCode=" + bookCode + ", title=" + title + ", publisher=" + publisher + ", price="
                + price + "]";
    }
}
