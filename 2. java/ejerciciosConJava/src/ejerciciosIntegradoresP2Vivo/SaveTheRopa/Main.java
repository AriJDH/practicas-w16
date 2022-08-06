package ejerciciosIntegradoresP2Vivo.SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda jeans = new Prenda("Levis","Mezclilla gris");
        Prenda blusa = new Prenda("Zara","Blusa con estampado");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(jeans);
        prendas.add(blusa);

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigo = guardaRopa.guardarPrendas(prendas);
        System.out.println("El codigo es: " + codigo);
        System.out.println("Las prendas guardadas son:");
        guardaRopa.mostrarPrendas();
        //System.out.println("Devolviendo ropa");
        System.out.println(guardaRopa.devolverPrenda(1));

        Prenda abrigo = new Prenda("Santory","Modelo de cuadros");
        Prenda pantalon = new Prenda("Furor","Mezclilla gruesa");

        GuardaRopa guardaRopa2 = new GuardaRopa();
        List<Prenda> prendas1 = new ArrayList<>();
        prendas1.add(abrigo);
        prendas1.add(pantalon);
        System.out.println("El codigo es: "+ guardaRopa.guardarPrendas(prendas1));
        System.out.println("Las prendas guardadas son:");
        guardaRopa.mostrarPrendas();

/*
        System.out.println("El codigo es: " + guardaRopa2.guardarPrendas(prendas1));
        System.out.println("Tus prendas son: ");
        guardaRopa2.mostrarPrendas();
  */
    }
}
