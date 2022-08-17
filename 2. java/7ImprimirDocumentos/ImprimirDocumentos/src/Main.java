package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> habilidades= new ArrayList<>();
        habilidades.add("Escribir");
        habilidades.add("Leer");

        Curriculums curriculums= new Curriculums("Yenny",habilidades);
        curriculums.imprimible();

        Informes informes= new Informes("Informe1",120,"Yenny","Kevin");
        informes.imprimible();

        LibrosPDF librosPDF = new LibrosPDF(20,"Yenny","Titulo1","Suspenso");
        librosPDF.imprimible();


    }
}
