import java.util.Scanner;

public class TeksAlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca string
        String kalimat = scanner.nextLine();

        // Mengubah string menjadi "alay"
        String kalimatAlay = ubahKeAlay(kalimat);

        // Menampilkan hasil
        System.out.println(kalimatAlay);

        scanner.close();
    }

    public static String ubahKeAlay(String kalimat) {
        // Membuat array karakter hasil
        char[] hasil = new char[kalimat.length()];

        // Melakukan konversi sesuai ketentuan
        for (int i = 0; i < kalimat.length(); i++) {
            char karakter = kalimat.charAt(i);
            switch (karakter) {
                case 'A':
                case 'a':
                    hasil[i] = '4';
                    break;
                case 'I':
                case 'i':
                    hasil[i] = '1';
                    break;
                case 'Z':
                case 'z':
                    hasil[i] = '2';
                    break;
                case 'E':
                case 'e':
                    hasil[i] = '3';
                    break;
                case 'G':
                case 'g':
                    hasil[i] = '6';
                    break;
                case 'J':
                case 'j':
                    hasil[i] = '7';
                    break;
                case 'B':
                case 'b':
                    hasil[i] = '8';
                    break;
                default:
                    hasil[i] = karakter;
            }
        }

        // Mengembalikan string hasil
        return new String(hasil);
    }
}
