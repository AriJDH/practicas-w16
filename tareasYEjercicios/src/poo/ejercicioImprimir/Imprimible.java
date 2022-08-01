package poo.ejercicioImprimir;

public interface Imprimible {

    static void imprimirImprimible(Imprimible i) {
        i.imprimir();
    }

    void imprimir();

}
