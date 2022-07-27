package estructuras;

import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {
        int num1, num2;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        num1 = teclado.nextInt();
        System.out.println("Introduce un 2do numero: ");
        num2 = teclado.nextInt();

        while (num2 < num1){
            System.out.println("Error: el " + num2 + " es mayor que el " + num1);

            System.out.println("Introduce un 2do numero: ");
            num2 = teclado.nextInt();
        }//hacer esto con do while

        System.out.println("sali del ciclo... fin");
        teclado.close();


    }
}
