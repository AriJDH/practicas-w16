package practicaException2;

import java.util.ArrayList;
import java.util.List;

public class Distruidora {

    public static void main(String[] args) {
        List<Producto> lista = new ArrayList<>();

        Producto a = new Producto("Manteca",100.5);
        Producto b = new Perecedero("Fideo",100, 3);
        Producto c = new NoPerecedero("Yogurt",200, "Lacteo");
        Producto d = new Producto("Arroz",300);
        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        for(Producto p: lista){
            System.out.println("Producto " + p.getNombre() + " - Precio unitario: " + p.getPrecio() +" - Precio calculado: " + p.calcular(4));
        }
    }
}
