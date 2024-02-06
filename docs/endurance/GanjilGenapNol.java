import java.util.Scanner;

public class GanjilGenapNol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bilangan = scanner.nextInt();

        String hasil = cekGanjilGenapNol(bilangan);

        System.out.println(hasil);

        scanner.close();
    }

    public static String cekGanjilGenapNol(int bilangan) {
        if (bilangan == 0) {
            return "nol";
        } else if (bilangan % 2 == 0) {
            return "genap";
        } else {
            return "ganjil";
        }
    }
}
