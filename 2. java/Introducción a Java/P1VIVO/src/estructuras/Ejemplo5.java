package estructuras;

import java.util.Scanner;

public class Ejemplo5 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2;

        System.out.println("Ingrese el primer valor: ");
        num1 = Integer.parseInt(entrada.nextLine());

        System.out.println("Ingrese el segundo valor: ");
        num2 = Integer.parseInt(entrada.nextLine());

        while(num2 <= num1){
            System.out.println("ERROR: "+num1 + " es mayor que " + num2);
            System.out.println("Ingrese el segundo valor (que sea mayor que "+num1+"): ");
            num2 = Integer.parseInt(entrada.nextLine());
        }
        entrada.close();

        System.out.println("Salí del ciclo.");
    }

}

class Ejemplo5DoWhile{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2;

        System.out.println("Ingrese el primer valor: ");
        num1 = Integer.parseInt(entrada.nextLine());

        do {
            System.out.println("Ingrese el segundo valor (que sea mayor que "+num1+"): ");
            num2 = Integer.parseInt(entrada.nextLine());
        }while(num1 >= num2);

        entrada.close();

        System.out.println("Salí del ciclo.");
    }
}
