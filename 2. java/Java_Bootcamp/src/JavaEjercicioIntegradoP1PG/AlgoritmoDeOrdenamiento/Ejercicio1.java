package JavaEjercicioIntegradoP1PG.AlgoritmoDeOrdenamiento;

import java.util.Arrays;

public class Ejercicio1 {

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 9, 8, 5};

        System.out.println("burbuja Ordenada\n" + Arrays.toString(burbuja(array)));
    }

    public static int[] burbuja(int[] array) {
        return Arrays.stream(array).sorted().toArray();
    }
}
