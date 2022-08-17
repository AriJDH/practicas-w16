import java.util.List;

public abstract class Prototipo {
    List<Integer> numeros;

    public abstract void siguienteNumero();
    public abstract void reiniciarSerie();
    public abstract void iniciarSerie(int numero);

    public Prototipo() {
    }
}
