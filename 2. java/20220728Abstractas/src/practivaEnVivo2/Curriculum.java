package practivaEnVivo2;

import java.util.List;

public class Curriculum implements Imprimir{

    private Persona per;
    List<String> lista;

    public Curriculum(Persona per, List<String> lista) {
        this.per = per;
        this.lista = lista;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Se imprimio el Curriculum");
    }
}
