import java.util.Scanner;

public class VolumeBola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R1 = scanner.nextInt();
        int R2 = scanner.nextInt();
        int R3 = scanner.nextInt();
        double r = scanner.nextDouble();

        double volume1 = hitungVolumeBola(r);
        double volume2 = hitungVolumeBola(R2 * r / R1);
        double volume3 = hitungVolumeBola(R3 * r / R1);

        System.out.printf("%.2f\n", volume1 + volume2 + volume3);
    }

    private static double hitungVolumeBola(double radius) {
        return (4.0 / 3.0) * 3.14 * Math.pow(radius, 3);
    }
}
