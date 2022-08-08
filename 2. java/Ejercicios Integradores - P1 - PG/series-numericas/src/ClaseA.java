public class ClaseA extends Proptotipo{
    private Integer valor = 0;

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public Integer valorSiguiente() {
        setValor(valor+2);
        return valor;
    }

    @Override
    public void reiniciarSerie() {
        setValor(0);
    }

    @Override
    public void establecerValorIniciar(Integer inicial) {
        setValor(inicial);
    }
}
