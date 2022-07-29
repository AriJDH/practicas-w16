package ClasesAbstractasEInterfaces.Ejercicio2;

import javax.print.Doc;

public class Informes implements Documento {
    @Override
    public String obtenerDocumentoData() {
        return "Soy un Informe!";
    }
}
