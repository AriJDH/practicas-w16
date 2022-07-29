package estructuras;

import java.util.Scanner;

public class Ejemplo1 {
    //static final int incentivo = 10000;

    //Modulo o metodo principal.
    public static void main(String[] args) {
        int numero;

        System.out.println("Ingrese un numero: ");
        Scanner input = new Scanner(System.in);
        numero = input.nextInt();
        input.close();

        if (numero % 2 == 0){
            System.out.println("es PAR");
        } else {
            System.out.println("es IMPAR");
        }

    }
}
