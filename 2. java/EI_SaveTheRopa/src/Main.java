import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("SAVE THE ROPA!");

        GuardaRopa unGuardaRopa = new GuardaRopa();

        List<Prenda> prendas = Arrays.asList(new Prenda("Adidas", "SuperStar"),
                new Prenda("Nike", "Air force 1"));

        Integer keyPrendaGuardada = unGuardaRopa.guardarPrendas(prendas);

        unGuardaRopa.mostrarPrendas();

        List<Prenda> prendas2 = unGuardaRopa.devolverPrendas(keyPrendaGuardada);

        unGuardaRopa.mostrarPrendas();

        System.out.println("prendas: "+prendas2);
    }
}
