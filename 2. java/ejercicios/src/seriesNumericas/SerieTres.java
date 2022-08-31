package seriesNumericas;

public class SerieTres extends Prototipo<Integer> {


    public SerieTres(Integer i) {
        super(i);
    }
    @Override
    Integer siguienteValor() {
        Integer siguiente = this.getActual() + 3;
        this.setActual(siguiente);
        return siguiente;
    }

}
