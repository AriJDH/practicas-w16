package seriesNumericas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SerieNumerica serie = new SerieNumerica();
        System.out.println("Ingrese 1,2 o 3 para iniciar la serie");
        Scanner escaner = new Scanner(System.in);
        int numInicio = escaner.nextInt();
        serie.valorInicial(numInicio);

        String opcion = "N";
        do{
            System.out.println(serie.valorSiguiente());
            System.out.println("Quiere continuar presione Y para si, N para no");
            opcion = escaner.next();
        }while(opcion.equals("Y"));
    }
}
