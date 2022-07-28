package org.fdiaz.clase;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo4 {
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1,"Patricia");
        hashMap.put(2,"Facundo");
        hashMap.put(3,"Rocco");
        hashMap.put(4,"Shauna");
        hashMap.put(5,"Kaila");
        hashMap.put(6,"Juanita");
        //contenido
        System.out.println("Contenido"+hashMap);
        //null
        System.out.println(hashMap.get(7));
        //entrySet
        System.out.println("entrySet");
        System.out.println(hashMap.entrySet());
        //recorrido una a una
        for (Map.Entry claveValor : hashMap.entrySet()){
            System.out.println(claveValor.getKey());
            System.out.println(claveValor.getValue());
        }

    }
}
