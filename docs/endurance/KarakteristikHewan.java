import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KarakteristikHewan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double N = scanner.nextDouble();
        scanner.nextLine();  

        String ciriHewanA = scanner.nextLine();
        String ciriHewanB = scanner.nextLine();

        double persentaseKesamaan = hitungPersentaseKesamaan(ciriHewanA, ciriHewanB);

        if (persentaseKesamaan >= N) {
            System.out.println("sama");
        } else {
            System.out.println("tidak sama");
        }

        scanner.close();
    }

    public static double hitungPersentaseKesamaan(String ciriHewanA, String ciriHewanB) {
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();

        for (char c : ciriHewanA.toCharArray()) {
            setA.add(c);
        }

        for (char c : ciriHewanB.toCharArray()) {
            setB.add(c);
        }

        Set<Character> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);

        return ((double) intersection.size() / Math.max(setA.size(), setB.size())) * 100;
    }
}
