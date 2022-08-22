package seriesNumericas;

public class SerieNumericaDeDos<N extends Number> extends Prototipo {

    public SerieNumericaDeDos(N valorInicial) {
        super(valorInicial);
    }

    @Override
    public N siguiente() {
        if (this.valorActual instanceof Integer) {
            this.valorActual = (Integer) this.valorActual + Integer.valueOf(2);
        } else if (this.valorActual instanceof Double) {
            this.valorActual = (Double) this.valorActual + Double.valueOf(2);
        } else if (this.valorActual instanceof Float) {
            this.valorActual = (Float) this.valorActual + Float.valueOf(2);
        } else if (this.valorActual instanceof Long) {
            this.valorActual = (Long) this.valorActual + Long.valueOf(2);
        }

        return (N) this.valorActual;
    }
}
