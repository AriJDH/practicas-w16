package Arreglos;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int ultimoNumero;
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numeros.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();
        }

        ultimoNumero = numeros[9];

        for (int i = 8; i >=0;i--){
            numeros[i+1] = numeros[i];
        }

        numeros[0] = ultimoNumero;

        for (int nm: numeros) {
            System.out.print(nm + "-");
        }
    }
}
