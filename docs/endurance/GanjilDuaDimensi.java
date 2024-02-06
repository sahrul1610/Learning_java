import java.util.Scanner;

public class GanjilDuaDimensi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] X = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                X[i][j] = scanner.nextInt();
            }
        }

        int jumlahGanjil = hitungBanyakGanjil(X);
        System.out.println(jumlahGanjil);

        scanner.close();
    }
    
    private static int hitungBanyakGanjil(int[][] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
