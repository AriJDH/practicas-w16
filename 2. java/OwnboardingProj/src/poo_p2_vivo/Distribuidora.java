package poo_p2_vivo;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto producto1 = new Perecedero("Leche", 100f, 3);
        Producto producto2 = new Perecedero("Queso", 300f, 300);
        Producto producto3 = new NoPerecedero("Arroz", 100f, "Grano");
        Producto producto4 = new Perecedero("Coca", 500f, 50);
        Producto producto5 = new NoPerecedero("Lenteja", 500f, "Grano");
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        double montoTotal = 0;
        for (Producto p:
             productos) {
            montoTotal += p.calcular(1);
        }

        System.out.println("Precio total: " + montoTotal);
    }
}