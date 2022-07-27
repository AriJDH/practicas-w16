package estructsDinamicas;

import java.util.LinkedList;

public class Ejemplo2 {

    public static void imprimir(LinkedList<String> lista){
        for(int i = 0; i<lista.size();i++){
            String elemento = lista.get(i);
            System.out.print(elemento + "-");
        }
    }

    public static void main(String[] args) {

    }
}
