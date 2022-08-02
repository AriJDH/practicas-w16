package temperatura;

import java.util.ArrayList;
import java.util.List;

public class Temperatura {


    public static Ciudad temperaturaMaxima(int[][] temperaturas, List<String> ciudades){
        int max = Integer.MIN_VALUE;
        String ciudad = "";
        for(int i=0; i<temperaturas.length; i++){
            if(temperaturas[i][1] > max){
                max = temperaturas[i][1];
                ciudad = ciudades.get(i);
            }
        }
        return new Ciudad(ciudad, max);
    }

    public static Ciudad temperaturaMinima(int[][] temperaturas, List<String> ciudades){
        int min = Integer.MAX_VALUE;
        String ciudad = "";
        for(int i=0; i<temperaturas.length; i++){
            if(temperaturas[i][0] < min){
                min = temperaturas[i][0];
                ciudad = ciudades.get(i);
            }
        }
        return new Ciudad(ciudad, min);
    }

    public static void main(String[] args) {
       List<String> ciudades = new ArrayList<>();
       ciudades.add("Londres");
       ciudades.add("Madrid");
       ciudades.add("Nueva York");
       ciudades.add("Buenos Aires");
       ciudades.add("Asunción");
       ciudades.add("Sao Paulo");
       ciudades.add("Lima");
       ciudades.add("Santiago de Chile");
       ciudades.add("Lisboa");
       ciudades.add("Tokio");

       int[][] temperaturas = {
               {-2, 33},
               {-3, 32},
               {-8, 27},
               {4, 37},
               {6, 42},
               {5, 43},
               {0, 39},
               {-7, 26},
               {-1, 31},
               {-10, 35}
       };

        System.out.println("Ciudad con temperatura Máxima:");
        System.out.println(Temperatura.temperaturaMaxima(temperaturas, ciudades));
        System.out.println("______________________________");
        System.out.println("Ciudad con temperatura Mínima:");
        System.out.println(Temperatura.temperaturaMinima(temperaturas, ciudades));

    }
}
