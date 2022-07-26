package estructurasDinamicas;

import java.util.HashSet;
import java.util.Set;

public class Ejemplo3 {

    public static void main(String[] args) {
        Set<String> paises = new HashSet<>();
        paises.add("Uruguay");
        paises.add("Argentina");
        paises.add("Colombia");
        paises.add("México");
        paises.add("Chile");
        paises.add("Venezuela");
        System.out.println(paises); //No se imprimen en el orden agergado.
        paises.add("Uruguay"); //No admite repetido, no lo agrega.
        System.out.println(paises);
    }

}
