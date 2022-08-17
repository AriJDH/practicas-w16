import java.util.ArrayList;

public class SerieDos extends Prototipo {

    public SerieDos() {
        numeros = new ArrayList<>();
    }

    @Override
    public void siguienteNumero() {
        numeros.add(numeros.get(numeros.size()-1)+2);
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
