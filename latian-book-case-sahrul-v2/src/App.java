import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

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

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // // initializeAuthors();
        // RepositoryBook repository = new RepositoryBook();
        // // repository.initateBookList();
        // repository.initializeDummyData();
        // List<CommercialBook> allBooks = repository.getAllBooks();
        // for (CommercialBook commercialBook : allBooks) {
        // System.out.println(commercialBook);
        // }

        // // RepositoryBook repository = new RepositoryBook();
        // repository.initializeDummyData();

        do {
            System.out.println("Main Menu");
            System.out.println("1. Book");
            System.out.println("2. Author");
            System.out.println("3. Publisher");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        displayBookMenu(scanner);
                        break;
                    case 2:
                        displayAuthorMenu(scanner);
                        break;
                    case 3:
                        displayPublisherMenu(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
                choice = -1; 
            }
        } while (choice != 0);

        scanner.close();

    }

    private static void displayBookMenu(Scanner scanner) {
        int choice;
        RepositoryBook repository = new RepositoryBook();
        repository.initializeDummyData();
        List<CommercialBook> books = repository.getAllBooks();
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
                    findBookWithLowestPrice(books);
                    break;
                case 2:
                    findBookWithHighestPrice(books);
                    // belum
                    break;
                case 3:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    findBooksInPriceRange(books, minPrice, maxPrice);
                    break;
                case 4:
                    findComicsByMangakaRating(books, scanner);
                    break;
                case 5:
                    System.out.print("Enter publisher country: ");
                    scanner.nextLine();
                    String publisherCountry = scanner.nextLine();
                    findBooksByPublisherCountry(books, publisherCountry);
                    break;
                case 6:
                    System.out.print("Enter author country: ");
                    scanner.nextLine();
                    String authorCountry = scanner.nextLine();
                    findBooksByAuthorCountry(books, authorCountry);

                    break;
                case 7:
                    findComicWithHighestPrice(books);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private static void findBookWithLowestPrice(List<CommercialBook> books) {
        CommercialBook cheapestBook = books.stream()
                .min(Comparator.comparingDouble(CommercialBook::getPrice))
                .orElse(null);
        if (cheapestBook != null) {
            System.out.println("Book with lowest price: " + cheapestBook);
        } else {
            System.out.println("No books found.");
        }
    }

    private static void findBookWithHighestPrice(List<CommercialBook> books) {
        CommercialBook mostExpensiveBook = books.stream()
                .max(Comparator.comparingDouble(CommercialBook::getPrice))
                .orElse(null);
        if (mostExpensiveBook != null) {
            System.out.println("Book with highest price: " + mostExpensiveBook);
        } else {
            System.out.println("No books found.");
        }
    }

    private static void findBooksInPriceRange(List<CommercialBook> books, double minPrice, double maxPrice) {
        List<CommercialBook> booksInRange = books.stream()
                .filter(book -> book.getPrice() >= minPrice && book.getPrice() <= maxPrice)
                .collect(Collectors.toList());
        if (!booksInRange.isEmpty()) {
            System.out.println("Books in price range " + minPrice + " - " + maxPrice + ":");
            booksInRange.forEach(System.out::println);
        } else {
            System.out.println("No books found in the specified price range.");
        }
    }

    private static void findComicsByMangakaRating(List<CommercialBook> books, Scanner scanner) {
        System.out.print("Enter mangaka rating: ");
        scanner.nextLine();
        String mangakaRating = scanner.nextLine();

        List<CommercialBook> comicsByRating = books.stream()
                .filter(book -> book instanceof Comic)
                .filter(book -> ((Comic) book).getAuthor().getRating().equalsIgnoreCase(mangakaRating))
                .collect(Collectors.toList());

        if (!comicsByRating.isEmpty()) {
            System.out.println("Comics by mangaka with rating '" + mangakaRating + "':");
            comicsByRating.forEach(System.out::println);
        } else {
            System.out.println("No comics found by mangaka with rating '" + mangakaRating + "'.");
        }
    }

    private static void findBooksByPublisherCountry(List<CommercialBook> books, String country) {
        List<CommercialBook> booksByPublisherCountry = books.stream()
                .filter(book -> book.getPublisher().getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
        if (!booksByPublisherCountry.isEmpty()) {
            System.out.println("Books published in " + country + ":");
            booksByPublisherCountry.forEach(System.out::println);
        } else {
            System.out.println("No books found published in " + country + ".");
        }
    }

    private static void findBooksByAuthorCountry(List<CommercialBook> books, String authorCountry) {
        List<CommercialBook> booksByAuthorCountry = books.stream()
                .filter(book -> {
                    if (book instanceof Novel) {
                        return ((Novel) book).getAuthor().getCountry().equalsIgnoreCase(authorCountry);
                    } else if (book instanceof Comic) {
                        return ((Comic) book).getAuthor().getCountry().equalsIgnoreCase(authorCountry);
                    } else if (book instanceof EBook) {
                        return ((EBook) book).getAuthor().getCountry().equalsIgnoreCase(authorCountry);
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (!booksByAuthorCountry.isEmpty()) {
            System.out.println("Books by authors from " + authorCountry + ":");
            booksByAuthorCountry.forEach(System.out::println);
        } else {
            System.out.println("No books found by authors from " + authorCountry + ".");
        }
    }

    private static void findComicWithHighestPrice(List<CommercialBook> books) {
        Optional<CommercialBook> comicWithHighestPrice = books.stream()
                .filter(book -> book instanceof Comic)
                .max(Comparator.comparingDouble(CommercialBook::getPrice));

        if (comicWithHighestPrice.isPresent()) {
            System.out.println("Comic with the highest price:");
            System.out.println(comicWithHighestPrice.get());
        } else {
            System.out.println("No comic found.");
        }
    }

    // sudah selesai
    private static void displayAuthorMenu(Scanner scanner) {
        int choice;
        RepositoryBook repository = new RepositoryBook();
        repository.initializeDummyData();
        List<Author> authors = repository.getAllAuthors();
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
                    displayAllMangaka(authors);
                    break;
                case 2:
                    displayAllAuthors(authors);
                    break;
                case 3:
                    displayAllNovelis(authors);
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

    private static void displayAllAuthors(List<Author> authors) {
        System.out.println("\nData semua Author:");

        for (Author author : authors) {
            System.out.println(author);
        }
    }

    private static void displayAllMangaka(List<Author> authors) {
        System.out.println("\nData semua Mangaka:");
        for (Author author : authors) {
            if (author instanceof Mangaka) {
                System.out.println(author);
            }
        }
    }

    private static void displayAllNovelis(List<Author> authors) {
        System.out.println("\nData semua Novelis:");
        for (Author author : authors) {
            if (author instanceof Novelis) {
                System.out.println(author);
            }
        }
    }

    private static void searchAuthorsByAgeRange(List<Author> authors, Scanner scanner) {
        System.out.print("Enter the minimum age: ");
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
        System.out.print("Enter the country: ");
        scanner.nextLine();
        String country = scanner.nextLine();

        System.out.println("\nAuthors from " + country + ":");
        for (Author author : authors) {
            if (author.getCountry().equalsIgnoreCase(country)) {
                System.out.println(author);
            }
        }
    }

    private static void displayPublisherMenu(Scanner scanner) {
        int choice;
        RepositoryBook repository = new RepositoryBook();
        repository.initializeDummyData();
        List<Publisher> publishers = repository.getAllPublisher();
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
