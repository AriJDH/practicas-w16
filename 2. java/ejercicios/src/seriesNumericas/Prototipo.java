package seriesNumericas;

public abstract class Prototipo<T> {

    private T inicial;
    private T actual;

    public Prototipo(T inicial) {
        this.inicial = inicial;
        this.actual = inicial;
    }

    abstract T siguienteValor();

    public void reiniciarSerie() {
        this.actual = this.inicial;
    }

    public void valorInicial(T obj) {
        this.inicial = obj;
    }

    public T getInicial() {
        return inicial;
    }

    public void setInicial(T inicial) {
        this.inicial = inicial;
    }

    public T getActual() {
        return actual;
    }

    public void setActual(T actual) {
        this.actual = actual;
    }
}
