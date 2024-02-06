import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import child.Author;
// import child.Mangaka;
// import parent.Person;
import child.Mangaka;
import child.Novelis;

public class App {
    private static List<Author> authors = new ArrayList<>();
    private static List<Mangaka> mangakas = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Author author = new Author("sahrul", "Fazri", "indonesia", 22);
        // author.setFirstName("udin");
        // author.greeting();

        // Mangaka mangaka = new Mangaka("andika", "wahyu", "indonesia", 17, "100");
        // mangaka.greeting();

        // input.close();
        int choice;
        initializeAuthors();

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
                    // Logika untuk mencari data semua mangaka
                    displayAllMangaka();
                    break;
                case 2:
                    // Logika untuk mencari data semua author
                    displayAllAuthors();
                    break;
                case 3:
                    // Logika untuk mencari data semua novelis
                    break;
                case 4:
                    // Logika untuk mencari author berdasarkan range umur
                    searchAuthorsByAgeRange(authors, scanner);

                    break;
                case 5:
                    // Logika untuk mencari author berdasarkan country
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
        scanner.nextLine(); // Membersihkan buffer
        String country = scanner.nextLine();

        System.out.println("\nAuthors from " + country + ":");
        for (Author author : authors) {
            if (author.getCountry().equalsIgnoreCase(country)) {
                System.out.println(author);
            }
        }
    }

    // Metode untuk menginisialisasi data author
    // private static void initializeAuthors() {
    // // Anda bisa mengisi data author dari berbagai sumber, misalnya dari database
    // atau input pengguna
    // authors.add(new Author("Haidar", "Musyafa", "Indonesia", 30));
    // authors.add(new Author("Bert", "Bates", "United States", 50));
    // authors.add(new Author("Barry", "Burd", "United States", 52));
    // authors.add(new Author("Mark", "Manson", "United States", 38));
    // authors.add(new Author("Andi", "Susanto", "Indonesia", 32));
    // authors.add(new Author("Adi", "Sutanto", "Indonesia", 27));

    // authors.add(new Mangaka("Mangaka1", "Lastname1", "Country1", 25, "Rating1"));
    // authors.add(new Author("Author2", "Lastname2", "Country2", 30));
    // authors.add(new Novelis("Novelis3", "Lastname3", "Country3", 35, true,
    // "Rating3"));
    // authors.add(new Mangaka("Mangaka4", "Lastname4", "Country4", 40, "Rating4"));
    // authors.add(new Novelis("Novelis5", "Lastname5", "Country5", 45, false,
    // "Rating5"));
    // }
    private static void initializeAuthors() {
        // Anda bisa mengisi data author dari berbagai sumber, misalnya dari database
        // atau input pengguna


        authors.add(new Author("Haidar", "Musyafa", "Indonesia", 30));
        authors.add(new Author("Bert", "Bates", "United States", 50));
        authors.add(new Author("Barry", "Burd", "United States", 52));
        authors.add(new Author("Mark", "Manson", "United States", 38));
        authors.add(new Author("Andi", "Susanto", "Indonesia", 32));
        authors.add(new Author("Adi", "Sutanto", "Indonesia", 27));

        mangakas.add(new Mangaka("Mangaka1", "Lastname1", "Country1", 25, "Rating1"));
        mangakas.add(new Mangaka("Mangaka4", "Lastname4", "Country4", 40, "Rating4"));

        // novelists.add(new Novelis("Novelis3", "Lastname3", "Country3", 35, true, "Rating3"));
        // novelists.add(new Novelis("Novelis5", "Lastname5", "Country5", 45, false, "Rating5"));
    }

    private static void displayPublisherMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("\nPublisher Menu Searching");
            System.out.println("1. Cari Publisher dengan productionCost paling Mahal");
            System.out.println("2. Cari Publisher dengan productionCost paling Murah");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Logika untuk mencari publisher dengan productionCost paling mahal
                    break;
                case 2:
                    // Logika untuk mencari publisher dengan productionCost paling murah
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
}
