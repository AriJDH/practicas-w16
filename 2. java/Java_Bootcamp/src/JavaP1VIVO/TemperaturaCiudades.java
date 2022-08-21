package JavaP1VIVO;

public class TemperaturaCiudades {
    // Temperaturas Globales

    String[] cityName = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción", "Sáo Paulo",
            "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    int[][] temperatures = {
            {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},
            {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}};

    public void scannerTemperatures() {
        int indexMin = 0;
        int tempMinima = 0;
        int indexMax = 0;
        int tempMaxima = 0;

        int sizeMatriz = temperatures[0].length;

        // minima
        for (int i = 0; i < sizeMatriz; i++) {
            if (temperatures[0][i] <= tempMinima) {
                tempMinima = temperatures[0][i];
                indexMin = i;
            }

            if (temperatures[1][i] >= tempMaxima) {
                tempMaxima = temperatures[1][i];
                indexMax = i;
            }
        }

        System.out.println("The minimum temperature is : " + cityName[indexMin] + " " + tempMinima);
        System.out.println("The maximum temperature is : " + cityName[indexMax] + " " + tempMaxima);
    }

    public static void main(String[] args) {

        new TemperaturaCiudades().scannerTemperatures();
    }
}
