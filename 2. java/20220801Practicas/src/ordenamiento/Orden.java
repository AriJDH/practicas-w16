package ordenamiento;

import java.util.*;
import java.util.stream.Stream;

public class Orden {
    public static void main(String[] args) {
        int lista[] =  new int[5];
        lista[0] = 5;
        lista[1] = 7;
        lista[2] = 1;
        lista[3] = 10;
        lista[4] = 3;

        //System.out.println(burbuja(lista));
        burbuja(lista);

        for(int i = 0; i < lista.length ; i++){
            //array[i] = ordenado.get(i);
            System.out.println(lista[i]);
        }
    }
    public static int[] burbuja(int[] array) {
        List<Integer> ordenado = new ArrayList<Integer>();
        Arrays.asList(array);
        Collections.sort(ordenado);
        for(int i = 0; i < array.length ; i++){
            array[i] = ordenado.get(i);
            //System.out.println(array[i]);
        }
        return array;
    }
}
