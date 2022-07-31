package EjercicioProducto;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList();
        double precioTotal = 0;

        Producto leche = new Perecedero("leche", 60.50, 2);
        Producto manzana = new Perecedero("Manzana", 10, 3);
        Producto banana = new Perecedero("Banana", 15, 1);
        Producto lentejas = new NoPerecedero("Lentejas", 50, "Legumbres");
        Producto porotos = new NoPerecedero("Porotos", 60, "legumbres");

        productos.add(lentejas);
        productos.add(banana);
        productos.add(manzana);
        productos.add(leche);
        productos.add(porotos);

        for (Producto prod : productos) {
            precioTotal = prod.calcular(5);
        }
        System.out.println("El precio total de los productos es: " + precioTotal);
    }

}
