package model;
import child.BookForLoan;
public class Comic extends BookForLoan {
    private String genre;

    public Comic(String bookId, String title, String author, double price, int stock, String genre) {
        super(bookId, title, author, price, stock);
        calculateBookLoanPrice();
        this.genre = genre;
    }

    public Comic(){}

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void calculateBookLoanPrice() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'calculateBookLoanPrice'");
        double rateStockPercentage = (getStock() < 10) ? 0.05 : 0.03;
        double rateBookType = 0.10; // karena ini adalah Comic
        setLoanPrice((rateStockPercentage + rateBookType) * getPrice());
    }

    
    @Override
    public String toString() {
        return "Comic [bookId=" + getBookId()+ ", title=" + getTitle() + ", author=" + getAuthor() + ", bookPrice=" + getPrice() + ",bookLoanPrice=" + getLoanPrice() + ",stock=" + getStock() + ", genre=" + genre + "]";
    }
}
