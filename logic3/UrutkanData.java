import java.util.Scanner;

public class UrutkanData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca tiga bilangan bulat
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // Mengurutkan secara descending
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (b < c) {
            int temp = b;
            b = c;
            c = temp;
        }

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Menampilkan hasil pengurutan
        System.out.println(a + " " + b + " " + c);

        scanner.close();
    }
}
