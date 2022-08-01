package EjerciciosIntegradoresP2.SaveTheRopa.executable;

import java.util.ArrayList;
import java.util.List;

import EjerciciosIntegradoresP2.SaveTheRopa.actors.*;


public class Main {
    
    public static void main(String[] args) {
        GuardarPrenda guardarPrenda = new GuardarPrenda();
        List<Prenda> prendas = new ArrayList<Prenda>();

        prendas.add(new Prenda("Zara", "Zara"));
        prendas.add(new Prenda("Nike", "Nike"));

        Integer idPrendas = guardarPrenda.guardarPrenda(prendas);

        List<Prenda> prendasGuardadas = guardarPrenda.devolverPrendas(idPrendas);

        prendasGuardadas.forEach(System.out::println);
        System.out.println("\nMostrando todas las prendas: \n");
        guardarPrenda.mostrarPrendas();

    }
}
