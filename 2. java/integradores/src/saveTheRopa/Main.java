package saveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendasAGuardar = new ArrayList<>();
        GuardaRopa guardaRopa = new GuardaRopa();

        prendasAGuardar.add(new Prenda("Gucci", "Tapado"));
        prendasAGuardar.add(new Prenda("Nike", "Mochila"));

        int numero = guardaRopa.guardarPrendas(prendasAGuardar);

        System.out.println("Numero de retiro: " + numero);

        guardaRopa.devolverPrendas(numero);


    }
}
