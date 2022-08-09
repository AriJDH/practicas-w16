package estructDinamicas;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo4 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(100, "Juan Perez");
        map.put(101, "Martin Marquez");
        map.put(102, "Ariel Jaime");
        map.put(103, "Marco Avila");
        map.put(104, "Carlos Arroyo");

        System.out.println("los elementos del dicc son: \n" + map);

        System.out.println("Todas las entradas Extraidas son: ");
        System.out.println(map.entrySet());
        System.out.println("Todas las entradas Extraidas una a una son: \n");

        System.out.println("codigo\tNombre\n-----\t-------");
        for (Map.Entry pareja : map.entrySet()) {
            System.out.print(pareja.getKey() + "\t\t" + pareja.getValue());
            System.out.println();
        }
    }
}
