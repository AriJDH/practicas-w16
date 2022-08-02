package practicesSaveTheRopa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, List<Prenda>> map = new HashMap<>();
        GuardaRopa guardaRopa = new GuardaRopa(0, map);

        Prenda prenda1 = new Prenda("marca1", "m345");
        Prenda prenda2 = new Prenda("marca2", "le43");
        Prenda prenda3 = new Prenda("marca3", "g433");
        List<Prenda> listPrendas = new ArrayList<>(Arrays.asList(prenda1, prenda2, prenda3));

        int codigo = guardaRopa.guardarPrendas(listPrendas);
        System.out.println("El codigo de las prendas es: " + codigo);

        List<Prenda> result = guardaRopa.devolverPrendas(codigo);
        result.forEach(System.out::println);



    }
}
