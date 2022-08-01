package EjerciciosIntegradores_Java.Algoritmos_de_ordenamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio1 {

    public static int[] burbuja(int[] array){

        List<Integer> lista = IntStream.of(array).boxed().collect(Collectors.toList());

        List<Integer> lista2 = lista.stream()
                .sorted(Integer::compareTo).collect(Collectors.toList());

        int arrayResul[] = new int[lista2.size()];

        for(int i = 0; i < arrayResul.length; i++){
            arrayResul[i] = lista2.get(i);
        }

        return arrayResul;
    }

    public static void main(String[] args) {
        int array[] = burbuja(new int[]{1, 2, 3, 4, 6, -60, -20, -9, -8, 2, 3, 5, 6, 7, 8, 9, 10, 70, 100});

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

}
