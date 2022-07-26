package estructuras;

import java.util.Scanner;

public class TempGlobales {

    static final int CANT_CIUDADES = 10;

    public static void main(String[] args) {

        String [] ciudades = new String[CANT_CIUDADES];
        int [][] temperaturas = new int[CANT_CIUDADES][2];
        int tempMin, tempMax;
        String ciudadMin, ciudadMax;

        Scanner tecladoCiud = new Scanner(System.in);
        Scanner tecladoTemp = new Scanner(System.in);

        System.out.println("Cargar los datos de las estructuras necesarias");

        for (int i=0 ; i<CANT_CIUDADES ; i++) {
            System.out.println("INGRESE EL NOMBRE DE LA CIUDAD EN LA POSICIÓN: " + i);

            ciudades[i] = tecladoCiud.nextLine();

            System.out.println("Ingrese la temperatura mínima de : " + ciudades[i]);

            temperaturas[i][0] = tecladoTemp.nextInt();

            System.out.println("Ingrese la temperatura máxima de : " + ciudades[i]);

            temperaturas[i][1] = tecladoTemp.nextInt();
        }
        tecladoCiud.close();
        tecladoTemp.close();

        //Busco tempMin y tempMax
        tempMin = temperaturas[0][0];
        tempMax = temperaturas[0][1];
        ciudadMin = ciudadMax = ciudades[0];

        for (int i=0 ; i< CANT_CIUDADES ; i++){
            for (int j=0 ; j<2 ; j++) {

                //temp minima
                if (temperaturas[i][j] < tempMin) {
                    tempMin = temperaturas[i][j];
                    ciudadMin = ciudades[i];
                }

                //tempMax
                if (temperaturas[i][j] > tempMax) {
                    tempMax = temperaturas[i][j];
                    ciudadMax = ciudades[i];
                }
            }
        }


        System.out.println("La ciudad de: " + ciudadMin + " fue la ciudad que presentó la temperatura mínima de: " + tempMin);
        System.out.println("La ciudad de: " + ciudadMax + " fue la ciudad que presentó la temperatura máxima de: " + tempMax);
    }
}
