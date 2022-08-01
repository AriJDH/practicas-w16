import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Limay", "Jean dad");
        Prenda prenda2 = new Prenda("Archetype", "Conjunto Macebo");

        List<Prenda> prendasAGuardar = new ArrayList<>();
        prendasAGuardar.add(prenda1);
        prendasAGuardar.add(prenda2);

        Guardaropas guardaropas = new Guardaropas();
        Integer clave = guardaropas.guardarPrendas(prendasAGuardar);
        guardaropas.mostrarPrendas();
    }
}
