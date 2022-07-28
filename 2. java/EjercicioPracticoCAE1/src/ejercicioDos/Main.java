package ejercicioDos;

import ejercicioDos.documentos.Curriculum;
import ejercicioDos.documentos.Informes;
import ejercicioDos.documentos.LibroPDF;
import ejercicioDos.interfaces.Imprimible;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Imprimible curr = new Curriculum("juan","123","123123","asdaw@asdw",new ArrayList());
        Imprimible libroPdf = new LibroPDF(300,"juan","Romeo y Julieta","Romance");
        Imprimible informe = new Informes(200,2,"juan","camilo");


        Imprimible.imprimirObjeto(curr);
        Imprimible.imprimirObjeto(libroPdf);
        Imprimible.imprimirObjeto(informe);
    }
}
