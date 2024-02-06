public class App {
    public static void main(String[] args) {
        int i = 10;
        int sum = 0;

        while (i <= 20) {
            sum = sum + i;
            i = i - 1;
        }

        System.out.println("Di akhir algoritma, nilai i adalah " + i + ", dan sum adalah " + sum + ".");
    }
}
