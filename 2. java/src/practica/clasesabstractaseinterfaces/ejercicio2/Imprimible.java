package practica.clasesabstractaseinterfaces.ejercicio2;

public interface Imprimible {
    default void imprimir() {
        System.out.println(this);
    }
}
