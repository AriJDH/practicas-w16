/*
    Author: Tannia Lucía Hernández Rojas
    Descripción: Encuentra la temperatura mayor y menor entre todas las ciudadas
    Fecha: 26 de Julio de 2022
 */

public class Temperaturas {


    public static void main (String[] args){

        //Declaración de variables
        int max_temperature = -9999;
        int min_temperature = 9999;
        int ind_min = 0;
        int ind_max = 0;

        String[] cities = new String[] {"Londres","Madrid","Nueva York", "Buenos Aires", "Asunción","Sao Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = new int[][] {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        //Se recorre todas las temperaturas
        for (int i=0; i<cities.length; i++){
            for (int j=0; j<temperatures[i].length; j++){

                //Se compara para determinar la menor temperatura y el indice correspondiente
                if (j==0 && temperatures[i][j] < min_temperature) {
                    min_temperature = temperatures[i][j];
                    ind_min = i;
                }
                //Se compara para determinar la mayor temperatura y el indice correspondiente
                else if (j==1 && temperatures[i][j] > max_temperature) {
                    max_temperature = temperatures[i][j];
                    ind_max = i;
                }
            }
        }
        //Se muestran los datos encontrados
        System.out.println("La menor temperatura la tuvo "+ cities[ind_min] +" con "+min_temperature);
        System.out.println("La mayor temperatura la tuvo "+ cities[ind_max] +" con "+max_temperature);
    }

}
