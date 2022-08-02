package MetodosOrdenamiento;

import java.util.Scanner;

public class Burbuja {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int aux;
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i<numeros.length;i++){
            System.out.print( "Digita el numero #" +(i+1) + " :");
            numeros[i] = teclado.nextInt();
        }

        //Metódo burbuja -- Ordenar el arreglo
        for (int i = 0; i < numeros.length-1;i++){
            for (int j =0;j< numeros.length-1;j++){
                if(numeros[j] > numeros[j+1]){
                    aux = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = aux;
                }
            }
        }

//        Mostrando el arreglo ordenado asc
        for (int num:numeros) {
            System.out.print(num + " - ");
        }
    }
}
