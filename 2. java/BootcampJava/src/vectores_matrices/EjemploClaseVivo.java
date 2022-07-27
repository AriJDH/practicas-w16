package vectores_matrices;
import java.util.Scanner;

public class EjemploClaseVivo {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int num1, num2;

        System.out.println("Ingrese el primer valor: ");
        num1 = Integer.parseInt(teclado.nextLine());

        /*
        System.out.println("Ingrese el segundo valor: ");
        num2 = Integer.parseInt(teclado.nextLine());

        while(num2 <= num1){
            System.out.println("ERROR: el " +num1 + " es mayor que " + num2);
            System.out.println("Ingrese el segundo valor");
            num2 = Integer.parseInt(teclado.nextLine());
        }

        teclado.close();

        System.out.println("Salí del ciclo.");
        */

        do {
            System.out.println("Ingrese el segundo valor: ");
            num2 = Integer.parseInt(teclado.nextLine());
        }while(num1 >= num2);

        System.out.println("Sali del ciclo...fin");
        }
    }




