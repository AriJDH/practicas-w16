package EjerciciosIntegradoresP1.ClasesAbstractas.actors;

public abstract class Prototype< T extends Number > {
    
    protected T base;
    protected T element;

    @SuppressWarnings("unchecked")
    public T nextElement(){
        T nextElement = element;

        if(element instanceof Integer){
            element =  (T)(Integer)(base.intValue() + element.intValue());
        } else if(element instanceof Long){
            element =  (T)(Long)(base.longValue() + element.longValue());
        } else if(element instanceof Float){
            element =  (T)(Float)(base.floatValue() + element.floatValue());
        } else if(element instanceof Double){
            element = (T)(Double)(base.doubleValue() + element.doubleValue());
        }
        
        return nextElement;
    }

    public void reset(){
        element = base;
    }

    public void setBase(T base) {
        this.base = base;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
