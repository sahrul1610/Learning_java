import java.util.Scanner;

public class KonversiRomawi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int desimal = scanner.nextInt();

        String romawi = konversiKeRomawi(desimal);

        System.out.println(romawi);

        scanner.close();
    }

    public static String konversiKeRomawi(int desimal) {
        String[] simbolRomawi = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] nilaiRomawi = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder hasil = new StringBuilder();
        int i = 12;

        while (desimal > 0) {
            int pembagi = desimal / nilaiRomawi[i];
            desimal %= nilaiRomawi[i];

            while (pembagi-- > 0) {
                hasil.append(simbolRomawi[i]);
            }

            i--;
        }

        return hasil.toString();
    }
}
