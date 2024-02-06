import java.util.Scanner;

public class Soal1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan kata: ");
        String teks = scanner.nextLine();
        String hasil = reverseTeks(teks);

        System.out.println("hasil kata: " + hasil);

        scanner.close();
    }

    public static String reverseTeks(String teks) {
        char[] karakterArray = teks.toCharArray();

        int i = 0;
        int j = karakterArray.length - 1;

        while (i < j) {
            char temp = karakterArray[i];
            karakterArray[i] = karakterArray[j];
            karakterArray[j] = temp;

            i++;
            j--;
        }
        return new String(karakterArray);
    }
}
