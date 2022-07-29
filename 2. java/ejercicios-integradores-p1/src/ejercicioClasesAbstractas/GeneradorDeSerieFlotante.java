package ejercicioClasesAbstractas;

public class GeneradorDeSerieFlotante extends GeneradorDeSerie<Float> {

    public GeneradorDeSerieFlotante(Float siguienteValorInicial) {
        super(siguienteValorInicial, (float) 0);
    }

    @Override
    public Float siguienteValor() {
        siguienteValorEnSerie += saltoPorValor;
        return siguienteValorEnSerie;
    }
}
