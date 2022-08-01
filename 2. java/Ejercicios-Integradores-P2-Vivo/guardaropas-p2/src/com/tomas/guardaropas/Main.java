package com.tomas.guardaropas;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(new Prenda("Nike", "Jordan"));
        listaPrendas.add(new Prenda("Adidas", "algun modelo"));

        GuardaRopa guardaRopa = new GuardaRopa();

        int codigo = guardaRopa.guardarPrendas(listaPrendas);

        System.out.println("Prendas con el id " + codigo );
        guardaRopa.devolverPrendas(codigo).forEach(System.out::println);

    }
}
