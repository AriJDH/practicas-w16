import java.util.ArrayList;
import java.util.List;

public class SerieTres extends Prototipo {

    public SerieTres() {
        numeros = new ArrayList<>();
    }

    @Override
    public void siguienteNumero() {
        numeros.add(numeros.get(numeros.size()-1)+3);
        System.out.println("El siguiente numero es: "+ numeros.get(numeros.size()-1));
    }

    @Override
    public void reiniciarSerie() {
        numeros.clear();
    }

    @Override
    public void iniciarSerie(int numero) {
        numeros.add(numero);
    }
}
