import java.util.Scanner;

public class BarisanBilangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca suku pertama (S) dari input
        int S = scanner.nextInt();

        int[] barisanBilangan = new int[15];

        for (int i = 0; i < 15; i++) {
            barisanBilangan[i] = S;
            S += (i + 3); 
        }

        for (int bilangan : barisanBilangan) {
            System.out.print(bilangan + " ");
        }
    }
}
