public class Main {

    public static void main(String[] args) {

        String[] cities = initializeCities();
        int[][] temperatures = initializeTemperaturesBasedOn(cities.length);

        printTemperatureNewsOf(cities, temperatures);
    }

    private static void printTemperatureNewsOf(String[] cities, int[][] temperaturesOfCities) {
        String cityWithMinorTemperature = cities[0];
        String cityWithHighestTemperature = cities[0];
        int minorTemperature = temperaturesOfCities[0][0];
        int highestTemperature = temperaturesOfCities[0][1];

        for (int i = 0; i<temperaturesOfCities.length; i++){
            if(temperaturesOfCities[i][0] < minorTemperature) {
                minorTemperature = temperaturesOfCities[i][0];
                cityWithMinorTemperature = cities[i];
            }
            if(temperaturesOfCities[i][1] > highestTemperature) {
                highestTemperature = temperaturesOfCities[i][1];
                cityWithHighestTemperature = cities[i];
            }
        }

        System.out.println("La menor temperatura la tuvo " + cityWithMinorTemperature + ", con " + minorTemperature + " ªC");
        System.out.println("La mayor temperatura la tuvo " + cityWithHighestTemperature + ", con " + highestTemperature + " ªC");
    }
    
    private static int[][] initializeTemperaturesBasedOn(int anAmountOfCities) {
        int[][] temperatures = new int[anAmountOfCities][2];
        temperatures[0][0] = -2;
        temperatures[0][1] = 33;
        temperatures[1][0] = -3;
        temperatures[1][1] = 32;
        temperatures[2][0] = -8;
        temperatures[2][1] = 27;
        temperatures[3][0] = 4;
        temperatures[3][1] = 37;
        temperatures[4][0] = 6;
        temperatures[4][1] = 42;
        temperatures[5][0] = 5;
        temperatures[5][1] = 43;
        temperatures[6][0] = 0;
        temperatures[6][1] = 39;
        temperatures[7][0] = -7;
        temperatures[7][1] = 26;
        temperatures[8][0] = -1;
        temperatures[8][1] = 31;
        temperatures[9][0] = -10;
        temperatures[9][1] = 35;
        return temperatures;
    }
    private static String[] initializeCities() {
        String[] cities = new String[10];
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asuncion";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";
        return cities;
    }

}
