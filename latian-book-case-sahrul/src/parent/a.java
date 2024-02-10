public class Main {
    public static void main(String[] args) {
        RepositoryBook repository = new RepositoryBook();
        repository.initateBookList();

        List<Author> allAuthors = repository.getAllAuthors();

        System.out.println("All Authors:");
        for (Author author : allAuthors) {
            System.out.println(author);
        }
    }
}
