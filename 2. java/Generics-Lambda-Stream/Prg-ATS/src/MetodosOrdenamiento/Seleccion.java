package MetodosOrdenamiento;

import java.util.Scanner;

public class Seleccion {

    public static void main(String[] args) {

        int[] numeros = new int[10];
        int aux,min;
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numeros.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();
        }

        //Ordenamiento por selección
        for (int i=0;i < numeros.length;i++){
            min = i;
            for (int j=i+1; j < numeros.length;j++){
                if(numeros[j] < numeros[min]){
                    min = j;
                }
            }
            aux=numeros[i];
            numeros[i] = numeros[min];
            numeros[min] = aux;
        }

        for (int num:numeros) {
            System.out.print(num + " - ");
        }

    }
}
