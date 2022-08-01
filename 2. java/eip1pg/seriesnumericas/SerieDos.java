package eip1pg.seriesnumericas;

public class SerieDos<N extends Number> extends Prototipo{

    public SerieDos(N valorInicial, N patron) {
        super(valorInicial, patron);
    }

    @Override
    public int siguienteValor() {
        super.setValorInicial((Integer) super.getValorInicial() + (Integer) super.getPatron());
        return (int) super.getValorInicial();
    }

    @Override
    public void reiniciarSerie() {
        super.setValorInicial(0);
    }
}
