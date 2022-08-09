package estructDinamicas;

import java.util.LinkedList;

public class Ejemplo2 {

    public static void imprimir(LinkedList<String> lista){
        for (String elemento: lista)
            System.out.print(elemento + "-");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> lista1 = new LinkedList<String>();
        lista1.add("Talleres");
        lista1.add("Velez");
        lista1.add("Lolo Colo");
        lista1.add("Nacional");
        lista1.add("San Lorenzo");

        imprimir(lista1);
        lista1.add(1,"lamus");
        imprimir(lista1);

        lista1.remove("Nacional");
        imprimir(lista1);
    }
}
