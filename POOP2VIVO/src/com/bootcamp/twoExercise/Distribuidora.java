package com.bootcamp.twoExercise;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {


    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        double precioTotal = 0;

        productos.add(new Perecedero("Papa", 4500, 3));
        productos.add(new Perecedero("Frijol", 2300, 10));
        productos.add(new Perecedero("Ajo", 2000, 30));
        productos.add(new Perecedero("Leche", 1500, 6));

        for(Producto producto: productos){
            precioTotal = producto.calcular(5);
            System.out.println("El precio es igual: " + precioTotal);

        }

    }

}
