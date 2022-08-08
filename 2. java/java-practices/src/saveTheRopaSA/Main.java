package saveTheRopaSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Ejercicio > Modulo 5: Java > EjerciciosIntegradores-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        Prenda pantalon = new Prenda("Tascani", "Jean");
        Prenda remera = new Prenda("CaraCruz", "Manga corta");

        List<Prenda> prendas = new ArrayList();
        prendas.add(pantalon);
        prendas.add(remera);

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer identificador = guardaRopa.guardarPrendas(prendas);

        List<Prenda> misPrendas1 = guardaRopa.devolverPrendas(identificador);
        System.out.println("IDENTIFICADOR 1: " + identificador);
        misPrendas1.stream().forEach(System.out::println);

        Prenda pantalon2 = new Prenda("Nike", "Airforce");
        Prenda remera2 = new Prenda("Nike", "Jordan");
        Integer identificador2 = guardaRopa.guardarPrendas(Arrays.asList(pantalon2, remera2));
        List<Prenda> misPrendas2 = guardaRopa.devolverPrendas(identificador2);

        //System.out.println("IDENTIFICADOR 2: " + identificador2);
        misPrendas2.stream().forEach(System.out::println);

        misPrendas2.removeIf(prenda -> prenda.getMarca().equals("Tascani"));
        misPrendas2.stream().forEach(System.out::println);
    }
}
