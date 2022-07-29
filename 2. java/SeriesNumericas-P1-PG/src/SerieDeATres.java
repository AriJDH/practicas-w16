public class SerieDeATres extends Prototipo{
    private int valor;

    @Override
    int proximoValorDeLaSerie() {
        return valor + 3;
    }

    @Override
    void reiniciarSerie() {
        valor = 0;
    }

    @Override
    void establecerValorInicial(int valor) {
        this.valor = valor;
    }
}
