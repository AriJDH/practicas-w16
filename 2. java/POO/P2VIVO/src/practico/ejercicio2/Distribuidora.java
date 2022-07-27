package practico.ejercicio2;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();

        Producto producto1 = new Perecedero("Tomate", 5.2, 3);
        productos.add(producto1);
        Producto producto2 = new Perecedero("Morrón", 50.3, 5);
        productos.add(producto2);
        Producto producto3 = new Perecedero("Sandía", 120.00, 1);
        productos.add(producto3);
        Producto producto4 = new NoPerecedero("Arroz", 15, "Arroz");
        productos.add(producto4);
        Producto producto5 = new NoPerecedero("Arvejas", 150, "Enlatado");
        productos.add(producto5);

        for (Producto prod: productos){
            System.out.println(prod.calcular(5));
        }
    }

}
