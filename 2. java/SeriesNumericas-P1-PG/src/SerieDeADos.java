public class SerieDeADos extends Prototipo{
    private int valor;

    @Override
    int proximoValorDeLaSerie() {
       return valor + 2;
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
