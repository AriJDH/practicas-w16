package EjercicioOne;

import java.util.Arrays;
import java.util.List;

public class Ejercicio {


    public static int[] burbuja(int[] array) {
        int[] result= new int[array.length];
        int[] arr=array;



        Arrays.sort(array);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }

        return array;
    }
    public static void main(String[] args) {
        int [] numeros = {3, 5, 1, 2, 1, 7, 0,};
        int []pedro;
        int[] resultant =burbuja(numeros);

        //imprimiendo fuera de la funcion

        System.out.println(Arrays.stream(numeros).toArray());
        for(int i=0;i<resultant.length;i++){
            System.out.print(resultant[i]);
            System.out.print(" ");

        }
    }


}
