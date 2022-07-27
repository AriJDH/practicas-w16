package productos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private List<Producto> listaProductos = new ArrayList<>();

    public static void main(String[] args) {
        Distribuidora dist = new Distribuidora();
        dist.listaProductos.add(new Producto("jabón", 1.0));
        dist.listaProductos.add(new Perecedero("Atún", 1.5, 2));
        dist.listaProductos.add(new NoPerecedero("Novela", 10, "Libro"));

        for (Producto producto : dist.listaProductos) {
            System.out.println(producto);
            System.out.println("Precio total: " + producto.calcular(5));
            System.out.println();
        }

    }
}
