package estructurasDinamicas;

import java.util.LinkedList;

public class Ejemplo2 {

    public static void imprimir(LinkedList<String> lista){
        for (String item: lista)
            System.out.print(item + " : ");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> listaEquipos = new LinkedList<String>();
        listaEquipos.add("Talleres");
        listaEquipos.add("Colo Colo");
        listaEquipos.add("Peñarol");
        listaEquipos.add("Nacional");
        listaEquipos.add("San Lorenzo");
        listaEquipos.add("Velez");
        listaEquipos.add("Lanus");

        imprimir(listaEquipos);
        listaEquipos.add(1, "Albion");
        imprimir(listaEquipos);
        listaEquipos.remove();
        imprimir(listaEquipos);
        listaEquipos.remove("Nacional");
        imprimir(listaEquipos);

    }

}
