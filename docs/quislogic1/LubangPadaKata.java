import java.util.Scanner;

// soal no 2 betul kuis 1
public class LubangPadaKata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input kata atau kalimat
        String input = scanner.nextLine();

        // Hitung total lubang pada kata atau kalimat
        int totalLubang = countLubang(input);

        // Tampilkan total lubang
        System.out.println(totalLubang);

        scanner.close();
    }

    // Fungsi untuk menghitung total lubang pada sebuah kata atau kalimat
    public static int countLubang(String str) {
        int totalLubang = 0;

        // Iterasi melalui setiap karakter pada kata atau kalimat
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // Tambahkan jumlah lubang dari setiap karakter
            totalLubang += countLubangPerKarakter(currentChar);
        }

        return totalLubang;
    }

    // Fungsi untuk menghitung jumlah lubang pada huruf besar
    public static int countLubangHurufBesar(char c) {
        switch (c) {
            // Daftar huruf besar yang memiliki lubang, dan jumlah lubangnya masing-masing
            case 'A':
            case 'D':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
                return 1;
            case 'B':
                return 2;
            case 'G':
                return 0; // Huruf G tidak memiliki lubang
            default:
                return 0; // Karakter lain tidak memiliki lubang
        }
    }

    // Fungsi untuk menghitung jumlah lubang pada huruf kecil
    public static int countLubangHurufKecil(char c) {
        switch (c) {
            // Daftar huruf kecil yang memiliki lubang, dan jumlah lubangnya masing-masing
            case 'a':
            case 'b':
            case 'd':
            case 'o':
            case 'p':
            case 'q':
            case 'e':
            case 'g':
                return 1;
            default:
                return 0; // Karakter lain tidak memiliki lubang
        }
    }

    // Fungsi untuk menghitung jumlah lubang pada angka
    public static int countLubangAngka(char c) {
        switch (c) {
            // Daftar angka yang memiliki lubang, dan jumlah lubangnya masing-masing
            case '6':
            case '9':
            case '0':
            case '4':
                return 1;
            case '8':
                return 2;
            default:
                return 0; // Karakter lain tidak memiliki lubang
        }
    }

    // Fungsi untuk menghitung jumlah lubang berdasarkan jenis karakter (huruf besar, huruf kecil, atau angka)
    public static int countLubangPerKarakter(char c) {
        if (Character.isUpperCase(c)) {
            return countLubangHurufBesar(c);
        } else if (Character.isLowerCase(c)) {
            return countLubangHurufKecil(c);
        } else if (Character.isDigit(c)) {
            return countLubangAngka(c);
        } else {
            return 0; // Karakter selain huruf dan angka tidak memiliki lubang
        }
    }
}
