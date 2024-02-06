import java.util.Scanner;

public class LuasLingkaran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double jariJari = scanner.nextDouble();
        double luas = hitungLuasLingkaran(jariJari);

        System.out.printf("%.2f%n", luas);

        scanner.close();
    }

    public static double hitungLuasLingkaran(double jariJari) {
        double pi = 3.14;
        return pi * jariJari * jariJari;
    }
}
