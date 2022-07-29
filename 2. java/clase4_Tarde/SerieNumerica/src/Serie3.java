import java.util.ArrayList;

public class Serie3 extends Prototipo{
    public Serie3() {
        super();
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
    public void iniciarSerie(int x) {
        numeros.add(x);
    }
}
