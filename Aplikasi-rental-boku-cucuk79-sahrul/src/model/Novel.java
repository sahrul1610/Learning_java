package model;

import child.BookForLoan;

public class Novel extends BookForLoan{
    
    private boolean isSeries;

    public Novel(String bookId, String title, String author, double price,  int stock,
            boolean isSeries) {
        super(bookId, title, author, price, stock);
        calculateBookLoanPrice();
        this.isSeries = isSeries;
    }

    public Novel(){}

    public boolean isSeries() {
        return isSeries;
    }

    public void setSeries(boolean isSeries) {
        this.isSeries = isSeries;
    }
    
    @Override
    public void calculateBookLoanPrice() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'calculateBookLoanPrice'");
        double rateStockPercentage = (getStock() < 10) ? 0.05 : 0.03;
        double rateBookType = 0.05; // karena ini adalah Novel
        setLoanPrice((rateStockPercentage + rateBookType) * getPrice());
    }



    @Override
    public String toString() {
        return "Novel [bookId=" + getBookId()+ ", title=" + getTitle() + ", author=" + getAuthor() + ", bookPrice=" + getPrice() + ",bookLoanPrice=" + getLoanPrice() + ",stock=" + getStock() + ", isSeries=" + isSeries + "]";
    }
}
