import java.util.Scanner;

public class GlobalTemperatures {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String city[] = new String[10];
        int temperaturas[][] = new int [10][2];

        int minima = 999;
        int maxima = -999;

        String ciudadMin = "";
        String ciudadMax = "";

        System.out.println("-----Bienvenidosa a Temperaturas Globales------");

        for (int i=0; i< city.length; i++){
            System.out.println("-------Especifique el nombre de la ciudad: " );
            city[i] = teclado.next();

            System.out.println("Ingrese la temperatura MINIMA de " + city[i] + ":  ");
            temperaturas[i][0] = teclado.nextInt();

            System.out.println("Ingrese la temperatura MAXIMA de " + city[i] + ":  ");
            temperaturas[i][1] = teclado.nextInt();
        }

        for (int j=0; j< city.length; j++){
            if(temperaturas[j][0] < minima) {
                minima = temperaturas[j][0];
                ciudadMin = city[j];
            }
            if(temperaturas[j][1] > maxima) {
                maxima = temperaturas[j][1];
                ciudadMax = city[j];
            }
        }
        System.out.println("-----la ciudad de " + ciudadMin + " tiene la temperatura MINIMA de " + minima);
        System.out.println("-----la ciudad de " + ciudadMax + " tiene la temperatura MAXIMA de " + maxima);
    }
}
