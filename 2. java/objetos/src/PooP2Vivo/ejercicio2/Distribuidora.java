package PooP2Vivo.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new NoPerecedero("Fideos",1,"Comestible"));
        productos.add(new NoPerecedero("Arroz", 1,"Comestible"));
        productos.add(new NoPerecedero("Azucar",1,"Endulzante"));
        productos.add(new Perecedero("Leche",1,1));
        productos.add(new Perecedero("Carne",1,3));
        productos.add(new Perecedero("Pollo",1,4));

        double precioFinal = productos
                .stream()
                .reduce(0.0, (total,producto) -> total + producto.calcular(5), Double::sum);
        System.out.println("El precio final es de : $" +precioFinal);

    }
}
