package Vector;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void imprimir(ArrayList e, int[][] n){
        for (int i = 0; i < n.length; i ++){
            System.out.println("Temperatura " + ((i%2==0)? "Minima":"Maxima") );
            for ( int j = 0; j<n[0].length; j++){
                System.out.println("Ciudad: " + e.get(j));
                System.out.println("Temperatura: " + n[i][j]);
            }
        }
    }

    public static void getMinima(ArrayList e, int[][] n){
        int minima = n[0][0];
        int indice = 0;
        for (int i = 0; i < n[0].length; i ++){
            if (n[0][i] < minima){
                minima = n[0][i];
                indice = i;
            }
        }
        System.out.println("La minima se registro en " + e.get(indice) + " con " + minima + " grados");
    }

    public static void getMaxima(ArrayList e, int[][] n){
        int maxima = n[1][0];
        int indice = 0;
        for (int i = 0; i < n[1].length; i ++){
            if (n[1][i] > maxima){
                maxima = n[1][i];
                indice = i;
            }
        }
        System.out.println("La maxima se registro en " + e.get(indice) + " con " + maxima + " grados");
    }


    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList<String>();
        ciudades.add("Londres");
        ciudades.add("Madrid");
        ciudades.add("NY");

        int temperaturas[][] = new int[2][ciudades.size()];
        for(int i = 0; i < temperaturas.length; i++){
            for(int j = 0; j < temperaturas[0].length; j++){
                System.out.print("Ingresa temperatura " + ((i%2==0)? "Minima":"Maxima") + " de " + ciudades.get(j) + ": ");
                Scanner teclado = new Scanner(System.in);
                int valor = teclado.nextInt();
                temperaturas[i][j] = valor;
            }
        }

        //imprimir(ciudades, temperaturas);
        System.out.println("Llamo a minima");
        getMinima(ciudades, temperaturas);
        System.out.println("Llamo a maxima");
        getMaxima(ciudades, temperaturas);


    }
}
