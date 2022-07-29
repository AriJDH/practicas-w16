package documentos;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Persona p = new Persona("Belen Lopez", "40389765", 24, "belen@gmail.com");
        Habilidad h1 = new Habilidad("Excel", 10);
        Habilidad h2 = new Habilidad("Word", 9);
        List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(h1);
        habilidades.add(h2);
        Documento c = new Curriculum(p,habilidades);
        Documento i = new Informe("Documento de protocolos en cabina y mantenimientos aeronauticos", 12, "Ivana Coronel", "Germán Costilla");
        Documento l = new LibroPDF(40, "Ivana Coronel", "Historia de un amor" , "Romance");

        c.imprimir();
        i.imprimir();
        l.imprimir();
    }
}
