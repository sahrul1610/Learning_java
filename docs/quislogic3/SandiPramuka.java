import java.util.Scanner;

public class SandiPramuka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input kalimat
        String input = scanner.nextLine();

        // Encode kalimat menjadi sandi
        String hasilSandi = encodeToSandi(input);

        // Tampilkan hasil sandi
        System.out.println(hasilSandi);

        scanner.close();
    }

    private static String encodeToSandi(String input) {
        StringBuilder hasilSandi = new StringBuilder();

        int length = input.length();
        int i = 0;
        char prevChar = '\0';

        while (i < length) {
            char currentChar = input.charAt(i);
            int sandiNumber = getSandiNumber(currentChar);
            int count = getCount(currentChar, prevChar);

            // Menambahkan sandi ke dalam StringBuilder
            for (int j = 0; j < count; j++) {
                hasilSandi.append(sandiNumber);
            }

            // Menambahkan tanda minus (-) jika angka pada karakter sekarang sama dengan angka pada karakter selanjutnya
            if (count > 0 && i + 1 < length && getAngka(currentChar) == getAngka(input.charAt(i + 1))) {
                hasilSandi.append('-');
            }

            prevChar = currentChar;
            i++;
        }

        return hasilSandi.toString();
    }

    private static int getSandiNumber(char c) {
        switch (c) {
            case 'A': return 1;
            case 'B': return 11;
            case 'C': return 111;
            case 'D': return 1111;
            case 'E': return 2;
            case 'F': return 22;
            case 'G': return 222;
            case 'H': return 2222;
            case 'I': return 3;
            case 'J': return 33;
            case 'K': return 333;
            case 'L': return 3333;
            case 'M': return 4;
            case 'N': return 44;
            case 'O': return 444;
            case 'P': return 4444;
            case 'Q': return 5;
            case 'R': return 55;
            case 'S': return 555;
            case 'T': return 5555;
            case 'U': return 6;
            case 'V': return 66;
            case 'W': return 666;
            case 'X': return 6666;
            case 'Y': return 7;
            case 'Z': return 77;
            default: return 0; // Spasi
        }
    }

    private static int getCount(char currentChar, char prevChar) {
        if (currentChar == ' ') {
            return 1; // Spasi
        } else if (currentChar == prevChar) {
            return 0; // Karakter sama, tidak perlu ditambahkan
        } else {
            return 1; // Karakter berbeda, tambahkan
        }
    }

    private static int getAngka(char c) {
        return getSandiNumber(c) % 10; // Mengambil angka pada karakter
    }
}
