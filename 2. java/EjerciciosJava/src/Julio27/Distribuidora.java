package Julio27;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static List<Producto> productos = new ArrayList<Producto>();
    public static void main(String[] args) {
        productos.add(new Perecedero("Tomate",10,3));
        productos.add(new Perecedero("lechuga",30,1));
        productos.add(new Perecedero("leche",18,2));
        productos.add(new Perecedero("fiambre",50,5));
        productos.add(new Perecedero("queso",50,6));

        productos.add(new NoPerecedero("arroz",15,"bolza"));
        productos.add(new NoPerecedero("arbejas",20,"enlatado"));
        productos.add(new NoPerecedero("lentejas",25,"bolza"));
        productos.add(new NoPerecedero("choclo",20,"enlatado"));
        productos.add(new NoPerecedero("fideos",19,"bolza"));

        float precioTotal = 0 ;
        for (int i =0;i<productos.size();i++)
        {
            precioTotal+=productos.get(i).calcular(5);
        }
        System.out.println(precioTotal);
    }
}
