package estructuras;

import java.util.Scanner;

public class Ejemplo3 {
    public static void main(String[] args) {

        int num1, num2;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese numero 1");
        num1=Integer.parseInt(entrada.nextLine());
        System.out.println("Ingrese numero 2");
        num2=Integer.parseInt(entrada.nextLine());
        entrada.close();

        //terminar
        while(num1<=num2){
            System.out.println();
        }

    }
}
