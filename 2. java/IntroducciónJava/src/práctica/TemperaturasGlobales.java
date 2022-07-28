package práctica;

import java.util.Arrays;
import java.util.Scanner;

public class TemperaturasGlobales {
    public static void main(String[] args) {
        String arrayCiudades[] = new String[10];
        double matrizTemperaturas[][] = new double[10][2];

        Scanner ciudadesEntry = new Scanner(System.in);
        Scanner temperaturasEntry = new Scanner(System.in);

        for (int i = 0; i < arrayCiudades.length; i++) {
            System.out.println("Ingrese la ciudad en la que midió la temperatura: ");
            arrayCiudades[i] = ciudadesEntry.nextLine();
            for (int j = 0; j < matrizTemperaturas[i].length; j++) {
                if (j == 0) {
                    System.out.println("Ingrese la temperatura mínima de la ciudad: " + arrayCiudades[i]);
                } else {
                    System.out.println("Ingrese la temperatura máxima de la ciudad: " + arrayCiudades[i]);
                }
                matrizTemperaturas[i][j] = temperaturasEntry.nextInt();
            }

        }
        System.out.println(arrayCiudades);
        System.out.println(Arrays.toString(matrizTemperaturas));

        double tempMin, tempMax;
        tempMax = tempMin = matrizTemperaturas[0][0];
        String ciudadMin, ciudadMax;
        ciudadMin = ciudadMax = arrayCiudades[0];

        for (int x = 0; x < arrayCiudades.length; x++) {
            for (int y = 0; y < matrizTemperaturas[x].length; y++) {
                if(matrizTemperaturas[x][y] <= tempMin){
                    tempMin = matrizTemperaturas[x][y];
                    ciudadMin = arrayCiudades[x];
                }
                if(matrizTemperaturas[x][y] >= tempMax){
                    tempMax = matrizTemperaturas[x][y];
                    ciudadMax = arrayCiudades[x];
                }
            }
        }
        System.out.println("La menor temperatura es " + tempMin +" de la ciudad " + ciudadMin);
        System.out.println("La mayor temperatura es " + tempMax +" de la ciudad " + ciudadMax);

    }
}
