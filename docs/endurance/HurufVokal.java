import java.util.Scanner;

public class HurufVokal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca array 2 dimensi
        char[][] array2D = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array2D[i][j] = scanner.next().charAt(0);
            }
        }

        // Menampilkan posisi huruf vokal
        boolean foundVowel = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (isVowel(array2D[i][j])) {
                    System.out.println(array2D[i][j] + ": (" + (i + 1) + "," + (j + 1) + ")");
                    foundVowel = true;
                }
            }
        }

        // Jika tidak ada huruf vokal
        if (!foundVowel) {
            System.out.println("tidak ada huruf vokal");
        }
    }

    // Fungsi untuk mengecek apakah karakter adalah huruf vokal
    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
