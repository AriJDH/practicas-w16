package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Prenda p1 = new Prenda("Polo","Sweater");
        Prenda p2 = new Prenda("Caterpilar","Campera");

        Prenda p3 = new Prenda("Gucci","Cartera");
        Prenda p4 = new Prenda("Prada","Bufanda");

        List<Prenda> list1 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);

        List<Prenda> list2= new ArrayList<>();
        list2.add(p3);
        list2.add(p4);

        GuardaRopa guardaRopa = new GuardaRopa();

        System.out.println(guardaRopa.guardarPrendas(list1));
        System.out.println(guardaRopa.guardarPrendas(list2));

        System.out.println(guardaRopa.devolverPrendas(1));
        System.out.println(guardaRopa.devolverPrendas(2));

        guardaRopa.mostrarPrendas();


    }
}
