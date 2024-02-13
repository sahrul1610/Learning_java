import java.util.ArrayList;
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
    // private static List<BookForLoan> allBooks = new ArrayList<>();
    // private static List<Member> allMembers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        bookRepository.initializeDummyData();
        memberRepository.initializeDummyData();

        System.out.println("Daftar Buku:");
        List<Member> memberList = memberRepository.getAllMember();
        for (Member bookMember : memberList) {
            System.out.println(bookMember);
        }

        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    processLoan();
                    break;
                case 3:
                    processReturn();
                    break;
                case 4:
                    // displayAllLoanOrders
                    displayAllLoanOrders();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n+=================================+");
        System.out.println("Aplikasi Rental Buku Cucux\n");
        System.out.println("1. Fitur Menu List All Book");
        System.out.println("2. Fitur Loan");
        System.out.println("3. Fitur Return");
        System.out.println("4. Fitur Menu List Loan Order");
        System.out.println("5. Exit\n");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void displayAllBooks() {
        List<BookForLoan> allBooks = bookRepository.getAllBookForLoan();
        System.out.println("List All Book:");
        System.out.printf("%-4s%-12s%-45s%-20s%s%n", "No", "Book ID", "Title", "Author", "Stock");
        int count = 1;
        for (BookForLoan book : allBooks) {
            System.out.printf("%-4d%-12s%-45s%-20s%d%n", count++, book.getBookId(), book.getTitle(), book.getAuthor(),
                    book.getStock());
        }
        // System.out.println("\n0. Kembali ke Main Menu");
        // System.out.print("Masukkan pilihan Anda: ");
        // int choice = scanner.nextInt();
        // if (choice == 0) {
        // return;
        // }
    }

    private static void processLoan() {
        // Tampilkan menu Loan
        displayAllBooks();
        System.out.println("\n");
        // Masukkan input dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Member Id: ");
        String memberId = scanner.nextLine();
        System.out.print("Masukkan Book Id: ");
        String bookId = scanner.nextLine();
        System.out.print("Lama Peminjaman: ");
        int loanDuration = scanner.nextInt();

        // Cek apakah buku tersedia
        BookForLoan book = findBookById(bookId);
        if (book != null && book.getStock() > 0) {
            // Kurangi stok buku
            book.setStock(book.getStock() - 1);

            // Tambahkan data peminjaman ke list Loan Order
            Member member = findMemberById(memberId);
            // double loanFee = calculateLoanFee(book, loanDuration);
            LoanBookOrder loanOrder = new LoanBookOrder(generateLoanId(), member, book, loanDuration);
            loanOrderList.add(loanOrder);

            System.out.println("Loan Success!");
        } else {
            System.out.println("Book is not available for loan or does not exist.");
        }
    }

    private static BookForLoan findBookById(String bookId) {
        List<BookForLoan> allBooks = bookRepository.getAllBookForLoan();
        for (BookForLoan book : allBooks) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    private static Member findMemberById(String memberId) {
        List<Member> allMembers = memberRepository.getAllMember();
        for (Member member : allMembers) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    private static String generateLoanId() {
        // Implementasi pembuatan ID peminjaman
        //return "Ord-" + (loanOrderList.size() + 1);
        int nextId = loanOrderList.size() + 1;
        String formattedId = String.format("%03d", nextId); // Format nomor urut menjadi tiga digit dengan leading zeros
        return "Ord-" + formattedId;
    }

    private static void displayAllLoanOrders() {
        System.out.println("Menu Data Loan Book Order:\n");
        System.out.printf("%-4s%-9s%-14s%-12s%-35s%-18s%-14s%-9s%n", "No", "Loan Id", "Member Name", "Book Id", "Title",
                "Loan Book Price", "Loan Duration", "Loan Fee");
        int count = 1;
        for (LoanBookOrder loanOrder : loanOrderList) {
            System.out.printf("%-4d%-9s%-14s%-12s%-35s%-18.2f%-14d%-9.2f%n", count++, loanOrder.getLoanId(),
                    loanOrder.getMember().getMemberName(), loanOrder.getLoanBook().getBookId(),
                    loanOrder.getLoanBook().getTitle(), loanOrder.getLoanBook().getLoanPrice(),
                    loanOrder.getLoanDuration(), loanOrder.getLoanFee());
        }
        // System.out.println("0\tKembali Ke Main Menu\n");
    }

    private static void processReturn() {
        System.out.println("Menu Return Book:\n");

        // Menampilkan data Loan Book Order yang belum dikembalikan
        displayAllLoanOrders();

        // Meminta input dari pengguna untuk memasukkan Loan ID buku yang akan
        // dikembalikan
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Loan Id buku yang akan dikembalikan (0 untuk kembali ke Main Menu): ");
        String loanId = scanner.nextLine();

        // Memeriksa apakah Loan ID yang dimasukkan oleh pengguna valid
        if (loanId.equals("0")) {
            System.out.println("Kembali ke Main Menu.");
            return;
        }

        // Mencari Loan Book Order berdasarkan Loan ID yang dimasukkan
        LoanBookOrder returnOrder = findLoanOrderById(loanId);

        // Memeriksa apakah Loan Book Order ditemukan
        if (returnOrder != null) {
            // Mengembalikan stok buku yang dipinjam
            returnOrder.getLoanBook().setStock(returnOrder.getLoanBook().getStock() + 1);

            // Menghapus data Loan Book Order dari list
            loanOrderList.remove(returnOrder);

            System.out.println("Return Book Success!");
        } else {
            System.out.println("Loan ID tidak valid atau buku sudah dikembalikan.");
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
