package Ejercicios3;

public class Distribuidora {
    public static void main(String[] args) {
        /*
        Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
         imprimir el precio total
         al vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.
         */

        Producto[] productos = new Producto[5];
        productos[0] = new NoPerecedero("Leche", 100);
        productos[1] = new NoPerecedero("Huevos", 250);
        productos[2] = new Perecedero("Pan", 150, 1);
        productos[3] = new Perecedero("Queso", 250, 3);
        productos[4] = new Perecedero("Tomate", 150, 2);


        System.out.println(productos[0].calcular(3));
        System.out.println(productos[1].calcular(3));
        System.out.println(productos[2].calcular(3));
        System.out.println(productos[3].calcular(3));
        System.out.println(productos[4].calcular(3));
    }
}
