package ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Imprimible curr = new Curriculum("Juan","1234","juan@juan.com",new ArrayList<>());
        Imprimible libroPdft = new LibroPdf(100,"Shakespeare","Romeo y julieta","terror");
        Imprimible informe = new Informes("Hola",45,"juan","Rodrigo");


        Imprimible.imprimirObjeto(curr);
        Imprimible.imprimirObjeto(libroPdft);
        Imprimible.imprimirObjeto(informe);

    }
}
