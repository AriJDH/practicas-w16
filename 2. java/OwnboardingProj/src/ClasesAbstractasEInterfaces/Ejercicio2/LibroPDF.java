package ClasesAbstractasEInterfaces.Ejercicio2;

public class LibroPDF implements Documento {
    @Override
    public String obtenerDocumentoData() {
        return "Soy un Libro PDF!";
    }
}
