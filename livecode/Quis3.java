import java.util.Scanner;

public class Quis3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int totalLubang = countLubang(input);
        System.out.println(totalLubang);
        scanner.close();
    }

    private static int countLubang(String str) {
        int totalLubang = 0;

        // for (char ch : str.toCharArray()) {
        //     switch (ch) {
        //         case "A":
        //         case "D":
        //         case "O":
        //         case "P":
        //         case "R":
        //         case "Q":
        //             totalLubang += 1;
        //             break;
        //         case "B":
        //             totalLubang += 2;
        //             break;
        //         default:
        //     }
        // }
        //menghitung lubang
        for (char ch : str.toCharArray()){
            if (ch == 'A' || ch == 'D'|| ch == 'O'|| ch == 'P'|| ch == 'R'|| ch == 'Q') {
                totalLubang +=1;
            }else if(ch == 'B'){
                totalLubang +=2;
            }
        }
        return totalLubang;
    }
}