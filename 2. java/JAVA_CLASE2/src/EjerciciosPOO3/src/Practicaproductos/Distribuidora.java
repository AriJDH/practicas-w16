package Practicaproductos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {

public static void main(String[] args) {
    List<Producto> productos = new ArrayList<>();

    productos.add(new NoPerecedero("Fideos",1000,"Comestible"));
    productos.add(new NoPerecedero("Arroz", 1000,"Comestible"));
    productos.add(new NoPerecedero("Azucar",1000,"Endulzante"));
    productos.add(new NoPerecedero("Leche",1000,"Endulzante"));
    productos.add(new NoPerecedero("Carne",1000,"Endulzante"));

    productos.stream().forEach(producto -> {
        System.out.println("-------------------------------------------------------------");
        System.out.println(producto.toString());
        System.out.println("Precio al vender 5 productos = " + producto.calcular(5));
    });
}
}
