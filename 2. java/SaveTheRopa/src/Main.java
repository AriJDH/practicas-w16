import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Prenda> listaPrendas = new ArrayList<>(Arrays.asList(
        new Prenda("Paris", "Camisa"),
        new Prenda("Loft", "Pantalón")
    ));

    List<Prenda> listaPrendas1 = new ArrayList<>(Arrays.asList(
        new Prenda("PepeJeans", "Corta Viento"),
        new Prenda("Americanino", "Jeans")
    ));

    GuardaRopa guardaRopa = new GuardaRopa();
    guardaRopa.guardarPrendas(listaPrendas);
    guardaRopa.guardarPrendas(listaPrendas1);
    guardaRopa.mostrarPrendas();

    int identificador = 1;
    System.out.println("Prendas guardadas en el identificador " + identificador + ": " + "\n"
        + guardaRopa.devolverPrendas(identificador));
  }
}
