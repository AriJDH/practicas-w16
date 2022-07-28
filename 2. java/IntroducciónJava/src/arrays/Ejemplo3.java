package arrays;

import java.util.Scanner;

public class Ejemplo3 {
    //dados 3 numeros que me indique cuál es el mayor
    public static void main(String[] args) {

        int number1, number2, number3;

        Scanner dataEntry = new Scanner(System.in);

        System.out.println("Ingrese un número: ");
        number1 = dataEntry.nextInt();

        System.out.println("Ingrese un 2do número: ");
        number2 = dataEntry.nextInt();

        System.out.println("Ingrese un 3er número: ");
        number3 = dataEntry.nextInt();

        dataEntry.close();

        if (number1 > number2 && number1 > number3) {
            System.out.println("El número " + number1 + "es el mayor");
        } else {
            if (number2 > number3) {
                System.out.println("El número " + number2 + " es el mayor");
            }
            else{
                System.out.println("El tercer número es el mayor");
            }
        }

    }
}
