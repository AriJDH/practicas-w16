package seriesNumericas;

public abstract class Prototipo {

    Integer numeroSerie=0;

    public abstract Integer valorSiguiente();

    public abstract void reiniciar();

    public abstract Integer valorInicial(Integer numero);
}
