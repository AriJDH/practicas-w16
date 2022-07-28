package absandint.ejercicio2;

public interface Documento<T> {

    public void print();

    static void toString(Documento d){
        d.print();
    }
}
