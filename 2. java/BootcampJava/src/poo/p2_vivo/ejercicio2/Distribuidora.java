package poo.p2_vivo.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productoList = new ArrayList<>();
        Producto producto1 = new Perecedero("Pan Rebanado", 210.5, 2);
        Producto producto2 = new NoPerecedero("Arroz", 150.80, "Yamani");
        Producto producto3 = new Perecedero("Queso", 180, 1);
        Producto producto4 = new Perecedero("Leche", 120.5, 3);

        productoList.add(producto1);
        productoList.add(producto2);
        productoList.add(producto3);
        productoList.add(producto4);

        for (Producto p: productoList) {
            System.out.println(p.toString());
            System.out.println("El total es: " +p.calcular(5)+"\n");

        }


    }

}
