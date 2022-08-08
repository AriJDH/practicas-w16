package clases.abstractas.interfaces.Ejercicio2;

public interface Imprimible {

    public default void imprimir(String contenido) {
        System.out.println(contenido);
    }
}
