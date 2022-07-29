package clasesAbstractasEInterfacesVivo.ejercicioDos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LibroPdf libro = new LibroPdf(523,"John Katzenbach","El psicoanalista","Suspenso");
        System.out.println("-----Libro pdf---------");
        libro.Imprimir();
        System.out.println("------Informe----------");
        Informe informe = new Informe(36,2160,"Thomas H.Zurbechen","Marcia J.Rieke");
        informe.Imprimir();

        List<String> habilidades = new ArrayList<String>();
        habilidades.add("HTML");
        habilidades.add("CSS");
        habilidades.add("Java");
        habilidades.add("Mysql");

        System.out.println("------Curriculum--------");
        Curriculum curriculum = new Curriculum("Susana","Hernandez",55555555,"susanah@email.com","Ciudad de Mexico",habilidades);
        curriculum.Imprimir();

    }
}
