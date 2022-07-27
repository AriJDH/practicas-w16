package practicaPoo2Vivo.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        //Perecederos
        productos.add(new Perecedero("ProductoP1", 10d, 1));
        productos.add(new Perecedero("ProductoP2", 6.5d, 2));
        //No perecederos
        productos.add(new NoPerecedero("ProductoNoP1", 23.5d, "Tipo1"));

        productos.stream().forEach(producto -> {
            System.out.println("-------------------------------------------------------------");
            System.out.println(producto.toString());
            System.out.println("Precio al vender 5 productos = " + producto.calcular(5));
        });

        System.out.println("-------------------------------------------------------------");
        System.out.println("Precio total entre todos los productos al vender 5 productos:");
        Double sumatoriaTotal = productos.stream().mapToDouble(producto -> producto.calcular(5)).sum();
        System.out.println("Precio total sumado = " + sumatoriaTotal);
    }

}
