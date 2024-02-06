import java.util.Scanner;

public class KonversiSuhu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suhuReamur = scanner.nextDouble();

        double suhuKelvin = konversiReamurKeKelvin(suhuReamur);

        System.out.printf("%.2f%n", suhuKelvin);

        scanner.close();
    }

    public static double konversiReamurKeKelvin(double suhuReamur) {
        // Rumus konversi suhu Reamur ke Kelvin
        return suhuReamur * 1.25 + 273;
    }
}
