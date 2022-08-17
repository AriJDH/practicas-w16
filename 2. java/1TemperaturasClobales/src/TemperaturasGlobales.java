public class TemperaturasGlobales {
    public static void main(String[] args) {
        int vector[] = new int[5];

        //Vector Ciudades
        String ciudades[] = new String [10];

        ciudades[0]="Londres";
        ciudades[1]="Madrid";
        ciudades[2]="Nueva York";
        ciudades[3]="Buenos Aires";
        ciudades[4]="Asunción";
        ciudades[5]="São Paulo";
        ciudades[6]="Lima";
        ciudades[7]="Santiago de Chile";
        ciudades[8]="Lisboa";
        ciudades[9]="Tokio";

        //Matriz Temperaturas
        int [][] temperaturas = {{2,-3,-8,4,6,5,0,-7,-1,-10}, {33,32,27,37,42,43,39,26,31,35}};

        //Recorro para ver como es la matriz
        System.out.println("Datos de la matriz:");
        for(int i=0;i<temperaturas.length;i++){
            for(int j=0;j<temperaturas[i].length;j++){
                System.out.println(temperaturas[i][j]);
            }
        }

        //Controlo valores iniciales
        int tempMin= temperaturas[0][0];
        String ciudadMin = ciudades[0];

        int tempMax = temperaturas[0][0];
        String ciudadMax = ciudades[0];

        for(int i=0;i<temperaturas.length;i++){//minimas
            for(int j=0;j<temperaturas[i].length;j++) {//maximas
                //System.out.println(temperaturas[i][j]);
                if (i == 0) {//minima
                    if (temperaturas[i][j] < tempMin) {
                        tempMin = temperaturas[i][j];
                        ciudadMin = ciudades[j];
                    }
                } else if (i == 1) {//maxima
                    if (temperaturas[i][j] > tempMax) {
                        tempMax = temperaturas[i][j];
                        ciudadMax = ciudades[j];
                    }
                }
            }
        }

        System.out.println();
        String noticia;
        noticia = "La temperatura máxima entre las ciudades registradas fue de: " + tempMax + "°C en " + ciudadMax + ", mientras que la temperatura mínima fue en " + ciudadMin  + " de " + tempMin + "°C." ;
        System.out.println(noticia);

    }
}
