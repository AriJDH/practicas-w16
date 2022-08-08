package seriesNumericas;

public abstract class Prototipo<N extends Number> {
    protected N valorInicial;
    protected N valorActual;

    public Prototipo(N valorInicial){
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public N getValorInicial() {
        return this.valorInicial;
    }

    public void setValorInicial(N valorInicial) {
        this.valorInicial = valorInicial;
    }

    public N getValorActual() {
        return this.valorActual;
    }

    public void setValorActual(N valorActual) {
        this.valorActual = valorActual;
    }

    public abstract N siguiente();

    public void reiniciar(){
        this.valorActual = this.valorInicial;
    }
}
