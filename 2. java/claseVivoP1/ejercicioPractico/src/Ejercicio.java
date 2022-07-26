import java.util.Scanner;

public class Ejercicio {
    public static final String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires",
            "Asuncion", "São Paulo", "Lima", "Santiago de Chile",
            "Lisboa", "Tokio"};
    public static final int temperaturas[][] = {{-2, 33},
                                                {-3, 32},
                                                {-8, 27},
                                                {4, 37},
                                                {6, 42},
                                                {5, 43},
                                                {0, 39},
                                                {-7, 26},
                                                {-1, 31},
                                                {-10, 35}};
    private static int buscarMin(){
        int indice = 0;
        int minimo = temperaturas[0][0];
        for(int i = 0; i < temperaturas.length; i++){
            if(minimo > temperaturas[i][0]){
                minimo = temperaturas[i][0];
                indice = i;
            }
        }

        return indice;
    }

    private static int buscarMax(){
        int indice = 0;
        int maximo = temperaturas[0][1];
        for(int i = 0; i < temperaturas.length; i++){
            if(maximo < temperaturas[i][1]){
                maximo = temperaturas[i][1];
                indice = i;
            }
        }

        return indice;
    }

    public static void main(String[] args) {
        String nombreMax, nombreMin;
        int tempMax, tempMin;

        int indiceMax = buscarMax();
        int indiceMin = buscarMin();

        nombreMax = ciudades[indiceMax];
        nombreMin = ciudades[indiceMin];
        tempMax = temperaturas[indiceMax][1];
        tempMin = temperaturas[indiceMin][0];

        System.out.println("La mayor temperatura la tuvo " + nombreMax + ", con " + tempMax + "ºC.");
        System.out.println("La menor temperatura la tuvo " + nombreMin + ", con " + tempMin + "ºC.");
    }
}
