import java.util.Scanner;
public class a {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexAtoZ = "[a-zA-Z]+";
        String regexNumber = "[0-9]+";

        String stringinputAngka;
        String stringinputHuruf;
        int inputAngka;
        do {
            System.out.print("masukan input Huruf : ");
            stringinputHuruf = scanner.nextLine();
            if (!stringinputHuruf.matches(regexAtoZ)) {
                System.out.println("masukan huruf : " + stringinputHuruf.matches(regexAtoZ));
                System.out.println("coba input ulang");
            }
        } while (!stringinputHuruf.matches(regexAtoZ));

        do {
            System.out.print("masukan input nomor : ");
            stringinputAngka = scanner.nextLine();
            if (!stringinputAngka.matches(regexNumber)) {
                System.out.println("masukan huruf : " + stringinputAngka.matches(regexNumber));
                System.out.println("coba input ulang");
            }
        } while (!stringinputAngka.matches(regexNumber));
        inputAngka = Integer.valueOf(stringinputAngka);
    }
}
