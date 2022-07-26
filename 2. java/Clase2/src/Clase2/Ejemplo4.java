package Clase2;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo4 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(100,"Juan Perez");
        map.put(101,"Pedro Picapiedra");
        map.put(102,"Roberto Rodriquez");
        map.put(103,"Coco Fernandez");
        map.put(104,"Fernando Fernandez");

        System.out.println("Los elementos son" + map);
        System.out.println("Todas las entradas extraidas con entrySet ");
        System.out.println(map.entrySet());

        for(Map.Entry variable : map.entrySet()){
            System.out.println(variable);
            System.out.println(variable.getKey());
            System.out.println(variable.getValue());
        }

    }
}
