package com.tomas.temperatura;

/*************************************************************
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * fecha: 26 de Julio 2022
 * Descripción: Clase que calcula la temperatura mayor
 * y menor, imprimiendo su valor con el nombre de la ciudad.
 *************************************************************/

public class NoticiaTemperatura {

    public static void main(String[] args) {

        //Inicialización de las variables
        float temperaturaMenorActual = 0;
        float temperaturaMenor = 0;
        float temperaturaMayorActual = 0;
        float temperaturaMayor = 0;

        String ciudadMenor = "";
        String ciudadMayor = "";

        //Inicialización del vector ciudad y cargue de su contenido

        String ciudad[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        //Inicialización de la matriz temperatura y cargue de su contenido
        float temperatura[][] = {{-2,33}, {-3,32}, {-8,27}, {4,37}, {6,42}, {5,43}, {0,39}, {-7,26},
                {-1,31}, {-10,35}};

        //Calculando temperaturas mayor y menor
        for (int fila = 0; fila < temperatura.length; fila++) {

            //Asigna la temperatura actual recorrida menor y mayor
            temperaturaMenorActual = temperatura[fila][0];
            temperaturaMayorActual = temperatura[fila][1];

            if(fila == 0) {

                //Almacena las temperaturas del primer recorrido
                temperaturaMenor = temperaturaMenorActual;
                temperaturaMayor = temperaturaMayorActual;

            } else {

                //Compara si la temperatura recorrida actualmente es menor que la ya almacenada como menor temperatura
                if(temperaturaMenorActual < temperaturaMenor) {

                    temperaturaMenor = temperaturaMenorActual;
                    ciudadMenor = ciudad[fila];

                }

                //Compara si la temperatura recorrida actualmente es mayor que la ya almacenada como mayor temperatura
                if(temperaturaMayorActual > temperaturaMayor) {

                    temperaturaMayor = temperaturaMayorActual;
                    ciudadMayor = ciudad[fila];

                }

            }
        }

        //Impresion de la temperatura mayor y menor con el nombre de la ciudad correspondiente
        System.out.println("Ciudad con menor temperatura");
        System.out.println(ciudadMenor + ": " + temperaturaMenor + "°C");
        System.out.println("-------------------------------------");
        System.out.println("Ciudad con mayor temperatura");
        System.out.println(ciudadMayor + ": " + temperaturaMayor + "°C");



    }

}
