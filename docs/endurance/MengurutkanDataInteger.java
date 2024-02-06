import java.util.Scanner;

public class MengurutkanDataInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int data1 = scanner.nextInt();
        int data2 = scanner.nextInt();
        int data3 = scanner.nextInt();

        int[] dataTerurut = urutDescending(data1, data2, data3);

        for (int data : dataTerurut) {
            System.out.print(data + " ");
        }

        scanner.close();
    }

    private static int[] urutDescending(int data1, int data2, int data3) {
        int[] dataTerurut = new int[3];

        if (data1 >= data2 && data1 >= data3) {
            dataTerurut[0] = data1;
            dataTerurut[1] = Math.max(data2, data3);
            dataTerurut[2] = Math.min(data2, data3);
        } else if (data2 >= data1 && data2 >= data3) {
            dataTerurut[0] = data2;
            dataTerurut[1] = Math.max(data1, data3);
            dataTerurut[2] = Math.min(data1, data3);
        } else {
            dataTerurut[0] = data3;
            dataTerurut[1] = Math.max(data1, data2);
            dataTerurut[2] = Math.min(data1, data2);
        }

        return dataTerurut;
    }
}
