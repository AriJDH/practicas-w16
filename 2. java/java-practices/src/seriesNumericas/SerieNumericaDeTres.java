package seriesNumericas;

public class SerieNumericaDeTres<N extends Number> extends Prototipo {

    public SerieNumericaDeTres(N valorInicial) {
        super(valorInicial);
    }

    @Override
    public N siguiente() {
        if (this.valorActual instanceof Integer) {
            this.valorActual = (Integer) this.valorActual + Integer.valueOf(3);
        } else if (this.valorActual instanceof Double) {
            this.valorActual = (Double) this.valorActual + Double.valueOf(3);
        } else if (this.valorActual instanceof Float) {
            this.valorActual = (Float) this.valorActual + Float.valueOf(3);
        } else if (this.valorActual instanceof Long) {
            this.valorActual = (Long) this.valorActual + Long.valueOf(3);
        }

        return (N) this.valorActual;
    }
}