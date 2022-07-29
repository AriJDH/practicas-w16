package ClasesAbstractas.actors;

public abstract class Prototype< T extends Number > {
    
    protected T base;
    protected T element;

    public T nextElement(){
        T nextElement = element;
        element = (T)(Double)(base.doubleValue() + element.doubleValue());

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
