package ejercicioClasesAbstractas;

public class SeriedeDos<T extends Number> extends Prototipo{

    public SeriedeDos(Number valorInicial, Number conteoActual) {
        super(valorInicial, conteoActual);
    }

    @Override
    public T obtenerValorSiguiente() {
        if (conteoActual instanceof Integer ){
            conteoActual = (Integer)conteoActual +2;
            return (T)conteoActual;
        }
        if(conteoActual instanceof Float ){
            conteoActual = (Float)conteoActual +2f;
            return (T)conteoActual;
        }
        if(conteoActual instanceof Double ){
            conteoActual = (Double)conteoActual +2f;
            return (T)conteoActual;
        }
        return null;
    }
}
