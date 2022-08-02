package poo.ejercicioDistribuidora;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new NoPerecedero("Arroz", 100, "Cereales"));
        productos.add(new Perecedero("Carne", 2000, 2));
        productos.add(new Perecedero("Pescado", 600, 3));
        productos.add(new Perecedero("Pollo", 900, 1));
        productos.add(new NoPerecedero("Fideos", 500, "Pastas"));

        for (Producto p : productos) {
            System.out.println("Producto: " + p.getNombre() + ", el precio x5u es : " + p.calcular(5));
        }
    }
}
