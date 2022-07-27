package estructsDinamicas;

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
        System.out.println("Los elementos del diccionario son: " + map);

        //System.out.println(map.get(100));
        //System.out.println(map.get(110));

        System.out.println("Todas las entradas extraidas con entrySet: ");
        System.out.println(map.entrySet());
        System.out.println("Todas las entradas extraídas una a una: ");
        for(Map.Entry pareja : map.entrySet()){
            System.out.println(pareja);
        }

        ///////
        System.out.println("Código\tNombre\n-------\t--------");
        for(Map.Entry pareja : map.entrySet()){
            System.out.print(pareja.getKey() + "   \t");
            System.out.println(pareja.getValue());
        }
    }
}
