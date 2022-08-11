package POO.poo2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos= new ArrayList<Producto>();

        Perecedero producto1 = new Perecedero("Producto 1", 100, 3);
        productos.add(producto1);
        Perecedero producto2 = new Perecedero("Producto 2", 150, 2);
        productos.add(producto2);
        Perecedero producto3 = new Perecedero("Producto 3", 200, 1);
        productos.add(producto3);
        Perecedero producto4 = new Perecedero("Producto 4", 570, 30);
        productos.add(producto4);

        NoPerecedero producto5 = new NoPerecedero("Producto 5", 60, "arroz");
        productos.add(producto5);


        double precioTotal = 0;
        for (Producto p : productos) {
            precioTotal += p.calcular(5);
        }
        System.out.println("El precio total es = " + precioTotal);
    }
}
