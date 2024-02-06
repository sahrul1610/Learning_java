import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KarakteristikHewan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca nilai N (batas minimal persentase kesamaan)
        double batasPersentase = Double.parseDouble(scanner.nextLine());

        // Membaca ciri-ciri hewan A
        String ciriHewanA = scanner.nextLine();

        // Membaca ciri-ciri hewan B
        String ciriHewanB = scanner.nextLine();

        // Menghitung persentase kesamaan
        double persentaseKesamaan = hitungPersentaseKesamaan(ciriHewanA, ciriHewanB);

        // Menentukan apakah hewan A dan B sama atau tidak
        String hasilPerbandingan = (persentaseKesamaan >= batasPersentase) ? "sama" : "tidak sama";

        // Menampilkan hasil
        System.out.println(hasilPerbandingan);

        scanner.close();
    }

    public static double hitungPersentaseKesamaan(String ciriHewanA, String ciriHewanB) {
        // Mengubah string ciri hewan menjadi set karakter untuk menghindari duplikat
        Set<Character> setHewanA = new HashSet<>();
        Set<Character> setHewanB = new HashSet<>();

        for (char c : ciriHewanA.toCharArray()) {
            setHewanA.add(c);
        }

        for (char c : ciriHewanB.toCharArray()) {
            setHewanB.add(c);
        }


        Set<Character> intersection = new HashSet<>(setHewanA);
        intersection.retainAll(setHewanB);
        // System.out.println(intersection);

        //return ((double) intersection.size() / Math.max(setHewanA.size(), setHewanB.size())) * 100;
        double persentaseKesamaan = (double) intersection.size() / Math.max(setHewanA.size(), setHewanB.size()) * 100;
        // System.out.println(persentaseKesamaan);
        return persentaseKesamaan;
    }
}
