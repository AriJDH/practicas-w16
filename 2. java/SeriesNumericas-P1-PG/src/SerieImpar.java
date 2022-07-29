public class SerieImpar extends Prototipo{
    private int valor;
    @Override
    int proximoValorDeLaSerie() {
        return valor + 2;
    }

    @Override
    void reiniciarSerie() {
        valor = 1;
    }

    @Override
    void establecerValorInicial(int valor) {
        this.valor = valor;
    }
}
