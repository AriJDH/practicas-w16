/*
 * Crear una clase ejecutable llamada Distribuidora
 * donde van a crear un array de productos, imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.
 */

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Distribuidora {
    public static void main(String args[]){
        ArrayList<Producto> inventario = new ArrayList<>();

        // Perecederos
        inventario.add(new Perecedero("Leche", 0, 3));
        inventario.add(new Perecedero("Carne", 0, 2));
        inventario.add(new Perecedero("Manzana", 0, 1));
        inventario.add(new Perecedero("Huevos", 0, 3));
        inventario.add(new Perecedero("Tomate", 0, 1));

        //No Perecederos 
        inventario.add(new NoPerecedero("Atun", 1230, "Enlatado"));
        inventario.add(new NoPerecedero("Arroz", 2130, "Enlatado"));
        inventario.add(new NoPerecedero("Frijoles", 530, "Enlatado"));
        inventario.add(new NoPerecedero("Salsa", 3530, "Enlatado"));
        inventario.add(new NoPerecedero("Aceitunas", 6000, "Enlatado"));

        AtomicReference<Double> precioTotal = new AtomicReference<>(0.0);

        inventario.forEach( producto -> {
            precioTotal.set(producto.calcular(5) + precioTotal.get());
        });

        System.out.println("Precio total: " + precioTotal);
    }
}
