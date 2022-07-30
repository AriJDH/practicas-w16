package SeriesNumericas;

public class SerieN extends SerieNumerica{
    private Integer N;

    public SerieN(Integer valInicial) {
        super(valInicial);
        this.N = 1;
    }

    public SerieN(Integer valInicial, Integer n) {
        super(valInicial);
        N = n;
    }

    @Override
    public void sigVal() {
        this.setValActual(this.getValActual()+this.N);
    }
}
