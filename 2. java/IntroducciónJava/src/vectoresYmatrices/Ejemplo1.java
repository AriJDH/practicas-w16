package vectoresYmatrices;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
//VECTORES
public class Ejemplo1 {
    public static void main(String[] args) {
        int array[] = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            System.out.println("Estoy en la posición " + i);
            System.out.println("Tengo guardado un " + array[i]);
        }

        //Carga por Teclado

        int numbers[] = new int[3];
        Scanner entry = new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Ingrese un total de 3 dígitos");
            numbers[i] = entry.nextInt();
        }
        System.out.println(Arrays.toString(numbers));
    }
}
