package ClasesAbstractasEInterfaces.Ejercicio2;

public interface Documento {

    static void imprimirDocumento(Documento e){
        System.out.println("Documento: " + e.obtenerDocumentoData());
    }

    public String obtenerDocumentoData();

}
