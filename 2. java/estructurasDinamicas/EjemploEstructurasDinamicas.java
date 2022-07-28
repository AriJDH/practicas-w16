package estructurasDinamicas;

import java.util.ArrayList;

public class EjemploEstructurasDinamicas {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("Nro de elementos:" + arrayList.size());

        arrayList.add("red");
        arrayList.add("blue");
        arrayList.add("yellow");
        arrayList.add("green");

        System.out.println("Contenido de la lista: ");
        System.out.println("Nro de elementos" + arrayList.size());
        arrayList.add("white");
        System.out.println("Nro de elementos" + arrayList.size());
        System.out.println("Elemento en la posición 0" + arrayList.get(0));
        System.out.println("Elemento en la posición 3" + arrayList.get(3));


    }
}
