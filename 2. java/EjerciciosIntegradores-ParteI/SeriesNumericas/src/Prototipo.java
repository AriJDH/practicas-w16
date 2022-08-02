public abstract class Prototipo {

    protected int valorInicial;

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Prototipo(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract int devolverNumero();

    public void reiniciarSerie() {
        this.valorInicial = 0;
    }

    public void establecerInicio(Double valor) {
        this.valorInicial = valor.intValue();
    }

}
