package Arreglos;

import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {
        int[] numeros = new int[10];
        int numero,posicion;

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numeros.length-2;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();
        }

        System.out.print("Digite un numero : ");
        numero = teclado.nextInt();
        System.out.print("Digite una posición entre 0 y 8: ");
        posicion = teclado.nextInt();

        for(int i = 8; i>posicion;i--){
            int copiaNumero = numeros[i-1];
            numeros[i] = copiaNumero;
        }

        numeros[posicion] = numero;
        for (int nm: numeros) {
            System.out.print(nm + "-");
        }
    }
}
