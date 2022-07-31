/*
    Author: Tannia Lucía Hernández Rojas
    Descripción: Calcular el valor total correspondiente a los productos de una lista.
                Ejercicios herencia y polimorfismo.
    Fecha: 27 de Julio de 2022
*/

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args){
        List<Producto> listaProductos = new ArrayList<>();

        listaProductos.add(new Perecedero("Yogurt", 3800, 2));
        listaProductos.add(new NoPerecedero("Arroz", 1200, "Cereal"));
        listaProductos.add(new Perecedero("Queso", 5200,12));
        listaProductos.add(new NoPerecedero("Frijoles", 6300, "Granos"));
        listaProductos.add(new Perecedero("Pan", 4600, 1));
        listaProductos.add(new NoPerecedero("Atún", 7300, "Enlatado"));
        listaProductos.add(new Perecedero("Leche", 4500, 8));
        listaProductos.add(new NoPerecedero("Harina", 1100, "Harina"));
        listaProductos.add(new Perecedero("Salchichas", 8600, 23));
        listaProductos.add(new NoPerecedero("Espagueti", 3200, "Cereales"));

        for(Producto producto: listaProductos){
            System.out.println("El precio total de 5 productos corresponde a "+producto.calcular(5) +". "+producto.toString());
        }
    }

}
