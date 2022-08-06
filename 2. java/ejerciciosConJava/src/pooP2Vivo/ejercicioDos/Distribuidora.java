package pooP2Vivo.ejercicioDos;

import java.util.*;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productosPerecederos = new ArrayList<>();
        productosPerecederos.add(new Perecedero("Leche",20.50,3));
        productosPerecederos.add(new Perecedero("Queso",25.80,2));
        productosPerecederos.add(new Perecedero("Yogurt",10,3));
        productosPerecederos.add(new Perecedero("Jugo de naranja",23.70,1));
        productosPerecederos.add(new Perecedero("Salsa de tomate",25,15));

        List<Producto> productosNoPerecederos = new ArrayList<>();
        productosNoPerecederos.add(new NoPerecedero("Shampoo",30,"Higiene"));
        productosNoPerecederos.add(new NoPerecedero("Jabon para trastes",25.80,"Hogar"));
        productosNoPerecederos.add(new NoPerecedero("Sarten",50.20,"Hogar"));
        productosNoPerecederos.add(new NoPerecedero("Pasta de dientes",15,"Higiene"));
        productosNoPerecederos.add(new NoPerecedero("Cuchara",8.90,"Cocina"));

        System.out.println("Productos perecederos");
        for (int i=0;i<productosPerecederos.size();i++){
            System.out.println("El precio total es: " +productosPerecederos.get(i).calcular(5));
        }
        System.out.println("Productos no perecederos");
        for (int i=0;i<productosNoPerecederos.size();i++){
            System.out.println("El precio total es: " +productosNoPerecederos.get(i).calcular(5));
        }
    }
}
