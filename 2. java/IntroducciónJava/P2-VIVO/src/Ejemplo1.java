import java.util.ArrayList;
//ARRAYLIST
public class Ejemplo1 {
    public static void main(String[] args) {
        //instanciar la lista
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Número de elementos " + arrayList.size()); //objeto por referencia
        arrayList.add("blue");
        arrayList.add("green");
        arrayList.add("black");
        arrayList.add("red");

        System.out.println("Numeros de elementos " + arrayList.size());
        arrayList.add("grey");
        System.out.println("Numeros de elementos " + arrayList.size());
        System.out.println("Elemento en la posición 0 " + arrayList.get(0));
        System.out.println("Contenido de la Lista:");

        for (int i = 0; i < arrayList.size(); i++) { //no se usa length, usa size.
            System.out.println("Elemento en la posición: " + i +" " +  arrayList.get(i));
        }

        System.out.println("Esto es un for each en Java");
        for(String color: arrayList){
            System.out.println("Elemento en la posición: " + arrayList.indexOf(color) + ": "+ color);
        }

        if(arrayList.contains("blue")){
            System.out.println("El azul está en la lista, lo busqué con contains de arraylist");
        }
        else{
            System.out.println("El color no está en la lista");
        }

        System.out.println("Elimino un valor en arraylist" );
        System.out.println("Numeros de elementos " + arrayList.size());
        arrayList.remove("grey");
        System.out.println("Numeros de elementos " + arrayList.size());
        arrayList.remove(2);
        System.out.println("Numeros de elementos " + arrayList.size());

        System.out.println("Existe tambien el metodo set");
        arrayList.set(0, "pamela");
        for(String color: arrayList){
            System.out.println("Elemento en la posición: " + arrayList.indexOf(color) + ": "+ color);
        }
    }
}
