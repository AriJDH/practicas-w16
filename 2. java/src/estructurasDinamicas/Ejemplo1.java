package estructurasDinamicas;

import java.util.ArrayList;

public class Ejemplo1 {

    public static void main(String[] args)
    {
        ArrayList<String> arrayList = new ArrayList<String>();

        System.out.println("Tamaño del array: " + arrayList.size());

        arrayList.add("blue");
        arrayList.add("red");
        arrayList.add("green");
        arrayList.add("yellow");

        System.out.println("Tamaño del array: " + arrayList.size());
        System.out.println("elemento nro 0: " + arrayList.get(0));

        arrayList.remove(3);

        System.out.println("contenido de la lista: ");
        for(String elemento : arrayList)
        {
            System.out.println(elemento);
        }

        //for (int i = 0; i < arrayList.size(); i++) {
        //    System.out.println(arrayList.get(i));
        //}

        if (arrayList.contains("blue"))
        {
            System.out.println("La lista contiene el elemento 'blue'");
        }

        arrayList.set(2, "pink");


    }
}
