package bootcamp.series;

public class SerieTres extends Prototipo{

    public Number valorInicial;
    public Number valorFinal;


    @Override
    public void valorSiguiente() {
        Number siguiente = this.valorFinal.intValue()+3;
        this.valorFinal = siguiente;
        System.out.println(siguiente);
    }

    @Override
    public void reiniciarSerie() {
        this.valorFinal = valorInicial;
    }

    @Override
    public void establecerSerie(Number valorInicial) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorInicial;
    }
}
