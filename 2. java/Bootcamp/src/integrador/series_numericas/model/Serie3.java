package integrador.series_numericas.model;

public class Serie3 extends Serie{

    public Serie3() {
        super(3, 3);
    }

    @Override
    public void reiniciar() {
        this.valorInicial = 3;
    }
}
