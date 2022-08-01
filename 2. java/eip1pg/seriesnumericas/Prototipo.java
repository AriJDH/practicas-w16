package eip1pg.seriesnumericas;

public abstract class Prototipo<N extends Number> {
    private N valorInicial;
    private N patron;

    public N getValorInicial() {
        return this.valorInicial;
    }

    public void setValorInicial(N valorInicial) {
        this.valorInicial = valorInicial;
    }

    public N getPatron() {
        return this.patron;
    }

    public void setPatron(N patron) {
        this.patron = patron;
    }

    public Prototipo(N valorInicial, N patron) {
        this.valorInicial = valorInicial;
        this.patron = patron;
    }

    public abstract int siguienteValor();
    public abstract void reiniciarSerie();


}
