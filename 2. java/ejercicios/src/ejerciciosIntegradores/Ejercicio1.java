package ejerciciosIntegradores;

import java.util.Arrays;

public class Ejercicio1 {

    public static int[] burbuja(int[] array) {
        for(int i=0; i < array.length -2; i++){
            for(int j=0; j< array.length -i -1; j++){
                if(array[j] > array[j+1]){
                    int aux = array[j];
                    array[j]= array[j+1];
                    array[j+1]= aux;
                }
            }
        }
        return array;
    }

    public static void imprimir(int[] arr){
        System.out.print("[");
        for (int i: arr){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0]= 2;
        arr[1]= 40;
        arr[2]= 5;
        arr[3]= 3;
        arr[4]= 26;

        System.out.println(" Arreglo original ");
        Ejercicio1.imprimir(arr);
        Ejercicio1.burbuja(arr);
        System.out.println(" Arreglo ordenado ");
        Ejercicio1.imprimir(arr);

    }

}
