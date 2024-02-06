import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nilai maksimum: ");
        int nilaiMaksimum = scanner.nextInt();

        tampilkanFibonacci(nilaiMaksimum);
    }

    private static void tampilkanFibonacci(int nilaiMaksimum) {
        int a = 0, b = 1, c;

        System.out.print(a + " " + b + " ");

        while ((c = a + b) <= nilaiMaksimum) {
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
