package Arreglos;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {

        boolean asc=true,desc=true,noOrdem = false;

        int[] numeros = new int[10];
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numeros.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();
        }

        for (int i = 0; i<7; i++){
            if(!(numeros[i] < numeros[i+1] && numeros[i+1] < numeros[i+2] )) { //Creciente
                asc = false;
            }
            if(!(numeros[i] > numeros[i+1] && numeros[i+1] > numeros[i+2] )) { //Decreciente
                desc = false;
            }
        }

        if(!asc && !desc ){
            noOrdem = true;
        }

        if(asc){
            System.out.println("Es ascendiente");
        }

        if(noOrdem){
            System.out.println("no tiene orden");
        }

        if(desc){
            System.out.println("Es decreciente");
        }





    }



    }
