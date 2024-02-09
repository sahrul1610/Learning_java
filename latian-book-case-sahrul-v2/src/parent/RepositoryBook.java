package parent;

import java.util.ArrayList;
import java.util.List;

import child.Author;
import child.Mangaka;
import child.Novelis;
import child.Publisher;
import model.Comic;
import model.EBook;
import model.Novel;

public class RepositoryBook {
    private List<CommercialBook> commercialBooks;
    private List<Author> authors;
    private List<Mangaka> mangakas;
    private List<Novelis> novelists;
    private List<Publisher> publishers;

    public RepositoryBook() {
        this.commercialBooks = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.mangakas = new ArrayList<>();
        this.novelists = new ArrayList<>();
        this.publishers = new ArrayList<>();
    }

    public void addBook(CommercialBook book) {
        commercialBooks.add(book);
    }

    // public void addAuthor(Author author) {
    // authors.add(author);
    // }

    public void addPublisher(Publisher publisher) {
        publishers.add(publisher);
    }

    public List<CommercialBook> getAllBooks() {
        return commercialBooks;
    }

    public List<Author> getAllAuthors() {
        return authors;
    }

    public List<Publisher> getAllPublisher() {
        return publishers;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        if (author instanceof Mangaka) {
            mangakas.add((Mangaka) author);
        } else if (author instanceof Novelis) {
            novelists.add((Novelis) author);
        }
    }

    

    

    public List<Mangaka> getAllMangakas() {
        return mangakas;
    }

    public List<Novelis> getAllNovelists() {
        return novelists;
    }

    public void initializeDummyData() {

        // Dummy data untuk authors
        Author author1 = new Author("Haidar", "Musyafa", "Indonesia", 30);
        Author author2 = new Author("Bert", "Bates", "United States", 50);
        Author author3 = new Author("Barry", "Burd", "United States", 52);
        Author author4 = new Author("Mark", "Manson", "United States", 38);
        Author author5 = new Author("Andi", "Susanto", "Indonesia", 32);
        Author author6 = new Author("Adi", "Sutanto", "Indonesia", 27);

        // Dummy data untuk mangakas

        Author mangaka1 = new Mangaka("Masashi", "Kisimoto", "Japan", 48, "Best Seller");
        Author mangaka2 = new Mangaka("Yoshihiro", "Togashi", "Japan", 56, "Good");
        Author mangaka3 = new Mangaka("Eiichiro", "Oda", "Japan", 57, "Best Seller");
        Author mangaka4 = new Mangaka("Rizki", "Anwar", "Indonesia", 25, "New Commer");
        Author mangaka5 = new Mangaka("Yusuf", "Fadli", "Indonesia", 32, "New Commer");

        // Dummy data untuk novelists
        Author novelis1 = new Novelis("J.K", "Rowling", "England", 57, true, "Best Seller");
        Author novelis2 = new Novelis("Tere", "Liye", "Indonesia", 35, true, "Best Seller");
        Author novelis3 = new Novelis("Dee", "Lestari", "Indonesia", 30, true, "Good");
        Author novelis4 = new Novelis("Faisal", "Syahreza", "Indonesia", 40, true, "New Commer");
        Author novelis5 = new Novelis("Julia", "Golding", "England", 41, false, "Best Seller");

        // Dummy data untuk publishers
        Publisher publishers1 = new Publisher("Bloomsbury", "United Kingdom", 30.0);
        Publisher publishers2 = new Publisher("Gramedia", "Indonesia", 50.0);
        Publisher publishers3 = new Publisher("Mizan", "Indonesia", 25.0);
        Publisher publishers4 = new Publisher("Shueisha", "Japan", 25.0);
        Publisher publishers5 = new Publisher("Elex Media Komputindo", "Indonesia", 12.0);
        Publisher publishers6 = new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0);
        Publisher publishers7 = new Publisher("Lion Hudson", "England", 15.0);
        Publisher publishers8 = new Publisher("O Reilly Media", "United State", 30.0);
        Publisher publishers9 = new Publisher("Harper One", "United State", 25.0);

