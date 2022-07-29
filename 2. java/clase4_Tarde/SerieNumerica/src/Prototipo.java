import java.util.List;

public abstract class Prototipo {
    protected List<Integer> numeros;
    public abstract void siguienteNumero();
    public abstract void reiniciarSerie();
    public abstract void iniciarSerie(int x);

    public Prototipo() {
    }
}
