package com.bootcamp.practicaProductos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero(1,"Papas",20));
        productos.add(new NoPerecedero("atun",50,"comestible"));
        productos.add(new Perecedero(3,"boniato",20));
        productos.add(new Perecedero(1,"fruta",20));
        productos.add(new Perecedero(6,"panchos",20));
        double precioAux=0;

        for (Producto producto:productos) {
          precioAux+=  producto.calcular(5);

        }
        System.out.println("Precio total: "+ precioAux);
    }
}
