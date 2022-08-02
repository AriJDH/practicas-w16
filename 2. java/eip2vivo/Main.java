package eip2vivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa1 = new GuardaRopa();

        Prenda prenda1 = new Prenda("Maui and sons", "t-shirt");
        Prenda prenda2 = new Prenda("Adidas", "Camisa");
        Prenda prenda3 = new Prenda("Mars", "Pantalon");
        Prenda prenda4 = new Prenda("Maui and sons", "Short");


        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);


        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(prenda3);
        prendas2.add(prenda4);

        Integer idPrendaGuardada = guardaRopa1.guardarPrendas(prendas);
        Integer idPrendaGuardada2 = guardaRopa1.guardarPrendas(prendas2);

        System.out.println(idPrendaGuardada);
        System.out.println(idPrendaGuardada2);

        guardaRopa1.mostrarPrendas();

        System.out.println("Devuelvo las prendas id 0");
        guardaRopa1.devolverPrendas(idPrendaGuardada);

        System.out.println("Prendas actuales");
        guardaRopa1.mostrarPrendas();
    }
}
