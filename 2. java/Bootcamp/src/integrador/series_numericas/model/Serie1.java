package integrador.series_numericas.model;

public class Serie1 extends Serie{

    public Serie1() {
        super(3, 2);
    }

    @Override
    public void reiniciar() {
        this.valorInicial = 3;
    }
}
