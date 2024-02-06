package logic1;
import java.util.Scanner;

public class WujudBenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suhu = scanner.nextDouble();


        String wujudBenda = "";

        if (suhu >= 0 && suhu <= 100) {
            wujudBenda = "berwujud cair";
        } else {
            wujudBenda = "berwujud non cair";
        }


        System.out.println(wujudBenda);
    }
}
