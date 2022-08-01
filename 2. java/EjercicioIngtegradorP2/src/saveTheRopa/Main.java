package saveTheRopa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuardarRopa guardarRopa = new GuardarRopa();
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(new Prenda("adidas", "tenis"));
        listaPrendas.add(new Prenda("nike", "camiseta"));

        Integer numero = guardarRopa.guardarPrendas(listaPrendas);
        guardarRopa.guardarPrendas(listaPrendas);

        System.out.println("Su ropa queda guardad en el "+ numero);

        guardarRopa.mostrarPrendas();

        listaPrendas = guardarRopa.devolverPrendas( 2);

        System.out.println(listaPrendas);



    }
}
