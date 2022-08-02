package integrador.series_numericas.model;

public class Serie2 extends Serie{

    public Serie2() {
        super(2,2);
    }

    @Override
    public void reiniciar() {
        this.valorInicial = 2;
    }
}
