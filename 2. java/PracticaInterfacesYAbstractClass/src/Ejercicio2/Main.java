package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> habilidades = new ArrayList<>();
        habilidades.add("Comer");
        habilidades.add("Dormir");
        habilidades.add("Trabajar");

        List<Imprimible> documentos = new ArrayList<>();
        documentos.add(new Curriculum("German", 30, habilidades));
        documentos.add(new PDF("Alguien", 100, "Un PDF", "PDFs"));
        documentos.add(new Informe("Otro", 30, "Aca va todo el informe", "Nadie"));

        for (Imprimible i: documentos) {
            i.imprimir();
        }
    }
}
