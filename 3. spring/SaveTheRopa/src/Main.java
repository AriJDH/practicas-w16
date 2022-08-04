import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Adidas", "T-shirt");
        Prenda prenda2 = new Prenda("Nike", "Jacket");
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);

        guardaRopa.guardarPrendas(listaDePrendas);
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(0));

    }
}
