package com.bootcamp.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
  public static void main(String[] args) {
    List<Producto> productos = new ArrayList<>();
    productos.add(new NoPerecedero("Fernet", 9056.19, "Bebida"));
    productos.add(new Perecedero(1, "Manzana", 2000.0));
    productos.add(new NoPerecedero("Atun", 6000.6, "Enlatado"));
    productos.add(new Perecedero(3, "Bananas", 2000.0));
    productos.add(new Perecedero(2, "Pan", 3000.90));

    Double precioFinal = productos.stream()
        .mapToDouble(producto -> producto.calcular(5))
        .sum();

    System.out.println("El precio total es: " + precioFinal);

  }
}
