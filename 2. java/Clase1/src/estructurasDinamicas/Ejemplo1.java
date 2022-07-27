package estructurasDinamicas;

import java.util.ArrayList;

public class Ejemplo1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList= new ArrayList<String>();
        System.out.println("nro de elementos : "+ arrayList.size());
        arrayList.add("red");
        arrayList.add("blue");
        arrayList.add("yellow");
        arrayList.add("green");
        for (String color: arrayList) {
            System.out.println(color);
        }
        if (arrayList.contains("yellow")){
            System.out.println("el amarillo existe");
        }
        arrayList.remove(2);
        arrayList.set(1,"yellow");
        for (String color: arrayList) {
            System.out.println(color);
        }
    }
}
