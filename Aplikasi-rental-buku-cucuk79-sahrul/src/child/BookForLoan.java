package child;

import interfaces.CalculateBookLoanPrice;
import perent.Book;

public abstract class BookForLoan extends Book implements CalculateBookLoanPrice{
    private double loanPrice;
    private int stock;

    public BookForLoan(String bookId, String title, String author, double price,  int stock) {
        super(bookId, title, author, price);
        this.stock = stock;
    }

    public BookForLoan(){}

    public double getLoanPrice() {
        return loanPrice;
    }

    public void setLoanPrice(double loanPrice) {
        this.loanPrice = loanPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



    @Override
    public String toString() {
        return "BookForLoan [loanPrice=" + loanPrice + ", stock=" + stock + "]";
    }
}
