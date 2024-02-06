import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan kata: ");
        String teks = scanner.nextLine();
        String hasil = reverseTeks(teks);

        System.out.println("hasil kata: " + hasil);

        scanner.close();
    }

    public static String reverseTeks(String teks) {
        // Mengonversi teks menjadi array karakter
        char[] karakterArray = teks.toCharArray();

        // Memulai proses pembalikan
        int i = 0;
        int j = karakterArray.length - 1;

        while (i < j) {
            // Menukar karakter pada posisi i dan j
            char temp = karakterArray[i];
            karakterArray[i] = karakterArray[j];
            karakterArray[j] = temp;

            // Pindah ke karakter berikutnya
            i++;
            j--;
        }
        // Mengonversi kembali array karakter menjadi string
        return new String(karakterArray);
    }
}
