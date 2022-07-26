package estructuraDinamica;

import java.util.*;

public class Ejemplo {
    public static void main(String[] args)
    {
        lista();
        listaEnlazada();
        set();
        map();
    }
    public static void lista() {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Nro. elementos: " + arrayList.size());

        arrayList.add("Red");
        arrayList.add("Blue");
        arrayList.add("Yellow");
        arrayList.add("Green");
        for (int i = 0; i < arrayList.size(); i++)
            System.out.println("Elemnto en la posición " + i + " " + arrayList.get(i));

        for (String color : arrayList)
            System.out.println(color);

        if (arrayList.contains("white"))
            System.out.println("El blanco está en esta lista");

    }
    public  static void listaEnlazada(){
        LinkedList<String> lstEnlazada = new LinkedList<String>();
        lstEnlazada.add("Talleres");
        lstEnlazada.add("Velez");
        lstEnlazada.add("Colo Colo");
        lstEnlazada.add("Nacional");
        lstEnlazada.add("San Lorenzo");
        imprimir(lstEnlazada);
        lstEnlazada.add(1, "Lanus");
        imprimir(lstEnlazada);
        lstEnlazada.remove(1);
        imprimir(lstEnlazada);
    }
    public static void imprimir(LinkedList<String> lstEnlazada){
        for (String enlazada: lstEnlazada)
            System.out.print(enlazada+ "-");
        System.out.println();
    }
    public static void set(){
        Set<String> hs = new HashSet<>();
        hs.add("Argentina");
        hs.add("Colombia");
        hs.add("Chile");
        hs.add("México");
        hs.add("Uruguay");

        System.out.println(hs);
    }
    public static void map(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(100,"Juan Peréz");
        map.put(101,"Martin Marquez");
        map.put(102,"Ariel Jaime");
        map.put(103,"Marco Avila");
        map.put(104,"Carlos Arroyo");
        System.out.println("Los elementos del dicc son: "+map);
        System.out.println("Todas las entradas con entrySet: ");
        System.out.println(map.entrySet());
        System.out.println("Todas las entradas una a una: ");
        for(Map.Entry pareja : map.entrySet())
        {
            System.out.println(pareja);
        }
        System.out.println("Codigo\t Nombre\n------\t-------");
        for(Map.Entry pareja : map.entrySet())
        {
            System.out.println(pareja.getKey()+"\t\t"+pareja.getValue());
        }

    }
}
