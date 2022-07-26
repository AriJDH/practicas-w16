import  java.util.ArrayList;
import java.util.Scanner;

public class Temperaturas {

    public static void main(String[] args) {
        System.out.println("Ingrese cantidad de ciudaddes:");
        Scanner entrada = new Scanner(System.in);
        int cantidadDeCiudades = entrada.nextInt();
        String ciudades[] = new String[cantidadDeCiudades];
        Integer temperaturas[][] = new Integer[2][cantidadDeCiudades];

        for (int i = 0; i < cantidadDeCiudades; i++){
            System.out.println("Ingrese nombre de la ciudad  " +  i + ":");
            ciudades[i] = entrada.next();
            System.out.println("Ingrese temeporatura minima de la ciudad  " +  i + ":");
            temperaturas[0][i] = entrada.nextInt();
            System.out.println("Ingrese temeporatura maxima de la ciudad  " +  i + ":");
            temperaturas[1][i] = entrada.nextInt();
        }
        int min = temperaturas[0][0];
        int max = temperaturas[1][0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < cantidadDeCiudades; i++){
            if(temperaturas[0][i] < min ){
                min = temperaturas[0][i];
                minIndex = i;
            }
            if(temperaturas[1][i] > max ){
                max = temperaturas[1][i];
                maxIndex = i;
            }
        }
        System.out.println("La ciudad con menor temperatura es:" + ciudades[minIndex] + "con" + min );
        System.out.println("La ciudad con mayor temperatura es:" + ciudades[maxIndex] + "con" + max );
    }
}
