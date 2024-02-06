import java.util.Scanner;

public class MenghitungHurufBerlubang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String teks = scanner.nextLine();
        int jumlahLubang = hitungLubang(teks);
        System.out.println(jumlahLubang);

        scanner.close();
    }

    private static int hitungLubang(String teks) {
        int jumlahLubang = 0;

        for (char karakter : teks.toCharArray()) {
            switch (karakter) {
                case 'A':
                case 'D':
                case 'O':
                case 'P':
                case 'R':
                case 'Q':
                    jumlahLubang += 1;
                    break;
                case 'B':
                    jumlahLubang += 2;
                    break;
            }
        }

        return jumlahLubang;
    }
}
