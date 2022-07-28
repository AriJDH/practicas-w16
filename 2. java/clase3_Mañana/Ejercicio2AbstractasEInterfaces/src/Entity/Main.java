package Entity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Documento> documentos = new ArrayList<>();
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Social");
        habilidades.add("Serio");
        Curriculum curriculum = new Curriculum("Maximiliano","Nicoletta",15,"09389434",habilidades);
        Libro libro = new Libro("Maxi","Las noches y el dia","Romance",43);
        Informe informe = new Informe("Maxi 2","Pedro",23,"este es l texto");
        documentos.add(curriculum);
        documentos.add(libro);
        documentos.add(informe);
        for(Documento d : documentos){
            d.imprimir();
        }

    }
}
