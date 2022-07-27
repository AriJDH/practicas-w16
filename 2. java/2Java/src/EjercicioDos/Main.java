package EjercicioDos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> lstProducto = new ArrayList<>();
        lstProducto.add(new NoPerecedero("Arroz", 1200, "Fino"));
        lstProducto.add(new NoPerecedero("Fideo", 800, "Pasta"));
        lstProducto.add(new NoPerecedero("Sopa", 650, "Polvo"));
        lstProducto.add(new NoPerecedero("Atun", 3200, "Conserva"));
        lstProducto.add(new NoPerecedero("Sal", 300, "Fina"));
        lstProducto.add(new Perecedero("Carne", 5300, 2));
        lstProducto.add(new Perecedero("Pollo", 2300, 1));
        lstProducto.add(new Perecedero("Salchicha", 1000, 3));
        lstProducto.add(new Perecedero("Mantequilla", 1200, 60));
        lstProducto.add(new Perecedero("Leche", 800, 10));

        for(Producto producto : lstProducto)
        {
            System.out.println(producto.toString());
            System.out.println("Precio: "+ producto.calcular(3));
        }
    }
}
