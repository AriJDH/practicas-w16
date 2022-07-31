package Impresora;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        LibroPDF lotr = new LibroPDF("600","JJR Tolkien","The fellow Ship","Fantasia");
        Curriculum marcoPolo = new Curriculum("Marco","Polo","25", List.of("trabajador","responsable"));
        Informe informe = new Informe("500","700","Pepito","Romulo");

        marcoPolo.imprimir();
        informe.imprimir();
        lotr.imprimir();
    }
}
