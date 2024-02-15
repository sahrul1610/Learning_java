import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import child.BookForLoan;
import perent.LoanBookOrder;
import perent.Member;
import repository.RepositoryBookForLoan;
import repository.RepositoryMember;

public class App {
    private static RepositoryBookForLoan bookRepository = new RepositoryBookForLoan();
    private static RepositoryMember memberRepository = new RepositoryMember();
    private static List<LoanBookOrder> loanOrderList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        bookRepository.initializeDummyData();
        memberRepository.initializeDummyData();
        runApplication();

    }

    private static void runApplication() {
        List<BookForLoan> allBooks = bookRepository.getAllBookForLoan();
        List<Member> allMembers = memberRepository.getAllMember();
        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        displayAllBooks(allBooks);
                        break;
                    case 2:
                        processLoan(allBooks, allMembers);
                        break;
                    case 3:
                        processReturn();
                        break;
                    case 4:
                        displayAllLoanOrders();
                        break;
                    case 0:
                        isRunning = false;
                        System.out.println("Exiting the application...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n+=============== Menu =============+");
        System.out.println("Aplikasi Rental Buku Cucux\n");
        System.out.println("1. Fitur Menu List All Book");
        System.out.println("2. Fitur Loan");
        System.out.println("3. Fitur Return");
        System.out.println("4. Fitur Menu List Loan Order");
        System.out.println("0. Exit\n");
        System.out.println("\n+=================================+");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void displayAllBooks(List<BookForLoan> allBooks) {
        System.out.printf(
                "============================================================================================%n");
        System.out.printf("                                    List All Book                                   %n");
        System.out.printf(
                "============================================================================================%n");
        System.out.printf("|%-4s|%-12s|%-45s|%-20s|%s|%n", "No", "Book ID", "Title", "Author", "Stock");
        System.out.printf(
                "--------------------------------------------------------------------------------------------%n");
        int count = 1;
        for (BookForLoan book : allBooks) {
            System.out.printf("|%-4d|%-12s|%-45s|%-20s|%-5d|%n", count++, book.getBookId(), book.getTitle(),
                    book.getAuthor(),
                    book.getStock());
            System.out.printf(
                    "--------------------------------------------------------------------------------------------%n");
        }

    }

    private static void processLoan(List<BookForLoan> allBooks, List<Member> allMembers) {
        displayAllBooks(allBooks);
        System.out.printf("|%-4s|%-85s|%n", "0", "Kembali ke Main Menu");
        System.out.printf(
                "--------------------------------------------------------------------------------------------%n");
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        
        boolean validMemberId = false;
        Member member = null;
        while (!validMemberId) {
            System.out.print("Masukkan Member Id: ");
            String memberId = scanner.nextLine();
            if (memberId.equals("0")) {
                System.out.println("Kembali ke Main Menu.");
                return;
            }
            member = findMemberById(allMembers, memberId);
            if (member != null) {
                validMemberId = true;
            } else {
                System.out.println("Member Id tidak ditemukan. Silakan coba lagi.");
            }
        }

        System.out.print("Masukkan Book Id: ");
        String bookId = scanner.nextLine();
        System.out.print("Lama Peminjaman: ");
        int loanDuration = scanner.nextInt();

        BookForLoan book = findBookById(allBooks, bookId);
        if (book != null && book.getStock() > 0) {
            book.setStock(book.getStock() - 1);
            // Member member = findMemberById(allMembers, memberId);
            LoanBookOrder loanOrder = new LoanBookOrder(member, book, loanDuration);
            loanOrderList.add(loanOrder);
            System.out.println("Loan Success!");
        } else {
            System.out.println("Book is not available for loan or does not exist.");
        }
    }

    private static BookForLoan findBookById(List<BookForLoan> allBooks, String bookId) {
        for (BookForLoan book : allBooks) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    private static Member findMemberById(List<Member> allMembers, String memberId) {
        for (Member member : allMembers) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }


    private static void displayAllLoanOrders() {
        System.out.printf(
                "--------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf(
                "                                                Data Loan Book Order                                                                  %n");
        System.out.printf(
                "--------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("|%-4s|%-9s|%-14s|%-12s|%-45s|%-18s|%-14s|%-9s|%n", "No", "Loan Id", "Member Name", "Book Id",
                "Title",
                "Loan Book Price", "Loan Duration", "Loan Fee");
        System.out.printf(
                "--------------------------------------------------------------------------------------------------------------------------------------%n");
        int count = 1;
        for (LoanBookOrder loanOrder : loanOrderList) {
            System.out.printf("|%-4d|%-9s|%-14s|%-12s|%-45s|%-18.2f|%-14d|%-9.2f|%n", count++, loanOrder.getLoanId(),
                    loanOrder.getMember().getMemberName(), loanOrder.getLoanBook().getBookId(),
                    loanOrder.getLoanBook().getTitle(), loanOrder.getLoanBook().getLoanPrice(),
                    loanOrder.getLoanDuration(), loanOrder.getLoanFee());
            System.out.printf(
                    "--------------------------------------------------------------------------------------------------------------------------------------%n");
        }
    }

    private static void processReturn() {
        System.out.println("Menu Return Book:\n");
        displayAllLoanOrders();
        System.out.printf("|%-4s|%-127s|%n", "0", "Kembali ke Main Menu");
        System.out.printf(
                "--------------------------------------------------------------------------------------------------------------------------------------%n");
        Scanner scanner = new Scanner(System.in);
        boolean validloanId = false;
        LoanBookOrder returnOrder = null;
        while (!validloanId) {
            System.out.print("\nMasukkan Loan Id: ");
            String loanId = scanner.nextLine();
            if (loanId.equals("0")) {
                System.out.println("Kembali ke Main Menu.");
                return;
            }
            returnOrder = findLoanOrderById(loanId);
            if (returnOrder != null) {
                validloanId = true;
                returnOrder.getLoanBook().setStock(returnOrder.getLoanBook().getStock() + 1);
                loanOrderList.remove(returnOrder);
                System.out.println("Return Book Success!");
            } else {
                System.out.println("Loan ID tidak valid atau buku sudah dikembalikan.");
            }
        }
    }

    private static LoanBookOrder findLoanOrderById(String loanId) {
        for (LoanBookOrder order : loanOrderList) {
            if (order.getLoanId().equals(loanId)) {
                return order;
            }
        }
        return null;
    }

}
