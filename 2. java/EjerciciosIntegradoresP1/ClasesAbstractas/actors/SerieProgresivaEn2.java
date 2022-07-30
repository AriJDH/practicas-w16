package EjerciciosIntegradoresP1.ClasesAbstractas.actors;

public class SerieProgresivaEn2<T extends Number> extends Prototype<T> {
    
    @SuppressWarnings("unchecked")
    public SerieProgresivaEn2(T element) {
        super.setBase((T)(Double)2.0);
        super.setElement(element);
    }
}
