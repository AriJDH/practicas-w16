package SeriesNumericas;

public class Serie3 extends SerieNumerica{

    public Serie3(Integer valInicial) {
        super(valInicial);
    }

    @Override
    public void sigVal() {
        this.setValActual(this.getValActual()+3);
    }
}
