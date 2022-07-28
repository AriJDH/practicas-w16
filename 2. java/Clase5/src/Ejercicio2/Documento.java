package Ejercicio2;

public interface Documento {

    public String infoDocumento();

    static String imprimirDocumento(Documento docu){
        return docu.infoDocumento();
    }
}
