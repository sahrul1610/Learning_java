package perent;

import child.BookForLoan;
import interfaces.CalculateLoanFee;

public class LoanBookOrder implements CalculateLoanFee{
    private String loanId;
    private Member member;
    private BookForLoan loanBook;
    private int loanDuration;
    private double loanFee;
    
    private static int nextId =  1;
    
    public LoanBookOrder(Member member, BookForLoan loanBook, int loanDuration) {
        this.loanId = generateLoanId();
        this.member = member;
        this.loanBook = loanBook;
        this.loanDuration = loanDuration;
        calculateLoanFee();
        incrementLoanIdCounter();
       
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
        double loanFee = loanDuration * loanBook.getLoanPrice();
        setLoanFee(loanFee);
    }

    private static String generateLoanId() {
        String formattedId = String.format("%03d", nextId);
        return "Ord-" + formattedId;
    }

    private static void incrementLoanIdCounter() {
        nextId++;
    }


    @Override
    public String toString() {
        return "LoanBookOrder [loanId=" + loanId + ", member=" + member + ", loanBook=" + loanBook + ", loanDuration="
                + loanDuration + ", loanFee=" + loanFee + "]";
    }



    
}
