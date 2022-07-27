package estructurasDinamicas;

import java.util.LinkedList;

public class Ejemplo2 {
    public static void print(LinkedList<String> lista) {
        for (String elemento: lista){
            System.out.print(elemento+"--");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList<String> lista1=new LinkedList<String>();
        lista1.add("Talleres");
        lista1.add("Velez");
        lista1.add("Colo Colo");
        lista1.add("Nacional");
        print(lista1);

        lista1.add(1,"Lanus");
        print(lista1);

        lista1.remove("Velez");
        print(lista1);
    }
}
