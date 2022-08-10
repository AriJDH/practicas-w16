package excepciones;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productosNoPerecederos = new ArrayList<>();
        List<Producto> productosPerecederos = new ArrayList<>();

        productosNoPerecederos.add(new NoPerecedero("Fideos", 100, "Alimentos"));
        productosNoPerecederos.add(new NoPerecedero("Atún", 300, "Alimentos"));
        productosNoPerecederos.add(new NoPerecedero("Arroz", 200, "Alimentos"));
        productosNoPerecederos.add(new NoPerecedero("Arvejas", 120, "Alimentos"));
        productosNoPerecederos.add(new NoPerecedero("Lentejas", 80, "Alimentos"));

        productosPerecederos.add(new Perecedero("Carne", 500, 1));
        productosPerecederos.add(new Perecedero("Leche", 250, 2));
        productosPerecederos.add(new Perecedero("Tomate", 300, 3));
        productosPerecederos.add(new Perecedero("Lechuga", 230, 2));
        productosPerecederos.add(new Perecedero("Papas", 100, 4));

        System.out.println("Productos no Perecederos");
        System.out.println("******* Precio total al vender 5 productos *******");
        for (Producto p : productosNoPerecederos) {
            System.out.println(p + " Precio total: " + p.calcular(5));
        }

        System.out.println("________________________________________________");
        System.out.println("Productos Perecederos");
        System.out.println("******* Precio total al vender 5 productos *******");
        for (Producto p : productosPerecederos) {
            System.out.println(p + " Precio total: " + p.calcular(5));
        }

    }
}
