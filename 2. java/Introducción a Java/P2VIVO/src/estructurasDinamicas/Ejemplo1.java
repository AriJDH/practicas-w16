package estructurasDinamicas;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();

        System.out.println("Nro. de elementos: " + arrayList.size());
        arrayList.add("Blue");
        arrayList.add("Red");
        arrayList.add("Yellow");
        arrayList.add("Green");
        System.out.println("Nro. de elementos " + arrayList.size());

        System.out.println("Elemento Nro. 2: " + arrayList.get(2));
        System.out.println("Elemento Nro. 0: " + arrayList.get(0));
        //System.out.println("Elemento Nro. 9: " + arrayList.get(9)); //Generara error de IndexOutOfBounds
    }
}


