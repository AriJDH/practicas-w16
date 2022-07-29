package practica.poo.p2.vivo;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        NoPerecedero arroz = new NoPerecedero("Arroz blanco", 30.0, "Cereal");
        NoPerecedero pasta = new NoPerecedero("Cabellos de angel", 40.0, "Pasta");
        NoPerecedero semillas = new NoPerecedero("Semillas de chia", 10.0, "Semillas");
        NoPerecedero mani = new NoPerecedero("Mani pelado", 16.0, "Mani");
        NoPerecedero nueces = new NoPerecedero("Nueces", 12.0, "Nuez");
        Perecedero carne = new Perecedero("Bola de lomo", 100.0, 2);
        Perecedero alfajor = new Perecedero("Alfajor dulce de leche", 15.0, 20);
        Perecedero pollo = new Perecedero("Pollo", 90.0, 1);
        Perecedero queso = new Perecedero("Queso gouda", 45.0, 10);
        Perecedero pan = new Perecedero("Pan integral", 30.0, 3);

        ArrayList<Producto> productos = new ArrayList<Producto>();
        productos.add(arroz);
        productos.add(pasta);
        productos.add(carne);
        productos.add(alfajor);
        productos.add(pan);
        productos.add(queso);
        productos.add(pollo);
        productos.add(mani);
        productos.add(semillas);
        productos.add(nueces);

        double precioTotal = 0;

        for (Producto prod : productos) {
            precioTotal += prod.getPrecio();
        }

        System.out.println(precioTotal);
    }
}
