package JavaPOOP2VIVO.distribuidora;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        Producto perecedero = new Perecedero("Pollo", 20000, 3);
        Producto noPerecedero = new NoPerecedero("Arroz", 5000, "Grano");

        List<Producto> distribucion = new ArrayList<>();
        distribucion.add(perecedero);
        distribucion.add(noPerecedero);

        double total = perecedero.calcular(5) + noPerecedero.calcular(5);
        System.out.println("Precio Total: " + total);
    }
}
