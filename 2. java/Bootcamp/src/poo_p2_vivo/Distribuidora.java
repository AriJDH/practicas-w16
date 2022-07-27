package poo_p2_vivo;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();
        int cantidad = 5;
        productos.add(new Perecedero("Leche", 30.0, 4));
        productos.add(new NoPerecedero("Arroz", 45.0, "?"));

        for(Producto p : productos) {
            System.out.printf("%s\t-Precio calculado para %s articulo/s: $%.2f\n", p, cantidad, p.calcular(cantidad));
        }
    }
}
