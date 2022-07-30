package SeriesNumericas;

public class Fibonacci extends SerieNumerica{

    private Integer valorPrevio;

    public Fibonacci(Integer valInicial) {
        super(valInicial);
        this.valorPrevio = this.getValActual()-1;
    }

    @Override
    public void sigVal() {
        Integer aux = this.getValActual();
        this.setValActual(this.valorPrevio+this.getValActual());
        this.valorPrevio = aux;
    }
}
