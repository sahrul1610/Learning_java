import java.util.Scanner;

public class BahasaPanda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        int[] sandi = encodeToSandi(input);

        System.out.println(generateSandiString(sandi));

        scanner.close();
    }

    private static int getSandiNumber(char c) {
        if (c == ' ') {
            return -1; // Spasi diwakili oleh -1
        }
        return Character.toUpperCase(c) - 'A' + 1;
    }

    private static int[] encodeToSandi(String input) {
        int[] sandi = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            sandi[i] = getSandiNumber(input.charAt(i));
        }

        return sandi;
    }

    private static String generateSandiString(int[] sandi) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sandi.length; i++) {
            if (sandi[i] != -1) {
                result.append(sandi[i]);
                if (i < sandi.length - 1 && sandi[i + 1] != -1) {
                    result.append(".");
                }
            } else {
                result.append("-");
            }
        }

        return result.toString();
    }
}
