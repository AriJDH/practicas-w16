package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();


        Perecedero per = new Perecedero("Leche", 35, 5);
        Perecedero per1 = new Perecedero("Leche", 35, 1);
        Perecedero per2 = new Perecedero("Leche", 35, 2);

        productos.add(per);
        productos.add(per1);
        productos.add(per2);

        double precioTotal = 0;

        for (Producto p : productos) {
            precioTotal = precioTotal + p.Calcular(5);
        }

        System.out.println(precioTotal);

    }
}
