package ejercico2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Responsable");
        habilidades.add("Puntual");
        Curriculum cv = new Curriculum("Jorge","Rodriguez","jr@gmail.com",habilidades);

        PrintCurriculum printCurriculum = new PrintCurriculum();
        printCurriculum.imprimirDocumento(cv);
    }
}
