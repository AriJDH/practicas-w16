package seriesNumericas;

public class SerieDos extends Prototipo<Integer>{

    public SerieDos(Integer i) {
        super(i);
    }
    @Override
    Integer siguienteValor() {
        Integer siguiente = this.getActual() + 2;
        this.setActual(siguiente);
        return siguiente;
    }

}
