package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){
        List<Producto> productos = new ArrayList<Producto>();

        productos.add(new NoPerecedero("Producto1", 4000.0, "Tipo1"));
        productos.add(new Perecedero("Producto2", 2000.0, 1));
        productos.add(new NoPerecedero("Producto3", 5000.0, "Tipo2"));
        productos.add(new Perecedero("Producto4", 1000.0, 2));
        productos.add(new NoPerecedero("Producto5", 3500.0, "Tipo3"));
        productos.add(new Perecedero("Producto6", 1500.00, 3));

        double total = 0;

        for (Producto prod: productos){
            total = total + prod.calcular(5);
        }

        System.out.println("El precio total es de: " + total);


    }
}


