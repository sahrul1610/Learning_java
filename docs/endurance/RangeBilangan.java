import java.util.Scanner;

public class RangeBilangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        tampilkanBilangan(X, Y);

        scanner.close();
    }

    public static void tampilkanBilangan(int X, int Y) {
        for (int i = X; i <= Y; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
