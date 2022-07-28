package estructurasDinamicas;

import java.util.HashMap;
import java.util.Map;

public class Ejemplo4
{
    public static void main(String[] args)
    {
        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "ruben");
        map.put(2, "mario");
        map.put(3, "silvi");
        map.put(4, "richard");
        map.put(5, "ari");

        System.out.println("los elementos del map: " + map);
        System.out.println(map.get(1));
        System.out.println("todas las entradas extrai(das con entryset: ");
        System.out.println(map.entrySet());
        System.out.println("todas las entradas extraidas una a una: ");
        for(Map.Entry pareja : map.entrySet())
        {
            System.out.println(pareja.getKey() + " - " + pareja.getValue());
        }

        System.out.println("codigo\tNombre\n---------\t--------");
        for(Map.Entry pareja : map.entrySet())
        {
            System.out.println(pareja.getKey() + " - " + pareja.getValue());
        }
    }
}
