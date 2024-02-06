import java.util.Scanner;

public class VolumeLimas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double panjangAlas = scanner.nextDouble();
        double lebarAlas = scanner.nextDouble();
        double tinggiLimas = scanner.nextDouble();

        double volumeLimas = (1.0 / 3) * panjangAlas * lebarAlas * tinggiLimas;

        System.out.printf("%.6f%n", volumeLimas);

        scanner.close();
    }
}
