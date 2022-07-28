package ClasesAbstractas_Interfaces.Ejercicio2;

public interface Imprimible<T> {
    default void imprimir(T obj) {
        System.out.println(obj.toString());
    }
}
