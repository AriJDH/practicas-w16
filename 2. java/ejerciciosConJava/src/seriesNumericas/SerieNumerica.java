package seriesNumericas;



public class SerieNumerica extends Prototipo {
    @Override
    public Integer valorSiguiente() {
        return numeroSerie+=2;
    }

    @Override
    public void reiniciar() {
        numeroSerie=0;
    }

    @Override
    public Integer valorInicial(Integer numero) {
        numeroSerie=numero;
        return numeroSerie;
    }
}
