import java.util.Scanner;

public class KonversiSuhu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double suhuCelcius = scanner.nextDouble();
        double suhuFahrenheit = konversiCelciusToFahrenheit(suhuCelcius);

        System.out.printf("%.2f%n", suhuFahrenheit);

        scanner.close();
    }

    public static double konversiCelciusToFahrenheit(double suhuCelcius) {
        return suhuCelcius * 1.8 + 32;
    }
}
