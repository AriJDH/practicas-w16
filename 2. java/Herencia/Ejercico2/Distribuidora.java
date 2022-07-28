package Herencia.Ejercico2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        Producto productoPerecedero = new Peredecedero("Leche", 35.0, 2);
        Producto productoPerecedero1 = new Peredecedero("Carne", 200.0, 1);
        Producto productoNoPerecedero = new NoPerecedero("Arroz", 60.0, "Cereal");

        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(productoPerecedero);
        productos.add(productoPerecedero1);
        productos.add(productoNoPerecedero);

        double valorTotal =0;
        for(int i = 0; i<productos.size();i++){
            valorTotal += productos.get(i).caluclar(5);
        }
        System.out.println(valorTotal);
    }
}
