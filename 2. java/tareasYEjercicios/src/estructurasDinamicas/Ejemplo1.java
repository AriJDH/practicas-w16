package estructurasDinamicas;

import java.util.ArrayList;

public class Ejemplo1 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("red");
        arrayList.add("blue");
        arrayList.add("yellow");
        arrayList.add("green");

        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("white");

        System.out.println("Contenido de la lista: ");
        for (String color : arrayList) {
            System.out.println(color);
        }

        if (arrayList.contains("green")) {
            System.out.println("La lista de colores contiene el color verde");
        }
        
        arrayList.remove(0);
        arrayList.set(1, "violet");
        for (String color : arrayList) {
            System.out.println(color);
        }
    }
}
