package saveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Prenda> listaPrendas = new ArrayList<Prenda>();
        listaPrendas.add(new Prenda("Nike","Jordan"));
        listaPrendas.add(new Prenda("Adidas","original"));

        GuardaRopa guardaRopa = new GuardaRopa();

        int codigo = guardaRopa.guardarPrendas(listaPrendas);

        guardaRopa.mostrarPrendas();

        System.out.println("Printeo por consulta de el id asingado("+codigo+")");
        guardaRopa.devolverPrendas(codigo).forEach(System.out::println);
    }
}
