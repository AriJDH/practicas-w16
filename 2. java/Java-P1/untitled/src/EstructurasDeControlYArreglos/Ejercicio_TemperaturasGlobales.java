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
            System.out.println("------------------------------------------------------");
            System.out.print("Digita el nombre de la ciudad #"+ (i+1) +" : ");
            nombreCiudades[i] = teclado.next();

            for(int j = 0; j<2;j++){
                if(j==0){
                    //Temperatura minima
                    System.out.print("Digita la temperatura minima de " + nombreCiudades[i] +" : ");
                    temperaturas[i][j] = teclado.nextInt();
                    System.out.println();
                }else{
                    //Temperatura maxima
                    System.out.print("Digita la temperatura maxima de " + nombreCiudades[i] +" : ");
                    temperaturas[i][j] = teclado.nextInt();
                    System.out.println();
                }
            }
        }

        int index =0;
        int ciudadTemMinima = 0,CiudadTemMax = 0;
        System.out.println("Nombre de ciudades");

        for(String nombre: nombreCiudades){
            System.out.println((index + 1) + ". Ciudad: " + nombre+" la mayor temperatura : "
                    + temperaturas[index][1]  +"C La menor temperatura es :" + temperaturas[index][0] + "C .");

            //Calculo de la ciudad y temperatura minima y maxima
            if(index+1 < cantidadCiudades){
                //Temperatura minima
                if(temperaturas[index][0] < temperaturas[index+1][0] ){
                    ciudadTemMinima = index+1;
                }

                //Temperatura maxima
                if(temperaturas[index][1] < temperaturas[index+1][1] ){
                    CiudadTemMax = index+1;
                }
            }
            ++index;
        }

        System.out.println("-------------------");
        System.out.println("---INFORME FINAL---");
        System.out.println("-------------------");
        System.out.println("La ciudad de " + nombreCiudades[ciudadTemMinima] + " es la ciudad con la temperatura mínima de: " + temperaturas[ciudadTemMinima][0]);
        System.out.println("La ciudad de " + nombreCiudades[CiudadTemMax] + " es la ciudad con la temperatura máxima de: " + temperaturas[CiudadTemMax][1]);
        System.out.println("------------------------------------------------------------------------------------------");


    }
}
