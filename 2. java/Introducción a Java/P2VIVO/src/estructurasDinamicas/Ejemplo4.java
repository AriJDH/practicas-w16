package estructurasDinamicas;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo4 {

    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<Integer, String>();
        mapa.put(100, "Juan Perez");
        mapa.put(101, "Jorge Díaz");
        mapa.put(102, "Martin Sanchéz");
        mapa.put(103, "Gabriel Rojas");
        mapa.put(104, "Carlos Osorio");
        mapa.put(105, "Manuel Torres");

        System.out.println("Los elementos del diccionario 'mapa' son: " + mapa);

        System.out.println(mapa.get(100)); // Devuelve 'Juan Perez'
        System.out.println(mapa.get(300)); // Devuelve 'null' porque no existe.

        System.out.println();
        System.out.println("Todas las entradas extraidas con entrySet: ");
        System.out.println(mapa.entrySet());

        System.out.println();
        System.out.println("Todas las entradas extraidas una a una: ");
        for (Map.Entry item: mapa.entrySet()){
            System.out.println(item);
            System.out.println("Key: "+ item.getKey() + " Value: " + item.getValue());
        }
    }

}
