package estructurasDinamicas;

import java.util.*;

public class Ejemplo3 {

    public static void main(String[] args) {

        //No admite repetidos, conjunto, no se puede ordenar
        Set<String> hs = new HashSet<>();
        hs.add("Argentina");
        hs.add("Uruguay");
        hs.add("Colombia");
        hs.add("Chile");
        hs.add("Mexico");
        hs.add("Uruguay");

        //Creo una lista y casteo el set a lista para ordenarlo
        List<String> lista = new ArrayList<>(hs);

        //Ordeno la lista
        Collections.sort(lista);

        System.out.println(lista);
    }
}
