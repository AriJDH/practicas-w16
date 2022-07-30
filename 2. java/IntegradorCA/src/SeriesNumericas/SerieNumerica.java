package SeriesNumericas;

public abstract class SerieNumerica {
    private Integer valActual;
    private Integer valInicial;

    public SerieNumerica() {
        this.valInicial = 0;
        this.valActual = 0;
    }
    public SerieNumerica(Integer valInicial) {
        this.valInicial = valInicial;
        this.valActual = valInicial;
    }

    public Integer getValActual() {
        return valActual;
    }

    public Integer getValInicial() {
        return valInicial;
    }

    protected void setValActual(Integer valActual) {
        this.valActual = valActual;
    }

    public void setValInicial(Integer valInicial) {
        this.valInicial = valInicial;
    }

    public void reiniciar(){
        this.valActual = valInicial;
    }

    public abstract void sigVal();

}
