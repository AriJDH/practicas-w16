import java.util.LinkedList;

//LINKEDLIST
public class Ejemplo2 {

    public static void imprimir(LinkedList<String> lista) {
        //no se puede recorrer con un for comun sino son foreach
        for (String elemento : lista)
            System.out.println(elemento);
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<String> lista1 = new LinkedList<>();
        lista1.add("Colombia");
        lista1.add("Argentina");
        lista1.add("Uruguay");
        lista1.add("Paraguay");
        lista1.add("Brasil");
        lista1.add("Mexico");
        imprimir(lista1);
        lista1.remove(1);
        imprimir(lista1);
        lista1.remove("Paraguay");
        imprimir(lista1);

        //set


    }
}
