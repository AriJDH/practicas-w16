package estructuras;

import java.util.Scanner;

public class Ejemplo3 {
    public static void main(String[] args) {
        int num1, num2, num3;
        System.out.println("Ingrese un número: ");
        Scanner entrada = new Scanner(System.in); //Instanciar la clase Scanner.
        num1 = entrada.nextInt();

        System.out.println("Ingrese un 2do número: ");
        num2 = entrada.nextInt();

        System.out.println("Ingrese un 3er número: ");
        num3 = entrada.nextInt();

        entrada.close(); //Siempre cerrar el Scanner, para que no consuma recursos.

        if (num1>num2 && num1>num3){
            System.out.println(num1 + " es MAYOR.");
        }else if (num2>num3){
            System.out.println(num2 + " es MAYOR.");
        }else{
            System.out.println(num3 + " es MAYOR.");
        }
    }
}
