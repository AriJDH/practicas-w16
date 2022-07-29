package POOP2VIVO.Ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("Parte 1 del ejercicio Producto");
        Producto producto = new Producto("Manzana", 125.5);
        System.out.println("Quiero 2 "+producto.getNombre()+" el precio es "+producto.calcular(2));
        //Para imprimir se incluye el objeto instanciado
        //esto se debe a que tenemos el metodo toString sobrescrito
        System.out.println(producto);
        System.out.println("-------------------------------------");
        System.out.println("Parte 2 del ejercicio Perecedero");
        Perecedero perecedero = new Perecedero("Sandia", 2500.5, 1);
        System.out.println(perecedero);
        System.out.println("Considerando los dias por caducar el precio total por 2 productos es: "+perecedero.calcular(2));
        System.out.println("-------------------------------------");
        System.out.println("Parte 3 del ejercicio noPerecedero");
        NoPerecedero noPerecedero = new NoPerecedero("Naranja", 45.6, "Citrico");
        System.out.println(noPerecedero);
        System.out.println("El precio por 2 productos es: "+noPerecedero.calcular(2));
        System.out.println("-------------------------------------");
        System.out.println("Parte 4 del ejercicio Distribuidora");

        ArrayList<Producto> productos = new ArrayList<Producto>();

        Producto producto1 = new Perecedero("Sandia",45.6,3);
        productos.add(producto1);
        Producto producto2 = new Perecedero("Manzana",42.6,2);
        productos.add(producto2);
        Producto producto3 = new NoPerecedero("Naranja",45.6,"Citrico");
        productos.add(producto3);
        Producto producto4 = new Perecedero("Durazno",45.6,3);
        productos.add(producto4);
        Producto producto5 = new NoPerecedero("Melon",45.6,"Dulce");
        productos.add(producto5);
        //For each(OBJETO ITERADOR ARRAY)
        for (Producto prod: productos){
            System.out.println(prod.calcular(5));
            System.out.println(prod.toString());
        }


    }
}
