package ejercicioClasesAbstractas;


public class GeneradorDeSerieEntero extends GeneradorDeSerie<Integer> {

    public GeneradorDeSerieEntero(Integer siguienteValorInicial) {
        super(siguienteValorInicial, 0);
    }

    @Override
    public Integer siguienteValor() {
        siguienteValorEnSerie += saltoPorValor;
        return siguienteValorEnSerie;
    }

}
