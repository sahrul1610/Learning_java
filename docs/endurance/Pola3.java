import java.util.Scanner;

public class Pola3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int startNumber = 1;

        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(startNumber++ + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
