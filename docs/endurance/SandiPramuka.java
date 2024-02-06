import java.util.Scanner;

public class SandiPramuka {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca kalimat yang akan dienkripsi
        String input = scanner.nextLine();

        // Mengubah kalimat menjadi sandi
        int[] sandi = encodeToSandi(input);

        // Menghasilkan string sandi
        String sandiString = generateSandiString(sandi);

        // Menampilkan hasil
        System.out.println(sandiString);

        scanner.close();
    }

    private static int[] encodeToSandi(String input) {
        int[] sandi = new int[input.length() * 2]; // Estimasi panjang maksimal

        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ' ') {
                sandi[index++] = 0;
            } else {
                sandi[index++] = getSandiNumber(currentChar);

                int count = getCount(currentChar);
                if (count > 1) {
                    sandi[index++] = count;
                }
            }

            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                sandi[index++] = '-';
            }
        }

        return trimArray(sandi, index);
    }

    private static int[] trimArray(int[] array, int length) {
        int[] result = new int[length];
        System.arraycopy(array, 0, result, 0, length);
        return result;
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
            default: return 0; // Character is a space
        }
    }

    private static int getCount(char c) {
        switch (c) {
            case 'A': case 'B': case 'C': case 'D':
            case 'E': case 'F': case 'G': case 'H':
            case 'I': case 'J': case 'K': case 'L':
            case 'M': case 'N': case 'O': case 'P':
            case 'Q': case 'R': case 'S': case 'T':
            case 'U': case 'V': case 'W': case 'X':
            case 'Y': case 'Z':
                return 1;
            default:
                return Character.getNumericValue(c);
        }
    }

    private static String generateSandiString(int[] sandi) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sandi.length; i++) {
            result.append(sandi[i]);

            
            
        }

        return result.toString();
    }

}
