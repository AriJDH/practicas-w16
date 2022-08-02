package poo.ejercicioSeriesNumericas;

public class SerieTres extends Prototipo {

    private Integer inicio;
    private static final Integer SERIE = 3;

    public SerieTres() {
        this.inicio = 0;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    @Override
    Integer valorSiguiente() {
        return this.inicio += SERIE;
    }

    @Override
    Integer reiniciarSerie() {
        setInicio(SERIE);
        return this.inicio;
    }

    @Override
    Integer setValorInicial(Integer valorInicial) {
        return this.inicio = valorInicial;
    }

    @Override
    public String toString() {
        return "SerieDos{" +
                "valorDefault=" + inicio +
                "} " + super.toString();
    }
}
