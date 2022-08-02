package Arreglos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[5];

        int contadorNumerosPositivos=0,
                contadorNumerosNegativos =0,
                contadorCeros = 0;
        int totalNumPositivos = 0,totalNumNegativos = 0;

        for (int i = 0; i<numeros.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();

            if (numeros[i] == 0){
                ++contadorCeros;
            }
            else if(numeros[i] > 0 ){
                ++contadorNumerosPositivos;
                totalNumPositivos += numeros[i];
            }else{
                ++contadorNumerosNegativos;
                totalNumNegativos += numeros[i];
            }
        }

        System.out.println("Numeros Positivos = " + (totalNumPositivos/contadorNumerosPositivos));
        System.out.println("Numeros Negativos = " + (totalNumNegativos/contadorNumerosNegativos));
        System.out.println("contadorCeros = " + contadorCeros);

    }

}
