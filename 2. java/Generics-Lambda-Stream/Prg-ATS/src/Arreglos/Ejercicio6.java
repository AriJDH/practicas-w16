package Arreglos;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {

        int[] numerosA = new int[12];
        int[] numerosB= new int[12];
        int[] numerosC= new int[24];

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numerosA.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " deL arreglo A:");
            numerosA[i] = teclado.nextInt();

            System.out.print( "Digita el numero #" +(i+1) + " deL arreglo B:");
            numerosB[i] = teclado.nextInt();

        }

        int contadorC =0,contadorA=0,contadorB=0;

        //Llenado de información


        for (int i = 0; i<4;i++){
            numerosC[contadorC] = numerosA[contadorA];
            contadorC++;
            contadorA++;
            numerosC[contadorC] = numerosA[contadorA];
            contadorC++;
            contadorA++;
            numerosC[contadorC] = numerosA[contadorA];
            contadorC++;
            contadorA++;

            numerosC[contadorC] = numerosB[contadorB];
            contadorC++;
            contadorB++;
            numerosC[contadorC] = numerosB[contadorB];
            contadorC++;
            contadorB++;
            numerosC[contadorC] = numerosB[contadorB];
            contadorC++;
            contadorB++;

        }
        for (int numero:numerosC) {
            System.out.println(numero);
        }



    }



    }
