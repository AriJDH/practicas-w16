package ciudades;

public class EjercicioTemperaturaCiudades {

    String[] ciudades = new String[10];

    int[][] matrizTemperaturas = new int[10][2];

    public void agregarCiudades(){

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
    }

    public void agregarTemperaturas(){

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

    public String obtenerCiudadConMayorTemperatura(){

        int mayorTemp = matrizTemperaturas[0][1];
        String mensaje;
        int codCiudad = 0;

        for (int i = 0; i < matrizTemperaturas.length; i++) {
            for (int j = 0; j < matrizTemperaturas[0].length; j++) {

                if(matrizTemperaturas[i][j] > mayorTemp){
                    mayorTemp = matrizTemperaturas[i][j];
                    codCiudad = i;
                }
            }
            }

        mensaje = "La ciudad con mayor temperatura es " + ciudades[codCiudad] + " con una temperatura de " + mayorTemp + " grados";

        return mensaje;

    }

    public String obtenerCiudadMenorTemperatura(){

        int menorTemp = matrizTemperaturas[0][0];
        String mensaje;
        int codCiudad = 0;

        for (int i = 0; i < matrizTemperaturas.length; i++) {
            for (int j = 0; j < matrizTemperaturas[0].length; j++) {

                if(matrizTemperaturas[i][j] < menorTemp){
                    menorTemp = matrizTemperaturas[i][j];
                    codCiudad = i;
                }
            }
        }

        mensaje = "La ciudad con menor temperatura es " + ciudades[codCiudad] + " con una temperatura de " + menorTemp + " grados";

        return mensaje;

    }

    public static void main(String[] args) {

        EjercicioTemperaturaCiudades ejer = new EjercicioTemperaturaCiudades();

        ejer.agregarCiudades();
        ejer.agregarTemperaturas();
        String mayorTemp =  ejer.obtenerCiudadConMayorTemperatura();
        String menorTemp = ejer.obtenerCiudadMenorTemperatura();
        System.out.println(mayorTemp);
        System.out.println(menorTemp);
    }
}
