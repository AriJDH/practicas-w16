package main;

import ropa.GuardaRopa;
import ropa.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> lista = new ArrayList<>(2);
        lista.add(new Prenda("Gucci", "Primer modelo"));
        lista.add(new Prenda("The game", "m"));

        GuardaRopa gr = new GuardaRopa();
        Integer i = gr.guardarPrendas(lista);
        gr.mostrarPrendas();
        List<Prenda> lista2 = gr.devolverPrendas(i);
        System.out.println(lista2);
        gr.mostrarPrendas();
    }
}
