import java.util.Scanner;

public class MatriksIdentitas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        cetakMatriksIdentitas(N);

        scanner.close();
    }

    public static void cetakMatriksIdentitas(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }

            System.out.println();
        }
    }
}
