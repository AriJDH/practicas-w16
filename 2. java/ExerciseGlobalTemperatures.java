package practices;

public class ExerciseGlobalTemperatures {
    static String[] cities = {"Londres", "Madrid", "Nueva york", "Buenos Aires", "Asuncion", "Sâo Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
    static int[][] temperatures = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
    static int minor = 0;
    static String city_minor = "";
    static int elderly = 0;
    static String city_elderly = "";

    public static void main(String[] args) {
        ExerciseGlobalTemperatures exerciseGlobalTemperatures = new ExerciseGlobalTemperatures();

        exerciseGlobalTemperatures.PrintTemperature();
    }

    // Cual fue la temperatura maxima se debe mostrar el nombre
    // cual fue la temperatura minima se debe mostrar el nombre
    private void PrintTemperature() {
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = 0; j < temperatures[i].length; j++) {

                if ( j == 0 && temperatures[i][j] < minor) {
                    minor = temperatures[i][j];
                    city_minor = cities[i];
                }

                if ( j == 1 && temperatures[i][j] > elderly) {
                    elderly = temperatures[i][j];
                    city_elderly = cities[i];
                }
            }
        }

        System.out.println("Temperatura Menor " + city_minor + ": " + minor);
        System.out.println("Temperatura Mayor " + city_elderly + ": " + elderly);
    }
}
