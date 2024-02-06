import java.util.Scanner;

public class Pola1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca nilai N
        int N = scanner.nextInt();

        // Membuat pola
        buatPola(N);

        scanner.close();
    }

    public static void buatPola(int N) {
        // Membuat pola dengan dua loop bersarang
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
