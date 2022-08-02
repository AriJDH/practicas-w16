package Arreglos;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        int[] numeros = new int[10];
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numeros.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();
        }

        for(int i = 0;i<5;i++){
            System.out.println(numeros[i]);
            System.out.println(numeros[(9-i)]);
        }

    }



    }
