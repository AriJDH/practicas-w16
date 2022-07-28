package ejercicio2;

public interface Imprimible {
    static void imprimirObjeto(Imprimible objeto){

        objeto.imprimir();
    }
    void imprimir();
}
