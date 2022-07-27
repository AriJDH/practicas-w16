package IntroducciónaJava;

import java.util.Scanner;

public class TemperaturasGlobales {
    public static void main(String[] args) {

        //----------------------------------------------
        //Creacion de matrices y consulta de informacion
        //----------------------------------------------
        String[] ciudades;
        ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asuncion";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int temperaturas[][]= new int [10][2];
        temperaturas[0][0] =-2;
        temperaturas[0][1] =33;

        temperaturas[1][0] =-3;
        temperaturas[1][1] =32;

        temperaturas[2][0] =-8;
        temperaturas[2][1] =27;

        temperaturas[3][0] =4;
        temperaturas[3][1] =37;

        temperaturas[4][0] =6;
        temperaturas[4][1] =42;

        temperaturas[5][0] =5;
        temperaturas[5][1] =43;

        temperaturas[6][0] =0;
        temperaturas[6][1] =39;

        temperaturas[7][0] =-7;
        temperaturas[7][1] =26;

        temperaturas[8][0] =-1;
        temperaturas[8][1] =31;

        temperaturas[9][0] =-10;
        temperaturas[9][1] =35;

        for(int f = 0;f<=9;f++){
            String ciudad = ciudades[f];
            int tempMin= temperaturas[f][0];
            int tempMax= temperaturas[f][1];
            System.out.println("En la ciudad de "+ciudad+" la temperatura minima sera de "+tempMin+" y la maxima de "+tempMax);

        }


        //---------------------------------------------------------
        //Creacion de ingreso de datos a matriz y consulta de datos
        //---------------------------------------------------------

        //Declaracion de variables y matrices
        String ciudades1[]= new String [10];
        int temperaturas1[][]= new int [10][2];
        double tempMinima1, tempMaxima1;

        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);

        for (int f = 0; f <= 9; f++) {
            System.out.println("------------------------------------------------------");
            System.out.println("Ingrese el nombre de la ciudad en la posicion: " + f);
            ciudades1[f] = teclado.nextLine();

            for (int c = 0; c <= 1; c++) {
                if (c == 0) {
                    System.out.println("Ingrese la temperatura mínima para la ciudad de: " + ciudades1[f]);
                    temperaturas1[f][c] = teclado2.nextInt();
                } else {
                    System.out.println("Ingrese la temperatura máxima para la ciudad de: " + ciudades1[f]);
                    temperaturas1[f][c] = teclado2.nextInt();
                }
            }

        }
        for(int f = 0;f<=9;f++){
            String ciudad1 = ciudades1[f];
            int tempMin= temperaturas1[f][0];
            int tempMax= temperaturas1[f][1];
            System.out.println("En la ciudad de "+ciudad1+" la temperatura minima sera de "+tempMin+" y la maxima de "+tempMax);

        }
    }
}
