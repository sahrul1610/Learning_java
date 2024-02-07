import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import child.Author;
import child.Mangaka;
import child.Novelis;
import child.Publisher;
import model.Comic;
import model.EBook;
import model.Novel;
import parent.CommercialBook;
import parent.RepositoryBook;

public class App {
    private static List<Author> authors = new ArrayList<>();
    private static List<Mangaka> mangakas = new ArrayList<>();
    private static List<Novelis> novelists = new ArrayList<>();
    List<Publisher> publishers = getDummyPublishers();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice;

        initializeAuthors();
        // Author author = new Author("sahrul", "Fazri", "indonesia", 22);
        // author.setFirstName("udin");
        // author.greeting();

        // Mangaka mangaka = new Mangaka("andika", "wahyu", "indonesia", 17, "100");
        // mangaka.greeting();

        // input.close();
        // Tambahkan buku-buku dari dataset
        RepositoryBook repository = new RepositoryBook();
        addBooksToRepository(repository);

        do {
            System.out.println("Main Menu");
            System.out.println("1. Book");
            System.out.println("2. Author");
            System.out.println("3. Publisher");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Tampilkan sub-menu Book
                    displayBookMenu(scanner);
                    break;
                case 2:
                    // Tampilkan sub-menu Author
                    displayAuthorMenu(scanner);
                    break;
                case 3:
                    // Tampilkan sub-menu Publisher
                    displayPublisherMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();

    }

