import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        Producto producto = new Producto("P1",100);
        Producto producto2 = new Producto("P2",100);
        Producto producto3 = new Producto("P3",100);
        Producto producto4 = new Producto("P4",100);
        Producto producto5 = new Producto("P5",100);
        List<Producto> productoList = new ArrayList<>();

        productoList.add(producto);
        productoList.add(producto2);
        productoList.add(producto3);
        productoList.add(producto4);
        productoList.add(producto5);

        //producto.calcular();

        Perecedero perecedero = new Perecedero("Carne", 200,2);
        Perecedero perecedero2 = new Perecedero("Leche", 100,2);
        Perecedero perecedero3 = new Perecedero("Queso", 600,2);
        Perecedero perecedero4 = new Perecedero("Jamón", 300,2);
        Perecedero perecedero5 = new Perecedero("Jugo", 90,2);

        List<Perecedero> perecederoList = new ArrayList<>();
        perecederoList.add(perecedero);
        perecederoList.add(perecedero2);
        perecederoList.add(perecedero3);
        perecederoList.add(perecedero4);
        perecederoList.add(perecedero5);


        //System.out.println(perecedero);
        System.out.println("\nCálculo Perecedero: " + perecedero.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo Perecedero: " + perecedero2.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo Perecedero: " + perecedero3.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo Perecedero: " + perecedero4.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo Perecedero: " + perecedero5.calcular(perecedero.getDiasPorCaducar()));



        NoPerecedero noPerecedero = new NoPerecedero("w",300,"1");
        NoPerecedero noPerecedero2 = new NoPerecedero("Leche", 100,"2");
        NoPerecedero noPerecedero3 = new NoPerecedero("Queso", 600,"3");
        NoPerecedero noPerecedero4 = new NoPerecedero("Jamón", 300,"4");
        NoPerecedero noPerecedero5 = new NoPerecedero("Jugo", 90,"5");

        List<NoPerecedero> noPerecederoList = new ArrayList<>();
        noPerecederoList.add(noPerecedero);
        noPerecederoList.add(noPerecedero2);
        noPerecederoList.add(noPerecedero3);
        noPerecederoList.add(noPerecedero4);
        noPerecederoList.add(noPerecedero5);
        System.out.println(noPerecederoList.toString());

        //System.out.println(perecedero);
        System.out.println("\nCálculo No Perecedero: " + noPerecedero.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo No Perecedero: " + noPerecedero2.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo No Perecedero: " + noPerecedero3.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo No Perecedero: " + noPerecedero4.calcular(perecedero.getDiasPorCaducar()));
        System.out.println("\nCálculo No Perecedero: " + noPerecedero5.calcular(perecedero.getDiasPorCaducar()));

    }

}
