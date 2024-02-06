import java.util.Scanner;

public class YudisiumMahasiswa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[] nilaiMataKuliah = new char[n];
        for (int i = 0; i < n; i++) {
            nilaiMataKuliah[i] = scanner.next().charAt(0);
        }

        String yudisium = tentukanYudisium(nilaiMataKuliah);
        System.out.println(yudisium);

        scanner.close();
    }

    public static String tentukanYudisium(char[] nilaiMataKuliah) {
        int totalNilai = 0;
        int jumlahMataKuliah = nilaiMataKuliah.length;

        for (char nilai : nilaiMataKuliah) {
            switch (nilai) {
                case 'A':
                    totalNilai += 4;
                    break;
                case 'B':
                    totalNilai += 3;
                    break;
                case 'C':
                    totalNilai += 2;
                    break;
                case 'D':
                    totalNilai += 1;
                    break;
            }
        }

        double ipk = (double) totalNilai / jumlahMataKuliah;

        if (ipk < 2 || containsE(nilaiMataKuliah)) {
            return "Pending";
        } else if (ipk >= 3.5) {
            return "Cum Laude";
        } else if (ipk >= 2.75) {
            return "Sangat Memuaskan";
        } else {
            return "Memuaskan";
        }
    }

    private static boolean containsE(char[] nilaiMataKuliah) {
        for (char nilai : nilaiMataKuliah) {
            if (nilai == 'E') {
                return true;
            }
        }
        return false;
    }
}
