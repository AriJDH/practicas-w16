package herencia.polimorfismo.encapsulamiento.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){
        List<Producto> productos = new ArrayList<>();
        productos.add(new NoPerecedero("Yerba", 600, "Infusion"));
        productos.add(new NoPerecedero("Arroz", 80, "Cereal"));
        productos.add(new NoPerecedero("Comino", 100, "Condimento"));
        productos.add(new NoPerecedero("Tomate", 300, "Verdura"));
        productos.add(new NoPerecedero("Azucar", 100, "Fina"));
        productos.add(new Perecedero("Leche", 120, 5));
        productos.add(new Perecedero("Manteca", 200, 7));
        productos.add(new Perecedero("Pescado", 1200, 3));
        productos.add(new Perecedero("Crema", 200, 5));
        productos.add(new Perecedero("Carne", 2600, 10));

        for(Producto producto : productos)
        {
            System.out.println(producto.toString());
            System.out.println("Precio: "+ producto.calcular(3));
        }
    }
}
