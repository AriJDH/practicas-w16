package estructsDinamicas;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("red");
        arrayList.add("blue");
        arrayList.add("yellow");
        arrayList.add("green");

        // Ver foreach pero no usarlo
        System.out.println("Contenido de la lista");
        for(int i = 0; i<arrayList.size();i++){
            System.out.println("Elemento en la posición " + i + ": " + arrayList.get(i));
        }

        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("white");
        System.out.println("Nro de elementos: " + arrayList.size());

        System.out.println("Contenido de la lista");
        for(int i = 0; i<arrayList.size();i++){
            System.out.println("Elemento en la posición " + i + ": " + arrayList.get(i));
        }

        if(arrayList.contains("red")){
            System.out.println("El rojo está en la lista.");
        }
        arrayList.remove(2);

        for(String color: arrayList){
            System.out.println(color);
        }

        //SET - elegís el valor y la posicion
        arrayList.set(2,"Grey");
        for(String color: arrayList){
            System.out.println(color);
        }
    }
}
