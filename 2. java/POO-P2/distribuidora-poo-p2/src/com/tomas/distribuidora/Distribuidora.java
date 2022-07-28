package com.tomas.distribuidora;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 27 de Julio 2022
 */

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        //Agrega los elementos al ArrayList
        productos.add(new Perecedero("Carne", 1200, 2));
        productos.add(new Perecedero("Queso", 3500, 1));
        productos.add(new Perecedero("Pollo", 6700, 3));
        productos.add(new Perecedero("Pescado", 700, 1));
        productos.add(new Perecedero("Mantequilla", 300, 1));

        productos.add(new NoPerecedero("Frijol", 14500, "legumbre"));
        productos.add(new NoPerecedero("Lenteja", 1500, "legumbre"));
        productos.add(new NoPerecedero("Arroz", 1800, "legumbre"));
        productos.add(new NoPerecedero("Arveja", 1800, "legumbre"));
        productos.add(new NoPerecedero("Garbanzos", 1200, "legumbre"));

        double precioTotal = 0;

        //Recorre los elementos contenidos en el ArrayList productos para calcular y sumar el total de las ventas
        for(int contador = 0; contador < productos.size(); contador++) {

            precioTotal += productos.get(contador).calcular(5);

        }

        System.out.println("Precio Total: " + precioTotal);

    }

}
