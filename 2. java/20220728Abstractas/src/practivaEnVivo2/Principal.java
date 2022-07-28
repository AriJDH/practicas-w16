package practivaEnVivo2;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Persona p = new Persona("Daniel", "Condori");
        List<String> c = new ArrayList<>();
        c.add("Alto");
        c.add("Atleta");
        Curriculum curr = new Curriculum(p,c);
        curr.imprimirDocumento();
        Libro l = new Libro();
        l.imprimirDocumento();
        Informes inf = new Informes();
        inf.imprimirDocumento();
    }

    public static void imprimir(Object e){

    }
}
