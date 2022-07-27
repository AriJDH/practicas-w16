package Main;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("producto1",10,3));
        productos.add(new Perecedero("producto2",23,2));
        productos.add(new Perecedero("producto3",50,1));
        productos.add(new Perecedero("producto4",10,4));
        productos.add(new Perecedero("producto5",10,0));

        productos.add(new NoPerecedero("productoNo1",15,"comida"));
        productos.add(new NoPerecedero("productoNo2",14,"comida"));
        productos.add(new NoPerecedero("productoNo3",13,"comida"));
        productos.add(new NoPerecedero("productoNo4",12,"comida"));
        productos.add(new NoPerecedero("productoNo5",11,"comida"));

        double sum = 0;
        for (int i = 0; i < productos.size(); i++){
            sum += productos.get(i).calcular(2);
        }

        System.out.println("Monto total: $ " + sum);
    }
}
