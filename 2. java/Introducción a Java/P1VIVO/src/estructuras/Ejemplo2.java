package estructuras;

import java.util.Scanner;

public class Ejemplo2 {
    public static void main(String[] args) {
        int numero;
        System.out.println("Ingrese un número: ");
        Scanner entrada = new Scanner(System.in); //Instanciar la clase Scanner.
        numero = entrada.nextInt();
        entrada.close(); //Siempre cerrar el Scanner, para que no consuma recursos.

        if ((numero % 2) == 0){
            System.out.println(numero + " es PAR.");
        }else{
            System.out.println(numero + " es IMPAR.");
        }
    }
}

