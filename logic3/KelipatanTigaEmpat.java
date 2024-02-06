import java.util.Scanner;

public class KelipatanTigaEmpat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bilangan = scanner.nextInt();
        int cek = 0;

        if (bilangan % 3 == 0 && bilangan % 4 == 0) {
            cek = 1;
        }

        System.out.println(cek);

        scanner.close();
    }
}
