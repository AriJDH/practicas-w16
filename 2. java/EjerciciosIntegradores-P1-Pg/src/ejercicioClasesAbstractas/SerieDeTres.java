package ejercicioClasesAbstractas;

public class SerieDeTres<T extends Number> extends Prototipo {

    public SerieDeTres(Number valorInicial, Number conteoActual) {
        super(valorInicial, conteoActual);
    }

    @Override
    public T obtenerValorSiguiente() {
        if (conteoActual instanceof Integer ){
            conteoActual = (Integer)conteoActual +3;
            return (T)conteoActual;
        }
        if(conteoActual instanceof Float ){
            conteoActual = (Float)conteoActual +3f;
            return (T)conteoActual;
        }
        if(conteoActual instanceof Double ){
            conteoActual = (Double)conteoActual +3d;
            return (T)conteoActual;
        }
        return null;
    }

}
