package estructurasDinamicas;

import java.util.LinkedList;

public class Ejemplo2 {

    public static void imprimir(LinkedList<String> lista) {
        for (String elem : lista)
            System.out.print(elem + "-");
        System.out.println();
    }

    public static void main(String[] args) {

        LinkedList<String> lista1 = new LinkedList<>();
        lista1.add("Talleres");
        lista1.add("Velez");
        lista1.add("Boca");
        lista1.add("Nacional");
        lista1.add("San Lorenzo");
        imprimir(lista1);

        lista1.add(1, "River");
        imprimir(lista1);

        lista1.remove(0);
        imprimir(lista1);
    }
}
