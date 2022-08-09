package estructDinamicas;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();

        System.out.println("Numero de Elementos: " + arrayList.size());
        arrayList.add("red");
        arrayList.add("blue");
        arrayList.add("yellow");
        arrayList.add("green");

        System.out.println("Numero de Elementos: " + arrayList.size());
    }
}
