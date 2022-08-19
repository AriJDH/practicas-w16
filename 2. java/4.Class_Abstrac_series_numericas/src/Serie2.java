public class Serie2 extends Prototipo{

    @Override
    public int valorSiguienteSerie() {
        valorInicial = valorInicial + 2;
        return valorInicial;
    }
}
