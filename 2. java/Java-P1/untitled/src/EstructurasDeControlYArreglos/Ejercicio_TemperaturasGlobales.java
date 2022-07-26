package EstructurasDeControlYArreglos;

import java.util.Scanner;

public class Ejercicio_TemperaturasGlobales {
    public static void main(String[] args) {

        String[] nombreCiudades;
        int[][] temperaturas;
        int cantidadCiudades;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digita la cantidad de ciudades que hay que analizar : ");
        cantidadCiudades = teclado.nextInt();
        System.out.println();
        temperaturas = new int[cantidadCiudades][2];
        nombreCiudades = new String[cantidadCiudades];

        //Lenar la información.
        for (int i = 0; i < cantidadCiudades; i++){
            System.out.println("Digita el nombre de la ciudad #"+ (i+1) +" : ");
            //nombre de ciudades.
            nombreCiudades[i] = teclado.nextLine();
        }

        for (int i = 0; i < cantidadCiudades; i++){
            //Temperatura minima
            System.out.print("Digita la temperatura minima de " + nombreCiudades[i] +" : ");
            temperaturas[i][0] = teclado.nextInt();
            System.out.println("");
            //Temperatura maxima
            System.out.print("Digita la temperatura maxima de " + nombreCiudades[i] +" : ");
            temperaturas[i][1] = teclado.nextInt();
            System.out.println("");
        }



         int index =0;
        System.out.println("Nombre de ciudades");

        for(String nombre: nombreCiudades){

            System.out.println((index + 1) + ". Ciudad: " + nombre+" la mayor temperatura : " + temperaturas[index][1]  +"C La menor temperatura es :" + temperaturas[index][0] + "C .");
        }








    }
}
