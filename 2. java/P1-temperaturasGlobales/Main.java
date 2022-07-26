import java.util.Scanner;

public class Main {

   public static void main(String[] args){

      String ciudades [] = new String[10];
      double temperaturas[][] = new double[10][2];
      int indiceTempMinima = 0;
      int indiceTempMaxima = 0;

      Scanner scString =  new Scanner(System.in);
      Scanner scDouble =  new Scanner(System.in);

      System.out.println("-----------------------------------");
      System.out.println("-------Temperaturas Globales-------");
      System.out.println("-----------------------------------");

      for (int i = 0; i < ciudades.length; i++) {

         System.out.println("Por favor ingrese el nombre de la ciudad N " + (i + 1));
         String nombreCiudad =  scString.nextLine();
         ciudades[i] = nombreCiudad;

         System.out.println("Por favor ingrese la temperatura minima registrada de la ciudad de " + nombreCiudad);

         temperaturas[i][0] =  scDouble.nextDouble();

         System.out.println("Por favor ingrese la temperatura maxima registrada de la ciudad de " + nombreCiudad);

         temperaturas[i][1] =  scDouble.nextDouble();

         if(temperaturas[i][0] < temperaturas[indiceTempMinima][0]){
            indiceTempMinima = i;
         }

         if(temperaturas[i][1] > temperaturas[indiceTempMaxima][1]){
            indiceTempMaxima = i;
         }
      }

      System.out.println("-------Resumen-------");
      System.out.println("La ciudad " + ciudades[indiceTempMinima] + " es la que registra el record de temperatura minima la cual es: " + temperaturas[indiceTempMinima][0]);
      System.out.println("La ciudad " + ciudades[indiceTempMaxima] + " es la que registra el record de temperatura maxima la cual es: " + temperaturas[indiceTempMaxima][1]);

   }

}
