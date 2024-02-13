package perent;

import child.BookForLoan;
import interfaces.CalculateLoanFee;

public class LoanBookOrder implements CalculateLoanFee{
    private String loanId;
    private Member member;
    private BookForLoan loanBook;
    private int loanDuration;
    private double loanFee;
    
    public LoanBookOrder(String loanId, Member member, BookForLoan loanBook, int loanDuration) {
        this.loanId = loanId;
        this.member = member;
        this.loanBook = loanBook;
        this.loanDuration = loanDuration;
        calculateLoanFee();
    }

    public LoanBookOrder(){}

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookForLoan getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(BookForLoan loanBook) {
        this.loanBook = loanBook;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public double getLoanFee() {
        return loanFee;
    }

    public void setLoanFee(double loanFee) {
        this.loanFee = loanFee;
    }

    @Override
    public void calculateLoanFee() {
        // TODO Auto-generated method stub
        this.loanFee = loanDuration * loanBook.getLoanPrice();
        
    }



    
}
