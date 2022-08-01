package ejercicioGuia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Guia {
    public static void main(String[] args) {
        int lista[] = new int [4];
        lista[0] = 5;
        lista[1] = 1;
        lista[2] = 3;
        lista[3] = 4;

        burbuja(lista);
    }
    public static int[] burbuja(int[] array) {
        List<Integer> ordenados = new ArrayList<Integer>();
        for (int e: array){
            ordenados.add(e);
        }
        ordenados.stream().sorted();
        System.out.println(ordenados);
        return array;
    }
}
