package integrador.series_numericas.model;

public abstract class Serie {
    protected Integer valorInicial;
    protected Integer incremento;

    public Serie(int valorInicial, int incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
    }

    public Integer siguiente(){
        int valorAuxiliar = this.valorInicial;
        this.valorInicial += this.incremento;
        return valorAuxiliar;

    }

    public void reiniciar(){
        this.valorInicial = 0;
    }

    public void setValorInicial(Integer valor){
        this.valorInicial = valor;
    }
}
