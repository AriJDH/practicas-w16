public abstract class Prototipo {

    int valorInicial = 0;

    public int valorSiguienteSerie(){
        valorInicial = valorInicial + valorInicial;

        return valorInicial;
    }

    public void reiniciarSerie(){
        valorInicial = 0;
    }

    public void valorinicialSerie(int value){
        valorInicial = value;
    }

}
