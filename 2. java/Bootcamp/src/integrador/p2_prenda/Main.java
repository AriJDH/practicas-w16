package integrador.p2_prenda;

import integrador.p2_prenda.model.Prenda;
import integrador.p2_prenda.repository.GuardaRopa;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> listaPrendas = new ArrayList<>(Arrays.asList(
            new Prenda("Levis", "UWU"), new Prenda("Levis", "UWU2")
        ));

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(listaPrendas);
        guardaRopa.mostrarPrendas();
    }
}
