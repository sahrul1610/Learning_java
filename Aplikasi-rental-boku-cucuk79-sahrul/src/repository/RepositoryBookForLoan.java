package repository;
import java.util.ArrayList;
import java.util.List;

import child.BookForLoan;
import model.Comic;
import model.Novel;

public class RepositoryBookForLoan {
    private List<BookForLoan> bookList;


    public RepositoryBookForLoan() {
        this.bookList = new ArrayList<>();

    }

    public void addBook(BookForLoan book) {
        bookList.add(book);
    }

    // Method untuk inisialisasi data dummy
    public void initializeDummyData() {
        
        // Tambahkan data buku Comic
        bookList.add(new Comic("Comic - 001", "Uzumaki Naruto", "Masashi Kisimoto", 55000,  10, "Shounen"));
        bookList.add(new Comic("Comic - 002", "The Worst Client", "Masashi Kisimoto", 35000,  20, "Shounen"));
        bookList.add(new Comic("Comic - 003", "For the Sake of Dreams...!!", "Masashi Kisimoto", 35000,  15, "Shounen"));
        bookList.add(new Comic("Comic - 004", "Hunter X Hunter : The Day of Departure", "Yoshihiro Togashi", 50000,  15, "Fantasy"));
        bookList.add(new Comic("Comic - 005", "Hunter X Hunter : A Struggle in the Mist", "Yoshihiro Togashi", 80000,  25, "Fantasy"));

        // Tambahkan data buku Novel
        bookList.add(new Novel("Novel - 001", "Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 10, true));
        bookList.add(new Novel("Novel - 002", "Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000,  10, true));
        bookList.add(new Novel("Novel - 003", "Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000,  15, true));
        bookList.add(new Novel("Novel - 004", "Ayah Aku Berbeda", "Tere Liye", 35000,  15, false));
        bookList.add(new Novel("Novel - 005", "Madre", "Dee Lestari", 80000, 10, false));

    }

    // Method untuk mendapatkan semua buku yang dapat dipinjam
    public List<BookForLoan> getAllBookForLoan() {
        return this.bookList;
    }

}
