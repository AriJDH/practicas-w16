public class Prototipo<T> {
    private final int serie;
    private T valueInicial ;
    private int secuencia;

    public Prototipo(int serie, T valueInicial, int secuencia) {
        this.serie = serie;
        this.valueInicial = valueInicial;
        this.secuencia = secuencia;
    }

    public int getSerie() {
        return serie;
    }

    public T getValueInicial() {
        return valueInicial;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setValueInicial(T valueInicial) {
        this.valueInicial = valueInicial;
    }


    public void reiniciarSerie(){
        this.secuencia = (int) this.valueInicial;
        System.out.println("Se inicia la secuencia con el valor inicial: " + this.secuencia);
    }

    public void valorSiguienteSerie(){
        int sec;

        sec = this.secuencia + this.serie;

        this.secuencia = sec;
        System.out.println(sec);
    }

    public void valorInicialSerie(T valorInicial){
        this.setValueInicial(valorInicial);
    }

}
