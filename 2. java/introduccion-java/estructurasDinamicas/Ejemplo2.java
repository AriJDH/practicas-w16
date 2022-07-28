package estructurasDinamicas;

import java.util.LinkedList;

public class Ejemplo2
{
    public static void imprimir(LinkedList<String> lista) {
        for (String elemento : lista)
            System.out.print(elemento + " - ");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> lista1 = new LinkedList<String>();
        lista1.add("talleres");
        lista1.add("velez");
        lista1.add("colo colo");
        lista1.add("nacional");
        imprimir(lista1);

        lista1.add(1,"river");
        lista1.remove(2);
        imprimir(lista1);
        lista1.remove("colo colo");
        imprimir(lista1);
    }
}
