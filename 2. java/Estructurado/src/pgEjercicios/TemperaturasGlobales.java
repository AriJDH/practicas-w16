package pgEjercicios;

public class TemperaturasGlobales {
    public static void main(String[] args) {
        int MIN_VALUES_COLUMN = 0;
        int MAX_VALUES_COLUMN = 1;

        String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        int maxTempIndex = 0;
        int minTempIndex = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] < temperatures[minTempIndex][MIN_VALUES_COLUMN])
                minTempIndex = i;
            if (temperatures[i][1] > temperatures[maxTempIndex][MAX_VALUES_COLUMN])
                maxTempIndex = i;
        }
        System.out.println("La temperatura maxima fue en " + cities[maxTempIndex] + " de " + temperatures[MAX_VALUES_COLUMN][1]);
        System.out.println("La temperatura minima fue en " + cities[minTempIndex] + " de " + temperatures[MIN_VALUES_COLUMN][0]);
    }

}
