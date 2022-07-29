package ejercicioClasesAbstractas;

public abstract class Prototipo <N extends Number>{
    protected N valorInicial;
    protected N conteoActual;

    public Prototipo(N valorInicial, N conteoActual) {
        this.valorInicial = valorInicial;
        this.conteoActual = conteoActual;
    }

    public abstract N obtenerValorSiguiente();

    public void reiniciarSerie(){
        conteoActual = valorInicial;
    }

    public void setValorInicial(N valorInicial) {
        this.valorInicial = valorInicial;
        this.conteoActual =  valorInicial;
    }
}
