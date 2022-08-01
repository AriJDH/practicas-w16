import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Country arg = new Country("Argentina", "America");
        Country nz =  new Country("Nueva Zelanda", "Oceania");

        List<Country> paises = new ArrayList<>(Arrays.asList(arg,nz));

        //paises.forEach((e) -> System.out.println(e));

        //paises.forEach(System.out::println); // Metodo de referencia, no se puede concatenar mas texto

        paises // convertir array a stream para poder operar
                .stream()
                .forEach((p) -> System.out.println("p = " + p));


    }
}
