package ClasesAbstractasEInterfaces.Ejercicio2;

import poo_p2_vivo.Producto;

public class Main {
    public static void main(String[] args) {

        Documento d = new Curriculum();
        Documento.imprimirDocumento(d);

        d = new LibroPDF();
        Documento.imprimirDocumento(d);

        d = new Informes();
        Documento.imprimirDocumento(d);
    }
}
