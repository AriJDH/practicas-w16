package estructurasDinamicas;

import java.util.*;

public class Ejemplo3
{
    public static void main(String[] args) {
        Set<String> hs = new HashSet<String>();//el hashset no permite elementos duplicados y no puede ser ordenado por el collections sort
        hs.add("argentina");
        hs.add("chile");
        hs.add("colombia");
        hs.add("mexico");
        hs.add("uruguay");
        System.out.println(hs);

        List<String> lista = new ArrayList<>(hs);
        Collections.sort(lista);
        System.out.println(lista);

    }
}
