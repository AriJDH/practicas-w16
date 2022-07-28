package Estructuras;

public class Temperaturas_globales {

    public static void main(String[] args) {
        //declaro vector
        String[] ciudades = new String[10];
        //declaro matriz
        double[][] temperaturas = new double[10][10];

        //lleno mi vector de ciudades

        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "Sao Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        //lleno mi matriz de temperaturas

        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;

        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;

        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;

        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;

        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;

        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;

        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;

        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;

        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;

        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;


        // variables mayor y menor

        double temperaturaMin = temperaturas[0][0];
        double temperaturaMax = temperaturas[0][0];
        String ciudad_max = ciudades[0];
        String ciudad_min = ciudades[0];

        for (int i=0; i<temperaturas.length; i++){
            for (int j=0; j<temperaturas[i].length;j++){
                double actual = temperaturas[i][j];
                if (actual>temperaturaMax){

                    temperaturaMax = actual;
                    ciudad_max = ciudades[i];
                }
                if (actual<temperaturaMin){
                    temperaturaMin = actual;
                    ciudad_min = ciudades[i];
                }

            }
        }

        System.out.println("La  ciudad con temperatura maxima es: "+ ciudad_max + " con una temperatura de: " + temperaturaMax);
        System.out.println("La  ciudad con temperatura minima es: "+ ciudad_min + " con una temperatura de: " + temperaturaMin);


    }

}
