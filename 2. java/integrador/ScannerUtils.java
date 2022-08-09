package integrador;

import java.util.Scanner;

public class ScannerUtils {
    static public Scanner input  = new Scanner(System.in);
    static public String getStringFromScanner(String message) {
        System.out.println(message);
        String value = input.nextLine();
        return value;
    }
    static public int getIntFromScanner(String message) {
        System.out.println(message);
        int value = input.nextInt();
        input.nextLine();
        return value;
    }
    static public double getDoubleFromScanner(String message) {
        System.out.println(message);
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }

}
