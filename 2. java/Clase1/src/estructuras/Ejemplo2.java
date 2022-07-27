package estructuras;

import java.util.Scanner;

public class Ejemplo2 {
    public static void main(String[] args) {
        int numero;
        System.out.println("ingrese un numero");
        Scanner entrada= new Scanner(System.in);
        numero=entrada.nextInt();
        entrada.close();
        if (numero%2==0){
            System.out.println("Es par");
        }else {
            System.out.println("Es impar");
        }


    }
}