        addAuthor(author1);
        addAuthor(author2);
        addAuthor(author3);
        addAuthor(author4);
        addAuthor(author5);
        addAuthor(author6);

        addAuthor(mangaka1);
        addAuthor(mangaka2);
        addAuthor(mangaka3);
        addAuthor(mangaka4);
        addAuthor(mangaka5);

        addAuthor(novelis1);
        addAuthor(novelis2);
        addAuthor(novelis3);
        addAuthor(novelis4);
        addAuthor(novelis5);

        addPublisher(publishers1);
        addPublisher(publishers2);
        addPublisher(publishers3);
        addPublisher(publishers4);
        addPublisher(publishers5);
        addPublisher(publishers6);
        addPublisher(publishers7);
        addPublisher(publishers8);
        addPublisher(publishers9);
    }

    public void initateBookList() {

        // Dummy data untuk authors
        Author author1 = new Author("Haidar", "Musyafa", "Indonesia", 30);
        Author author2 = new Author("Bert", "Bates", "United States", 50);
        Author author3 = new Author("Barry", "Burd", "United States", 52);
        Author author4 = new Author("Mark", "Manson", "United States", 38);
        Author author5 = new Author("Andi", "Susanto", "Indonesia", 32);
        Author author6 = new Author("Adi", "Sutanto", "Indonesia", 27);

        // Dummy data untuk mangakas

        Mangaka mangaka1 = new Mangaka("Masashi", "Kisimoto", "Japan", 48, "Best Seller");
        Mangaka mangaka2 = new Mangaka("Yoshihiro", "Togashi", "Japan", 56, "Good");
        Mangaka mangaka3 = new Mangaka("Eiichiro", "Oda", "Japan", 57, "Best Seller");
        Mangaka mangaka4 = new Mangaka("Rizki", "Anwar", "Indonesia", 25, "New Commer");
        Mangaka mangaka5 = new Mangaka("Yusuf", "Fadli", "Indonesia", 32, "New Commer");

        // Dummy data untuk novelists
        Novelis novelis1 = new Novelis("J.K", "Rowling", "England", 57, true, "Best Seller");
        Novelis novelis2 = new Novelis("Tere", "Liye", "Indonesia", 35, true, "Best Seller");
        Novelis novelis3 = new Novelis("Dee", "Lestari", "Indonesia", 30, true, "Good");
        Novelis novelis4 = new Novelis("Faisal", "Syahreza", "Indonesia", 40, true, "New Commer");
        Novelis novelis5 = new Novelis("Julia", "Golding", "England", 41, false, "Best Seller");

        // Dummy data untuk publishers
        Publisher publishers1 = new Publisher("Bloomsbury", "United Kingdom", 30.0);
        Publisher publishers2 = new Publisher("Gramedia", "Indonesia", 50.0);
        Publisher publishers3 = new Publisher("Mizan", "Indonesia", 25.0);
        Publisher publishers4 = new Publisher("Shueisha", "Japan", 25.0);
        Publisher publishers5 = new Publisher("Elex Media Komputindo", "Indonesia", 12.0);
        Publisher publishers6 = new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0);
        Publisher publishers7 = new Publisher("Lion Hudson", "England", 15.0);
        Publisher publishers8 = new Publisher("O Reilly Media", "United State", 30.0);
        Publisher publishers9 = new Publisher("Harper One", "United State", 25.0);

        addAuthor(author1);
        addAuthor(author2);
        addAuthor(author3);
        addAuthor(author4);
        addAuthor(author5);
        addAuthor(author6);

        addAuthor(mangaka1);
        addAuthor(mangaka2);
        addAuthor(mangaka3);
        addAuthor(mangaka4);
        addAuthor(mangaka5);

        addAuthor(novelis1);
        addAuthor(novelis2);
        addAuthor(novelis3);
        addAuthor(novelis4);
        addAuthor(novelis5);

        addPublisher(publishers1);
        addPublisher(publishers2);
        addPublisher(publishers3);
        addPublisher(publishers4);
        addPublisher(publishers5);
        addPublisher(publishers6);
        addPublisher(publishers7);
        addPublisher(publishers8);
        addPublisher(publishers9);

       
        CommercialBook ebook1 = new EBook("Book - 001", "Memahami Hamka", author1, publishers3);
        CommercialBook ebook2 = new EBook("Book - 002", "Head First Java: Your Brain on Java - A Learner's Guide", author2, publishers8);
        CommercialBook ebook3 = new EBook("Book - 003", "Java For Dummies", author3, publishers8);
        CommercialBook ebook4 = new EBook("Book - 004", "Flutter For Dummies", author3, publishers8);
        CommercialBook ebook5 = new EBook("Book - 005", "The Subtle Art of Not Giving", author4, publishers9);
        CommercialBook ebook6 = new EBook("Book - 006", "Will", author4, publishers9);
        CommercialBook ebook7 = new EBook("Book - 007", "Sejarah Indonesia", author5, publishers6);
        CommercialBook ebook8 = new EBook("Book - 008", "Teknologi Baru", author6, publishers5);

        CommercialBook novel1 = new Novel("Novel - 001", "Harry Potter and the Philosopher's Stone", novelis1,
                publishers1, "Fantasy");
        CommercialBook novel2 = new Novel("Novel - 002", "Harry Potter and the Chamber of Secrets", novelis1,
                publishers1, "Fantasy");
        CommercialBook novel3 = new Novel("Novel - 003", "Harry Potter and the Prisoner of Azkaban", novelis1,
                publishers1, "Fantasy");
        CommercialBook novel4 = new Novel("Novel - 004", "Ayah Aku Berbeda", novelis2, publishers2, "Drama");
        CommercialBook novel5 = new Novel("Novel - 005", "Madre", novelis3, publishers2, "Drama");
        CommercialBook novel6 = new Novel("Novel - 006", "Lagu untuk Renjana", novelis4, publishers3, "Drama");
        CommercialBook novel7 = new Novel("Novel - 007", "Semoga Lekas Lega", novelis4, publishers3, "Drama");

        CommercialBook comic1 = new Comic("Comic - 001", "Uzumaki Naruto", mangaka1, publishers4, true);
        CommercialBook comic2 = new Comic("Comic - 002", "The Worst Client", mangaka1, publishers4, true);
        CommercialBook comic3 = new Comic("Comic - 003", "For the Sake of Dreams...!!", mangaka1, publishers4, true);
        CommercialBook comic4 = new Comic("Comic - 004", "Hunter X Hunter : The Day of Departure", mangaka2,
                publishers4, true);
        CommercialBook comic5 = new Comic("Comic - 005", "Hunter X Hunter : A Struggle in the Mist", mangaka2,
                publishers4, true);
        CommercialBook comic6 = new Comic("Comic - 006", "One Piece", mangaka3, publishers2, true);
        CommercialBook comic7 = new Comic("Comic - 007", "Petualangan di Indonesia", mangaka4, publishers6, false);
        CommercialBook comic8 = new Comic("Comic - 008", "Petualangan di Jakarta", mangaka5, publishers5, false);

        addBook(ebook1);
        addBook(ebook2);
        addBook(ebook3);
        addBook(ebook4);
        addBook(ebook5);
        addBook(ebook6);
        addBook(ebook7);
        addBook(ebook8);

        addBook(novel1);
        addBook(novel2);
        addBook(novel3);
        addBook(novel4);
        addBook(novel5);
        addBook(novel6);
        addBook(novel7);

        addBook(comic1);
        addBook(comic2);
        addBook(comic3);
        addBook(comic4);
        addBook(comic5);
        addBook(comic6);
        addBook(comic7);
        addBook(comic8);
    }

}
