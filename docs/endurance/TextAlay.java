import java.util.Scanner;

public class TextAlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String kalimat = scanner.nextLine();
        String kalimatAlay = ubahKeAlay(kalimat);
        System.out.println(kalimatAlay);

        scanner.close();
    }

    public static String ubahKeAlay(String kalimat) {
        StringBuilder hasil = new StringBuilder();

        for (int i = 0; i < kalimat.length(); i++) {
            char karakter = kalimat.charAt(i);
            switch (karakter) {
                case 'A':
                case 'a':
                    hasil.append('4');
                    break;
                case 'I':
                case 'i':
                    hasil.append('1');
                    break;
                case 'Z':
                case 'z':
                    hasil.append('2');
                    break;
                case 'E':
                case 'e':
                    hasil.append('3');
                    break;
                case 'G':
                case 'g':
                    hasil.append('6');
                    break;
                case 'J':
                case 'j':
                    hasil.append('7');
                    break;
                case 'B':
                case 'b':
                    hasil.append('8');
                    break;
                default:
                    hasil.append(karakter);
            }
        }

        return hasil.toString();
    }
}
