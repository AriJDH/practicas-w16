package DistribuidoraProductos;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

       List<Producto> productos = new ArrayList<>();

       Producto producto1 = new Perecedero("tomate",2200,3);
       Producto producto2 = new NoPerecedero("galleta", 1900, "light");
       Producto producto3 = new Perecedero("pollo",10600,1);
       Producto producto4 = new Perecedero("pescado",9800,4);
       Producto producto5 = new NoPerecedero("salsa de tomate",7200,"Aderezos");
       Producto producto6 = new Perecedero("aguacate", 5500, 2);
       Producto producto7 = new Perecedero("higado", 15500, 1);
       Producto producto8 = new NoPerecedero("sal", 4100,"Aderezos");
       Producto producto9 = new NoPerecedero("rabioli", 6100, "Pasta");
       Producto producto10 = new NoPerecedero("atun",14000,"Enlatados");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);

        for (Producto p: productos) {
            p.calcular(2);
            System.out.println("Producto "+p.getNombre());
            System.out.println("Precio a pagar: "+p.getPrecio());
        }
    }
}
