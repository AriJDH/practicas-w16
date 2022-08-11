public class TemperaturasGlobales {

    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4,37}, {6,42}, {5, 43}, {0,39}, {-7, 26}, {-1, 31}, {-10,35}};

        int temperaturaMaxima = 0;
        int posicionTemperaturaMaxima = 0;
        int temperaturaMinima = 0;
        int posicionTemperaturaMinima = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                posicionTemperaturaMinima = i;
            }
            if (temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                posicionTemperaturaMaxima = i;
            }
        }

        System.out.println("La temperatura minima fue de la ciudad de " + ciudades[posicionTemperaturaMinima] + " con: " + temperaturaMinima + "°C");
        System.out.println("La temperatura maxima fue de la ciudad de " + ciudades[posicionTemperaturaMaxima] + " con: " + temperaturaMaxima + "°C");

    }

}
