package temperatures;

public class GlobalTemperatures {

    private static String[] cities;
    private static int[][] temperatures;

    public static void initialize() {
        cities = new String[] {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo",
                "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        temperatures = new int[][] {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39},
                {-7, 26}, {-1, 31}, {-10, 35}};
    }

    private static void printMinMaxTemp() {
        int minTemp = temperatures[0][0];
        int maxTemp = temperatures[0][1];
        String cityMinTemp = cities[0];
        String cityMaxTemp = cities[0];
        for (int i = 1; i<temperatures.length; i++) {
            if (temperatures[i][0] < minTemp) {
                minTemp = temperatures[i][0];
                cityMinTemp = cities[i];
            }
            if (temperatures[i][1] > maxTemp) {
                maxTemp = temperatures[i][1];
                cityMaxTemp = cities[i];
            }
        }
        System.out.println("La ciudad con la menor temperatura es " + cityMinTemp + " con una temperatura de "
                + minTemp + "°C");
        System.out.println("La ciudad con la mayor temperatura es " + cityMaxTemp + " con una temperatura de "
                + maxTemp + "°C");
    }

    private static void printMaxTemp() {

    }

    public static void main(String[] args) {
        initialize();
        printMinMaxTemp();
    }
}
