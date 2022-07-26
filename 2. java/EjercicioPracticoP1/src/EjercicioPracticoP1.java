public class EjercicioPracticoP1 {
    private String[] vectorCiudades;
    private int[][] matrizTemperaturas;

    public void llenarVectorCiudades(){
        vectorCiudades = new String[10];
        vectorCiudades[0] = "Londres";
        vectorCiudades[1] = "Madrid";
        vectorCiudades[2] = "Nueva York";
        vectorCiudades[3] = "Buenos Aires";
        vectorCiudades[4] = "Asuncion";
        vectorCiudades[5] = "Sao Paulo";
        vectorCiudades[6] = "Lima";
        vectorCiudades[7] = "Santiago de Chile";
        vectorCiudades[8] = "Lisboa";
        vectorCiudades[9] = "Tokio";
    }

    public void llenarMatrizTemperaturas(){
        matrizTemperaturas = new int[10][2];
        matrizTemperaturas[0][0] = -2;
        matrizTemperaturas[0][1] = 33;
        matrizTemperaturas[1][0] = -3;
        matrizTemperaturas[1][1] = 32;
        matrizTemperaturas[2][0] = -8;
        matrizTemperaturas[2][1] = 27;
        matrizTemperaturas[3][0] = 4;
        matrizTemperaturas[3][1] = 37;
        matrizTemperaturas[4][0] = 6;
        matrizTemperaturas[4][1] = 42;
        matrizTemperaturas[5][0] = 5;
        matrizTemperaturas[5][1] = 43;
        matrizTemperaturas[6][0] = 0;
        matrizTemperaturas[6][1] = 39;
        matrizTemperaturas[7][0] = -7;
        matrizTemperaturas[7][1] = 26;
        matrizTemperaturas[8][0] = -1;
        matrizTemperaturas[8][1] = 31;
        matrizTemperaturas[9][0] = -10;
        matrizTemperaturas[9][1] = 35;
    }

    public void encontrarMaximo_minimo(){
        int temperaturaMin = matrizTemperaturas[0][0];
        int temperaturaMaxima = matrizTemperaturas[0][1];
        String ciudadMin = vectorCiudades[0];
        String ciudadMax =vectorCiudades[0];
        for (int x = 0 ; x < vectorCiudades.length; x++){
           if(matrizTemperaturas[x][0]<temperaturaMin){
               temperaturaMin = matrizTemperaturas[x][0];
               ciudadMin = vectorCiudades[x];
           }
           if(matrizTemperaturas[x][1]>temperaturaMaxima){
                temperaturaMaxima = matrizTemperaturas[x][1];
                ciudadMax = vectorCiudades[x];
           }

        }
        System.out.println("La mayor temperatura la tuvo "+ciudadMax+", con "+temperaturaMaxima+"°C. Y la menor Temperatura la tuvo "+ciudadMin+" con "+temperaturaMin+"°C." );
    }

    public static void main(String[] args) {
        EjercicioPracticoP1 ejercicioPracticoP1 = new EjercicioPracticoP1();
        ejercicioPracticoP1.llenarVectorCiudades();
        ejercicioPracticoP1.llenarMatrizTemperaturas();
        ejercicioPracticoP1.encontrarMaximo_minimo();


    }
}
