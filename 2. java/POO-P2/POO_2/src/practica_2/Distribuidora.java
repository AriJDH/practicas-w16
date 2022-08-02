package practica_2;

import practica_2.Perecedero;
import practica_2.Producto;

public class Distribuidora {

    public static void main(String[] args) {
        
        Producto[] productos = new Producto[6];
        double total = 0;
        productos[0] = new Producto("Producto 1",1200);
        productos[1] = new Producto("Producto 2",1204350);
        productos[2] = new Producto("Producto 3",23);
        productos[3] = new Producto("Producto 4",434);
        productos[4] = new Producto("Producto 5",345);
        productos[5] = new Producto("Producto 6",453);
        
        for (Producto prd : productos){
            total += prd.getPrecio();
        }

        System.out.println("total = " + total);
    }
}
