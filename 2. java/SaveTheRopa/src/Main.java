import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Prenda que se guarda en la posición 0 del HashMap
        List<Prenda> listaPrendas = new ArrayList<>(Arrays.asList(
                new Prenda("Levis", "Polera"),
                new Prenda("Maui", "Pantalón")
        ));

        //Prenda que se guarda en la posición 1 del HashMap
        List<Prenda> listaPrendas1 = new ArrayList<>(Arrays.asList(
                new Prenda("Oposite", "Chaqueta"),
                new Prenda("Chancho", "Pantalón")
        ));

        //Nueva instancia del objeto GuardaRopa
        GuardaRopa guardaRopa = new GuardaRopa();

        //Inserción de prendas de ropa en el GuardaRopa
        guardaRopa.guardarPrendas(listaPrendas);
        guardaRopa.guardarPrendas(listaPrendas1);

        //Método que muestra las prendas guardadas
        guardaRopa.mostrarPrendas();

        System.out.println();

        //Método que devuelve las prendas de ropa guardadas en un identificador específico
        int identificador = 1;
        System.out.println("Prendas guardadas en el identificador " + identificador + ": " + "\n"
                + guardaRopa.devolverPrendas(identificador));
    }
}
