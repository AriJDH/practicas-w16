package practica.ejerciciosintegradores.p2.vivo.savetheropa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prendaUno = new Prenda("Nike", "Air");
        Prenda prendaDos = new Prenda("Adidas", "Predator");

        List<Prenda> prendas = new ArrayList<>(Arrays.asList(prendaUno, prendaDos));

        GuardaRopa guardaRopa = new GuardaRopa();
        int numeroPrendasUno = guardaRopa.guardarPrendas(prendas);
        System.out.println("Numero prendas guardadas: "+ numeroPrendasUno);
        System.out.println("Prendas guardadas: " + guardaRopa.devolverPrendas(numeroPrendasUno));

        Prenda prendaTres = new Prenda("Puma", "Motion");
        Prenda prendaCuatro = new Prenda("Under Armour", "Warrior");

        List<Prenda> prendasDos = new ArrayList<>(Arrays.asList(prendaTres, prendaCuatro));

        int numeroPrendasDos = guardaRopa.guardarPrendas(prendasDos);
        System.out.println("Numero prendas guardadas dos: "+ numeroPrendasDos);
        System.out.println("Prendas guardadas dos: " + guardaRopa.devolverPrendas(numeroPrendasDos));
    }
}
