import java.util.HashMap;
import java.util.Map;

public class Ejemplo4 {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<>();

        //admite clave valor
        mapa.put(1, "a");
        mapa.put(2, "b");
        mapa.put(3, "c");
        mapa.put(4, "d");
        mapa.put(5, "e");
        System.out.println(mapa);
        System.out.println(mapa.get(3));
        System.out.println(mapa.remove("d")); //no lo encuentra me devuelve null
        System.out.println(mapa.remove(1)); //me devuelve lo que elimine
        System.out.println(mapa);

        System.out.println(mapa.entrySet());
        /* pasa de {2=b, 3=c, 4=d, 5=e}
                a   [2=b, 3=c, 4=d, 5=e]
        */

        //Para recorrerlo podemos usar un foreach

        for(Map.Entry<Integer,String> mapas: mapa.entrySet()) {
            System.out.println("Recorrido de mapas: " + mapas);
        }

        //Utilizo metodos get.key y get.value

        System.out.println("Para extraer por clave/valor");
        System.out.println("Código\tLetra del Abecedario\n--------\t--------");
        for(Map.Entry mapas: mapa.entrySet()) {
            System.out.print(mapas.getKey() + "\t" + "\t" + "\t"+ "\t");
            System.out.println(mapas.getValue());

        }


    }
}
