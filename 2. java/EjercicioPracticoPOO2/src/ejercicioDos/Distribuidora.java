package ejercicioDos;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        double precioTotal=0;
        ArrayList<Producto> productos = new ArrayList();
        Producto producto1 = new NoPerecedero("Cocacola",2000.0,"Gaseosa");
        Producto producto2 = new Perecedero("Leche",1500.0,2);
        Producto producto3 = new NoPerecedero("Margarita",1000.0,"Papas Paquete");
        Producto producto4 = new Perecedero("Queso",4000.0,1);
        Producto producto5 = new NoPerecedero("Pepsi",2800.0,"Gaseosa");
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        for (int x = 0; x<productos.size(); x++){
            precioTotal = precioTotal+productos.get(x).calcular(5);
        }
        System.out.println(precioTotal);

    }
}
