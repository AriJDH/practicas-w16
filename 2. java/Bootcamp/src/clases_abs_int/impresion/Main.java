package clases_abs_int.impresion;

import clases_abs_int.impresion.interfaces.IImprimir;
import clases_abs_int.impresion.models.Curriculum;
import clases_abs_int.impresion.models.Informe;
import clases_abs_int.impresion.models.LibroPdf;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IImprimir> imprimibles = new ArrayList<>();
        imprimibles.add(new Curriculum("Pepe", "Pecas", new ArrayList<String>()));
        imprimibles.add(new LibroPdf(120, "José Hernandez", "Un título interesante", "Comedia"));
        imprimibles.add(new Informe("Prueba de texto de n caracteres", 400, "Pepe Lopez", "Roberto Juancho"));
        for(IImprimir i : imprimibles){
            i.imprimir();
        }
    }
}
