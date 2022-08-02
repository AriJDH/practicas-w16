package poo.ejercicioSaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Prenda> prendas = new ArrayList<>();

        Prenda campera = new Prenda("Adidas", "Original");
        Prenda zapatillas = new Prenda("Nike", "Air");

        prendas.add(campera);
        prendas.add(zapatillas);

        List<Prenda> prendas2 = new ArrayList<>();
        Prenda jogging = new Prenda("Reebok", "Lindo");
        Prenda remera = new Prenda("Puma", "Mas lindo");
        
        prendas2.add(jogging);
        prendas2.add(remera);

        Guardarropa guadarropa = new Guardarropa();
        int id1 = guadarropa.guardarPrendas(prendas);
        int id2 = guadarropa.guardarPrendas(prendas2);

        System.out.println("Prendas guardadas: ");
        guadarropa.mostrarPrendas();

        System.out.println("Prendas por id 2: ");
        System.out.println(guadarropa.consultarPrendas(id2));
        System.out.println("Prendas por id 1: ");
        System.out.println(guadarropa.consultarPrendas(id1));


    }
}
