package poo.ejercicioSeriesNumericasV2;

public abstract class PrototipoV2 {

    private int currentValue = 0;

    private int startValue;

    Integer valorSiguiente() {
        return currentValue += getSerie();
    }

    Integer reiniciarSerie() {
        return this.currentValue = startValue;
    }

    void setValorInicial(Integer valorInicial) {
        this.startValue = valorInicial;
        this.currentValue = valorInicial;
    }

    abstract Integer getSerie();


}
