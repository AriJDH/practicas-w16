package Documentos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> habilidades= new ArrayList<>();
        habilidades.add("Escribir");
        habilidades.add("Leer");

        Curriculums curriculums= new Curriculums("Ana Maria",habilidades);
        curriculums.imprimible();

        Informe informe= new Informe("Informe 01",36,"Ana Maria","Franklin");
        informe.imprimible();

        LibrosPdf librosPdf = new LibrosPdf(36,"Ana Maria","Sueño","Comedia");
        librosPdf.imprimible();

    }

}
