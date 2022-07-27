package EjercicioClases;

import java.util.*;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> producto= new ArrayList<Producto>();
        int cantidad=5;
        producto.add(new Producto("lapiz",21));
        producto.add(new Producto("lapiz",21));
        producto.add(new Parecedero("aceite",21,1));
        producto.add(new Parecedero("fideos",21,2));
        producto.add(new Parecedero("coca",21,3));
        producto.add(new NoParecedero("lapiz",21,"favo"));
        for (Producto p: producto){
            System.out.print("prodcuto----"+ p);
            System.out.println("cantidad-----"+cantidad);
            System.out.println("---precio"+p.calcular(cantidad));
        }
        System.out.println(producto);
    }
}
