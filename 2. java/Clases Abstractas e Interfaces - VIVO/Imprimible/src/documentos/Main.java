package documentos;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<String>listaHabilidades = new ArrayList<String>();

        listaHabilidades.add("Inglés avanzado");
        listaHabilidades.add("Java");

        Curriculums curriculums= new Curriculums("Erika","Altenburger", "34466546", 31, listaHabilidades);
        Informes informes = new Informes("Texto del informe", 100, "Jessica", "Vanessa");
        Librospdf librospdf = new Librospdf(1345, "Sofia", "La tumba de las luciernagas", "Tragedia");

        curriculums.realizarImpresion();
        informes.realizarImpresion();
        librospdf.realizarImpresion();

    }

}
