package Ejercicio2;

public class Impresion {
    public static void main(String[] args) {
        Documento curriculum = new Curriculum("Pedro","Picapiedra","Cantar, Charlar, Dormir");
        System.out.println(Documento.imprimirDocumento(curriculum));

        Documento informe = new Informe("Lorem ipsum",10,"Pedro picapiedra","Mailen");
        System.out.println(Documento.imprimirDocumento(informe));

        Documento pdf = new LibroPDF("Lorem ipsum",2,"Autor","Terror");
        System.out.println(Documento.imprimirDocumento(pdf));
    }
}
