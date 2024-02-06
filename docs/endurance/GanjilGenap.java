import java.util.Scanner;

public class GanjilGenap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        if (x % 2 == 0) {
            System.out.println("genap");
        } else {
            System.out.println("ganjil");
        }

        scanner.close();
    }
}