    private static void displayBookMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("\nBook Menu Searching");
            System.out.println("1. Cari data book yang memiliki price paling Murah");
            System.out.println("2. Cari data book yang memiliki price paling Mahal");
            System.out.println("3. Cari data book berdasarkan range Price");
            System.out.println("4. Cari Comic Berdasarkan Rating mangaka");
            System.out.println("5. Cari Book berdasarkan Country dari Publishernya");
            System.out.println("6. Cari Book berdasarkan Country dari Authornya");
            System.out.println("7. Cari data Comic yang memiliki price paling Mahal");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Logika untuk mencari data book dengan price paling murah
                    break;
                case 2:
                    // Logika untuk mencari data book dengan price paling mahal
                    break;
                case 3:
                    // Logika untuk mencari data book berdasarkan range price
                    break;
                case 4:
                    // Logika untuk mencari comic berdasarkan rating mangaka
                    break;
                case 5:
                    // Logika untuk mencari book berdasarkan country dari publisher
                    break;
                case 6:
                    // Logika untuk mencari book berdasarkan country dari author
                    break;
                case 7:
                    // Logika untuk mencari data comic yang memiliki price paling mahal
                    break;
                case 0:
                    // Kembali ke menu utama
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }



    //belum selesai
    private static void addBooksToRepository(RepositoryBook repository) {
        // Tambahkan buku-buku dari dataset ke repository
        List<CommercialBook> allBooks = repository.getAllBook();
        repository.addBook(new EBook("001", "Memahami Hamka", new Author("Haidar", "Musyafa", "Indonesia", 30),
                new Publisher("Mizan"), 50.0));
        repository.addBook(new EBook("002", "Head First Java: Your Brain on Java - A Learner's Guide",
                new Author("Bert", "Bates", "United States", 50), new Publisher("O Reilly Media"), 40.0));
        repository.addBook(new EBook("003", "Java For Dummies", new Author("Barry", "Burd", "United States", 52),
                new Publisher("O Reilly Media"), 45.0));
        repository.addBook(new EBook("004", "Flutter For Dummies", new Author("Barry", "Burd", "United States", 52),
                new Publisher("O Reilly Media"), 55.0));
        repository.addBook(new EBook("005", "The Subtle Art of Not Giving",
                new Author("Mark", "Manson", "United States", 38), new Publisher("Harper One"), 30.0));
        repository.addBook(new EBook("006", "Will", new Author("Mark", "Manson", "United States", 38),
                new Publisher("Harper One"), 25.0));
        repository.addBook(new EBook("007", "Sejarah Indonesia", new Author("Andi", "Susanto", "Indonesia", 32),
                new Publisher("Gramedia Pustaka Utama"), 20.0));
        repository.addBook(new EBook("008", "Teknologi Baru", new Author("Adi", "Sutanto", "Indonesia", 27),
                new Publisher("Elex Media Komputindo"), 15.0));

        repository.addBook(new Novel("001", "Harry Potter and the Philosopher's Stone",
                new Novelis("J.K", "Rowling", "United Kingdom", 55, true, "Rating A"), new Publisher("Bloomsbury"),
                100.0, "Fantasy"));
        repository.addBook(new Novel("002", "Harry Potter and the Chamber of Secrets",
                new Novelis("J.K", "Rowling", "United Kingdom", 55, true, "Rating A"), new Publisher("Bloomsbury"),
                110.0, "Fantasy"));
        repository.addBook(new Novel("003", "Harry Potter and the Prisoner of Azkaban",
                new Novelis("J.K", "Rowling", "United Kingdom", 55, true, "Rating A"), new Publisher("Bloomsbury"),
                120.0, "Fantasy"));
        repository.addBook(
                new Novel("004", "Ayah Aku Berbeda", new Novelis("Tere", "Liye", "Indonesia", 40, true, "Rating B"),
                        new Publisher("Gramedia"), 90.0, "Drama"));
        repository.addBook(new Novel("005", "Madre", new Novelis("Dee", "Lestari", "Indonesia", 45, true, "Rating C"),
                new Publisher("Gramedia"), 95.0, "Drama"));
        repository.addBook(new Novel("006", "Lagu untuk Renjana",
                new Novelis("Faisal", "Syahreza", "Indonesia", 35, true, "Rating D"), new Publisher("Mizan"), 80.0,
                "Drama"));
        repository.addBook(new Novel("007", "Semoga Lekas Lega",
                new Novelis("Faisal", "Syahreza", "Indonesia", 35, true, "Rating D"), new Publisher("Mizan"), 85.0,
                "Drama"));
        repository.addBook(
                new Novel("008", "The Abbey Mystery", new Novelis("Julia", "Golding", "England", 45, true, "Rating E"),
                        new Publisher("Lion Hudson"), 75.0, "Fiction"));

        repository
                .addBook(new Comic("001", "Uzumaki Naruto", new Mangaka("Masashi", "Kisimoto", "Japan", 50, "Rating A"),
                        new Publisher("Shueisha"), 20.0, true, 2.0));
        repository.addBook(
                new Comic("002", "The Worst Client", new Mangaka("Masashi", "Kisimoto", "Japan", 50, "Rating A"),
                        new Publisher("Shueisha"), 25.0, true, 2.5));
        repository.addBook(new Comic("003", "For the Sake of Dreams...!!",
                new Mangaka("Masashi", "Kisimoto", "Japan", 50, "Rating A"), new Publisher("Shueisha"), 30.0, true,
                3.0));
        repository.addBook(new Comic("004", "Hunter X Hunter : The Day of Departure",
                new Mangaka("Yoshihiro", "Togashi", "Japan", 55, "Rating B"), new Publisher("Shueisha"), 35.0, true,
                3.5));
        repository.addBook(new Comic("005", "Hunter X Hunter : A Struggle in the Mist",
                new Mangaka("Yoshihiro", "Togashi", "Japan", 55, "Rating B"), new Publisher("Shueisha"), 40.0, true,
                4.0));
        repository.addBook(new Comic("006", "One Piece", new Mangaka("Eiichiro", "Oda", "Japan", 60, "Rating C"),
                new Publisher("Gramedia"), 45.0, true, 4.5));
        repository.addBook(
                new Comic("007", "Petualangan di Indonesia", new Mangaka("Rizki", "Anwar", "Indonesia", 30, "Rating D"),
                        new Publisher("Gramedia Pustaka Utama"), 25.0, false, 0.0));
        repository.addBook(
                new Comic("008", "Petualangan di Jakarta", new Mangaka("Yusuf", "Fadli", "Indonesia", 35, "Rating E"),
                        new Publisher("Elex Media Komputindo"), 30.0, false, 0.0));
    }

    // private static void displayAllBooks() {
    //     System.out.println("\nData semua Mangaka:");
    //     for (CommercialBook book : allBooks) {
    //         System.out.println(book);
    //     }
    // }
    // sudah selesai
    private static void displayAuthorMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("\nAuthor Menu Searching");
            System.out.println("1. Cari Data semua Mangaka");
            System.out.println("2. Cari Data semua Author");
            System.out.println("3. Cari Data semua Novelis");
            System.out.println("4. Cari author berdasarkan Range umur");
            System.out.println("5. Cari author berdasarkan Country");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllMangaka();
                    break;
                case 2:
                    displayAllAuthors();
                    break;
                case 3:
                    displayAllNovelis();
                    break;
                case 4:
                    searchAuthorsByAgeRange(authors, scanner);
                    break;
                case 5:
                    searchAuthorsByCountry(authors, scanner);

                    break;
                case 0:
                    // Kembali ke menu utama
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    // Metode untuk menampilkan semua data author
    private static void displayAllAuthors() {
        System.out.println("\nData semua Author:");
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    private static void displayAllMangaka() {
        System.out.println("\nData semua Mangaka:");
        for (Mangaka mangaka : mangakas) {
            System.out.println(mangaka);
        }
    }

    private static void displayAllNovelis() {
        System.out.println("\nData semua Mangaka:");
        for (Novelis novelis : novelists) {
            System.out.println(novelis);
        }
    }


     // Tampilkan semua buku
        
        

    // Method untuk mencari author berdasarkan range umur
    private static void searchAuthorsByAgeRange(List<Author> authors, Scanner scanner) {
        System.out.print("\nEnter the minimum age: ");
        int minAge = scanner.nextInt();
        System.out.print("Enter the maximum age: ");
        int maxAge = scanner.nextInt();

        System.out.println("\nAuthors within the age range " + minAge + " to " + maxAge + ":");
        for (Author author : authors) {
            if (author.getAge() >= minAge && author.getAge() <= maxAge) {
                System.out.println(author);
            }
        }
    }

    private static void searchAuthorsByCountry(List<Author> authors, Scanner scanner) {
        System.out.print("\nEnter the country: ");
        scanner.nextLine();
        String country = scanner.nextLine();

        System.out.println("\nAuthors from " + country + ":");
        for (Author author : authors) {
            if (author.getCountry().equalsIgnoreCase(country)) {
                System.out.println(author);
            }
        }
    }

    private static void initializeAuthors() {
        // Anda bisa mengisi data author dari berbagai sumber, misalnya dari database
        authors.add(new Author("Haidar", "Musyafa", "Indonesia", 30));
        authors.add(new Author("Bert", "Bates", "United States", 50));
        authors.add(new Author("Barry", "Burd", "United States", 52));
        authors.add(new Author("Mark", "Manson", "United States", 38));
        authors.add(new Author("Andi", "Susanto", "Indonesia", 32));
        authors.add(new Author("Adi", "Sutanto", "Indonesia", 27));

        mangakas.add(new Mangaka("Masashi", "Kisimoto", "Japan", 48, "Best Seller"));
        mangakas.add(new Mangaka("Yoshihiro", "Togashi", "Japan", 56, "Good"));
        mangakas.add(new Mangaka("Eiichiro", "Oda", "Japan", 57, "Best Seller"));
        mangakas.add(new Mangaka("Rizki", "Anwar", "Indonesia", 25, "New Commer"));
        mangakas.add(new Mangaka("Yusuf", "Fadli", "Indonesia", 32, "New Commer"));

        novelists.add(new Novelis("J.K", "Rowling", "England", 57, true, "Best Seller"));
        novelists.add(new Novelis("Tere", "Liye", "Indonesia", 35, true, "Best Seller"));
        novelists.add(new Novelis("Dee", "Lestari", "Indonesia", 30, true, "Good"));
        novelists.add(new Novelis("Faisal", "Syahreza", "Indonesia", 40, true, "New Commer"));
        novelists.add(new Novelis("Julia", "Golding", "England", 41, false, "Best Seller"));

    }

    private static void displayPublisherMenu(Scanner scanner) {
        int choice;
        List<Publisher> publishers = getDummyPublishers();
        do {
            System.out.println("\nPublisher Menu Searching");
            System.out.println("1. Cari Publisher dengan productionCost paling Mahal");
            System.out.println("2. Cari Publisher dengan productionCost paling Murah");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    findPublisherWithHighestProductionCost(publishers);
                    break;
                case 2:
                    findPublisherWithLowestProductionCost(publishers);
                    break;
                case 0:
                    // Kembali ke menu utama
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static List<Publisher> getDummyPublishers() {
        // Dummy data untuk publisher
        List<Publisher> publishers = new ArrayList<>();
        publishers.add(new Publisher("Bloomsbury", "United Kingdom", 30.0));
        publishers.add(new Publisher("Gramedia", "Indonesia", 50.0));
        publishers.add(new Publisher("Mizan", "Indonesia", 25.0));
        publishers.add(new Publisher("Shueisha", "Japan", 25.0));
        publishers.add(new Publisher("Elex Media Komputindo", "Indonesia", 12.0));
        publishers.add(new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0));
        publishers.add(new Publisher("Lion Hudson", "England", 15.0));
        publishers.add(new Publisher("O Reilly Media", "United State", 30.0));
        publishers.add(new Publisher("Harper One", "United State", 25.0));
        return publishers;
    }

    private static void findPublisherWithHighestProductionCost(List<Publisher> publishers) {
        // Mencari publisher dengan production cost tertinggi
        Publisher maxCostPublisher = publishers.stream()
                .max(Comparator.comparing(Publisher::getProductionCost))
                .orElse(null);

        if (maxCostPublisher != null) {
            System.out.println("Publisher dengan production cost tertinggi:");
            System.out.println(maxCostPublisher);
        } else {
            System.out.println("Tidak ada publisher ditemukan.");
        }
    }

    private static void findPublisherWithLowestProductionCost(List<Publisher> publishers) {
        // Mencari publisher dengan production cost terendah
        Publisher minCostPublisher = publishers.stream()
                .min(Comparator.comparing(Publisher::getProductionCost))
                .orElse(null);

        if (minCostPublisher != null) {
            System.out.println("Publisher dengan production cost terendah:");
            System.out.println(minCostPublisher);
        } else {
            System.out.println("Tidak ada publisher ditemukan.");
        }
    }
}
