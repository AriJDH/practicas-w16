package saveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda saco = new Prenda("fafa", "saco");
        Prenda pant = new Prenda("bas", "pantalon");

        List<Prenda> lista = new ArrayList<>();
        lista.add(saco);
        lista.add(pant);

        GuardaRopa guardado = new GuardaRopa();

        System.out.println(guardado.guardarPrendas(lista));

        guardado.mostrarPrendas();

        System.out.println(guardado.devolverPrendas(1));







    }
}
