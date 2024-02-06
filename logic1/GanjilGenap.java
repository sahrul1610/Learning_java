package logic1;
import java.util.Scanner;

public class GanjilGenap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();

        if (X % 2 == 0) {
            System.out.println("genap");
        } else {
            System.out.println("ganjil");
        }
    }
}
