package Arreglos;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        int[] numerosA = new int[10];
        int[] numerosB= new int[10];

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numerosA.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " deL arreglo A:");
            numerosA[i] = teclado.nextInt();

            System.out.print( "Digita el numero #" +(i+1) + " deL arreglo B:");
            numerosB[i] = teclado.nextInt();

        }

        for(int i = 0;i<10;i++){
            System.out.println(numerosA[i]);
            System.out.println(numerosB[i]);
        }

    }



    }
