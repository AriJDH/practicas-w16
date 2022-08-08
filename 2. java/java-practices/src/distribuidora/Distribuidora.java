package distribuidora;

import java.util.ArrayList;
import java.util.List;

/*
 * Ejercicio > Modulo 5: Java > POO-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Distribuidora {
    public static void main(String[] args){
        List<Producto> listaDeProductos = new ArrayList();
        listaDeProductos.add(new NoPerecedero("Fideos", 500.0, "Carbohidratos"));
        listaDeProductos.add(new NoPerecedero("Arroz", 250.0, "Carbohidratos"));
        listaDeProductos.add(new NoPerecedero("Almendras", 300.0, "Frutos secos"));
        listaDeProductos.add(new Perecedero("Carne de vaca", 1750.0, 3));
        listaDeProductos.add(new Perecedero("Leche líquida", 250.0, 1));

        double precioTotal = 0.0;
        // Segun enunciado: se asume que se compran 5 productos de cada tipo
        for(Producto producto: listaDeProductos){
            precioTotal += producto.calcular(5);
        }

        System.out.println("RESULTADO");
        System.out.println("> El precio total por los productos es: $" + precioTotal);
    }
}
