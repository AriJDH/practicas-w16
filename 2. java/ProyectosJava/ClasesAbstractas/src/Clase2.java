public class Clase2 extends Prototipo{


    private int valorActual = 0;

    @Override
    public int devolverNum() {

        setValorActual(valorActual+2);

        return valorActual;
    }

    @Override
    public void reiniciarSerie() {

        setValorActual(0);

    }

    @Override
    public void valorInicial(Number valor) {

        setValorActual(valor.intValue());

    }


    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }
}
