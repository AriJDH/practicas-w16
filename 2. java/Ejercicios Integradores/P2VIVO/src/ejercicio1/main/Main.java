package ejercicio1.main;

import ejercicio1.clases.GuardaRopa;
import ejercicio1.clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda p1 = new Prenda("Nike", "Campera invierno");
        Prenda p2 = new Prenda("Adidas", "Remera deportiva");

        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(p1);

        int clave = guardaRopa.guardarPrendas(listaPrendas);
        System.out.println(clave);

        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(clave);
        guardaRopa.mostrarPrendas();
    }
}
