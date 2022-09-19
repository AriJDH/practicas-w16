package AbstractClasses;

public abstract class Prototipo {

    private Integer valorInicial;
    private Integer valorSiguiente;
    private Integer valorFijo;

    public Prototipo(Integer valorInicial, Integer valorSiguiente, Integer valorFijo) {
        this.valorInicial = valorInicial;
        this.valorSiguiente = valorSiguiente;
        this.valorFijo = valorFijo;
    }

    public Integer getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Integer getValorSiguiente() {
        return valorSiguiente;
    }

    public void setValorSiguiente(Integer valorSiguiente) {
        this.valorSiguiente = valorSiguiente;
    }

    public Integer getValorFijo() {
        return valorFijo;
    }

    public void setValorFijo(Integer valorFijo) {
        this.valorFijo = valorFijo;
    }

    //Métodos de la clase
    public Integer addValor(){
        setValorSiguiente(getValorInicial() + getValorSiguiente());
        setValorInicial(getValorFijo());
        return getValorSiguiente();
    }

    public String resetearSerie(Integer number){
        setValorInicial(number);
        setValorSiguiente(getValorFijo());
        return "Se ha reseteado la serie";
    }

    public Integer setearValorInicial(){
        setValorInicial(getValorInicial());
        return getValorInicial();
    }
}
