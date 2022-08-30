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
        GuardaRopa guardaRopa = new GuardaRopa();

        // Guardado y recupero 1
        Prenda pantalon = new Prenda("Tascani", "Jean");
        Prenda remera1 = new Prenda("CaraCruz", "Manga corta");
        Integer numero1 = guardaRopa.guardarPrendas(Arrays.asList(pantalon, remera1));

        List<Prenda> listaDePrendas1 = guardaRopa.devolverPrendas(numero1);
        System.out.println("NUMERO " + numero1 + ": ");
        listaDePrendas1.stream().forEach(System.out::println);

        // Guardado y recupero 2
        Prenda zapatillas = new Prenda("Nike", "Air Force");
        Prenda remera2 = new Prenda("Nike", "Manga larga");
        Integer numero2 = guardaRopa.guardarPrendas(Arrays.asList(zapatillas, remera2));

        List<Prenda> listaDePrendas2 = guardaRopa.devolverPrendas(numero2);
        System.out.println("NUMERO " + numero2 + ": ");
        listaDePrendas2.stream().forEach(System.out::println);

        System.out.println();

        // Muestreo de todas las prendas
        System.out.println("> MUESTREO DE TODAS LAS PRENDAS:");
        guardaRopa.mostrarPrendas();
    }
}
