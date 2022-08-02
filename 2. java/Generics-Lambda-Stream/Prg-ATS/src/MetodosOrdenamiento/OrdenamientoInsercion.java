package MetodosOrdenamiento;

import java.util.Scanner;

public class OrdenamientoInsercion {

    public static void main(String[] args) {

        int[] numeros = new int[10];
        int pos,aux;
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numeros.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();
        }

        //Ordenamiento por Insercion
        for (int i = 0; i <numeros.length;i++){
            pos = i;
            aux = numeros[i];

            while ((pos>0) && (numeros[pos-1]>aux  ) ){
                numeros[pos] = numeros[pos-1];
                pos--;
            }
            numeros[pos] = aux;
        }

        System.out.println("Monstrando ");

        for (int num:numeros) {
            System.out.print(num + " - ");
        }


    }
}
