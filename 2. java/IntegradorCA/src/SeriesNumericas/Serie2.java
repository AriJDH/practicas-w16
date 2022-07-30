package SeriesNumericas;

public class Serie2 extends SerieNumerica {

    public Serie2(Integer valInicial) {
        super(valInicial);
    }

    @Override
    public void sigVal() {
        this.setValActual(this.getValActual()+2);
    }
}
