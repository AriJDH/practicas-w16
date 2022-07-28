package practivaEnVivo2;

import java.util.List;

public class Documento implements Imprimir{
    Curriculum a1;
    Informes a2;
    Libro a3;


    public Documento (Persona a, List<> b){
        a1 = new Curriculum(a, b);
    }

    @Override
    public void imprimirDocumento() {

    }
}
