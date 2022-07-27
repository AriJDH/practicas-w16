package estructurasDinamicas;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo4 {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(100, "Juan Perez");
        map.put(102, "Milu Gonzalez");
        map.put(103, "Jose Rodriguez");
        map.put(104, "Maria Lanus");
        map.put(105, "Ariel Castro");
        map.put(106, "Luz Martinez");

        System.out.println("Los elementos del mapa son: " + map);
        System.out.println(map.get(100));

        System.out.println("Todas las entradas extraidas con entrySet: ");
        System.out.println(map.entrySet());

        System.out.println("Todas las entradas extraidas una por una: ");
        for (Map.Entry pareja : map.entrySet()) {
            System.out.print(pareja.getKey() + "\t");
            System.out.println(pareja.getValue());
        }

    }
}
