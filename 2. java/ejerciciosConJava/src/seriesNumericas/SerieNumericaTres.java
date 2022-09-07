package seriesNumericas;

public class SerieNumericaTres extends Prototipo{

    Integer serie;
    @Override
    public Integer valorSiguiente() {
        return numeroSerie+=serie;
    }

    @Override
    public void reiniciar() {
        numeroSerie=0;
    }

    @Override
    public Integer valorInicial(Integer numero) {
        this.serie=numero;
        return serie;
    }
}
