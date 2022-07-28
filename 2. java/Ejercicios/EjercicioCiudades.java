package arreglos;

import java.util.Scanner;

public class EjercicioCiudades {
    public static void main(String[] args) {
        String ciudades[] = new String[10];
        double temperaturas [][] = new double[10][2];
        double tempMinima, tempMaxima;
        String ciudadMinima, ciudadMaxima;
        Scanner entrada = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);

        System.out.println("A continuacion se solicitaran los datos de 10 ciudades");

        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Nombre de la ciudad");
            ciudades [i]=entrada.nextLine();
            for (int j = 0; j < temperaturas[0].length; j++) {
                if(j==0){
                    System.out.println("Ingrese la temperatura minima de la ciudad de "+ ciudades[i]);
                    temperaturas[i][j]=entrada2.nextInt();
                }else{
                    System.out.println("Ingrese la temperatura máxima de la ciudad de "+ ciudades[i]);
                    temperaturas[i][j]=entrada2.nextInt();
                }
            }
        }

        tempMinima=temperaturas[0][0];
        tempMaxima=temperaturas[0][0];
        ciudadMaxima=ciudades[0];
        ciudadMinima=ciudades[0];


        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < temperaturas[0].length; j++) {

                if(temperaturas[i][j]<tempMinima){
                    tempMinima=temperaturas[i][j];
                    ciudadMinima=ciudades[i];
                }
                if(temperaturas[i][j]>tempMaxima){
                    tempMaxima=temperaturas[i][j];
                    ciudadMaxima=ciudades[i];
                }
            }
        }

        System.out.println("Ciudad con menor temperatura: "+ciudadMinima+" con un valor de "+tempMinima+" grados.");
        System.out.println("Ciudad con mayor temperatura: "+ciudadMaxima+" con un valor de "+tempMaxima+" grados.");

    }
}
