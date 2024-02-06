import java.util.Scanner;

public class MaksimalTigaBilangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bilangan1 = scanner.nextInt();
        int bilangan2 = scanner.nextInt();
        int bilangan3 = scanner.nextInt();

        int maksimal = cariBilanganMaksimal(bilangan1, bilangan2, bilangan3);

        System.out.println(maksimal);

        scanner.close();
    }

    private static int cariBilanganMaksimal(int a, int b, int c) {
        int maksimal = a;

        if (b > maksimal) {
            maksimal = b;
        }

        if (c > maksimal) {
            maksimal = c;
        }

        return maksimal;
    }
}
