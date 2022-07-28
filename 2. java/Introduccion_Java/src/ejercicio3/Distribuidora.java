package ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        Producto tallarines = new NoPerecedero("tallarines", 799.0, "Comestible");
        Perecedero tomates = new Perecedero("1 kilo de tomates", 2900.0, 5);
        Producto desodorante = new NoPerecedero("desodorante",1290.0, "Higiene Personal");
        Producto camionDeJuguete = new NoPerecedero("camión de juguete",20000.0, "Juguetería");
        Perecedero pan = new Perecedero("1 kilo de pan", 2000.0,2);

        productos.add(tallarines);
        productos.add(tomates);
        productos.add(desodorante);
        productos.add(camionDeJuguete);
        productos.add(pan);

        Double precioFinal = 0.0;

        for (int i = 0; i < productos.size(); i++){
            precioFinal += productos.get(i).calcular(5.0);
        }

        System.out.println("El precio de todos los productos es: " + precioFinal);

    }
}


