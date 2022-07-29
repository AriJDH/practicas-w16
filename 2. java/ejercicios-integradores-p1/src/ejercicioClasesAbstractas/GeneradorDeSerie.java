package ejercicioClasesAbstractas;

public abstract class GeneradorDeSerie <T extends Number> {

    protected T valorInicial;
    protected T saltoPorValor;
    protected T siguienteValorEnSerie;

    public GeneradorDeSerie(T siguienteValorInicial, T startingNumber) {
        valorInicial = startingNumber;
        saltoPorValor = siguienteValorInicial;
        siguienteValorEnSerie = startingNumber;
    }

    public abstract T siguienteValor();

    public void reiniciar() {
        siguienteValorEnSerie = valorInicial;
    }

    public void establecerValorInicial(T unValor){
        siguienteValorEnSerie = unValor;
        valorInicial = unValor;
    }

}
