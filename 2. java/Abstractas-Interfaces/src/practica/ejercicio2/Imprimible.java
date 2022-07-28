package practica.ejercicio2;

public interface Imprimible {

    void imprimir();

    public static void imprimirEstatico(Imprimible documento) {
        documento.imprimir();
    }
}
