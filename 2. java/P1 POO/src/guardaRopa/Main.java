package guardaRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Prenda uno = new Prenda("nike","pantalon");
        Prenda dos = new Prenda("nike" , "pantalon2");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(uno);
        prendas.add(dos);


        GuardaRopa guardaRopa = new GuardaRopa();
        int id = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(id).stream().forEach(System.out::println);




    }
}
