package parent;

import java.util.ArrayList;
import java.util.List;

public class RepositoryBook {
    private List<CommercialBook> commercialBooks;

    // Constructor default
    public RepositoryBook() {
        // Inisialisasi list buku komersial
        this.commercialBooks = new ArrayList<>();
    }

    // Method untuk menambahkan buku komersial ke dalam repository
    public void addBook(CommercialBook book) {
        commercialBooks.add(book);
    }

    // Method untuk mendapatkan semua buku komersial yang tersedia
    public List<CommercialBook> getAllBook() {
        return commercialBooks;
    }
}

