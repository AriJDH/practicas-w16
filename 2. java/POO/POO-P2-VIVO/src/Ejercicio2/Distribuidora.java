package Ejercicio2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        //objetos noperecederos
        Producto producto1 = new NoPerecedero("Arroz", 100, "no perecedero");
        Producto producto2 = new NoPerecedero("Harina", 100, "no perecedero");
        Producto producto3 = new NoPerecedero("Fideos", 100, "no perecedero");
        Producto producto4 = new NoPerecedero("Café", 100, "no perecedero");
        Producto producto5 = new NoPerecedero("Sal", 100, "no perecedero");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        double precioTotal = 0;
        for (int i = 0; i < productos.size(); i++) {
            precioTotal = productos.get(i).calcular(productos.size());
        }
        System.out.println(precioTotal);

        Producto producto6 = new Perecedero("Queso", 100, 3);
        Producto producto7 = new Perecedero("Yogurth", 100, 2);
        Producto producto8 = new Perecedero("Carne", 100, 1);
        Producto producto9 = new Perecedero("Fruta", 100, 1);
        Producto producto10 = new Perecedero("Verdura", 100, 1);

        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);

        for (Producto producto: productos){
            System.out.println(producto.calcular(productos.size()));
            System.out.println(producto.toString());
        }


    }
}
