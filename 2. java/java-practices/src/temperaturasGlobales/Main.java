package temperaturasGlobales;

 /*
  * Ejercicio > Modulo 5: Java > IntroduccionAJava-P1-VIVO
  * ESTADO: Finalizado.
  * @GonzaloNahuelDiPierro
  * */
public class Main {
    public static void main(String[] args){
        String cityArray[] = new String[10];
        cityArray[0] = "Londres";
        cityArray[1] = "Madrid";
        cityArray[2] = "Nueva York";
        cityArray[3] = "Buenos Aires";
        cityArray[4] = "Asunción";
        cityArray[5] = "San Pablo";
        cityArray[6] = "Lima";
        cityArray[7] = "Santiago de Chile";
        cityArray[8] = "Lisboa";
        cityArray[9] = "Tokio";

        int temperatureArray[][] = new int[10][2];
        temperatureArray[0][0] = -2; temperatureArray[0][1] = 33;
        temperatureArray[1][0] = -3; temperatureArray[1][1] = 32;
        temperatureArray[2][0] = -8; temperatureArray[2][1] = 27;
        temperatureArray[3][0] = 4; temperatureArray[3][1] = 37;
        temperatureArray[4][0] = 6; temperatureArray[4][1] = 42;
        temperatureArray[5][0] = 5; temperatureArray[5][1] = 43;
        temperatureArray[6][0] = 0; temperatureArray[6][1] = 39;
        temperatureArray[7][0] = -7; temperatureArray[7][1] = 26;
        temperatureArray[8][0] = -1; temperatureArray[8][1] = 31;
        temperatureArray[9][0] = -10; temperatureArray[9][1] = 35;

        int indexMinTemperature = getIndexMinTemperature(temperatureArray);
        int indexMaxTemperature = getIndexMaxTemperature(temperatureArray);

        // output
        System.out.println("RESULTADOS");
        System.out.println("> La menor temperatura la tuvo " + cityArray[indexMinTemperature] + ", con " + temperatureArray[indexMinTemperature][0] + "ºC.");
        System.out.println("> La mayor temperatura la tuvo " + cityArray[indexMaxTemperature] + ", con " + temperatureArray[indexMaxTemperature][1] + "ºC.");
    }

    private static int getIndexMinTemperature(int[][] temperatureArray){
        int indexMinTemperature = 0, minTemperature = temperatureArray[0][0];
        for(int i=1; i<temperatureArray.length; i++){
            if(temperatureArray[i][0] < minTemperature){
                indexMinTemperature = i;
                minTemperature = temperatureArray[i][0];
            }
        }

        return indexMinTemperature;
    }

    private static int getIndexMaxTemperature(int[][] temperatureArray){
        int indexMaxTemperature = 0, maxTemperature = temperatureArray[0][1];
        for(int i=1; i<temperatureArray.length; i++){
            if(temperatureArray[i][1] > maxTemperature){
                indexMaxTemperature = i;
                maxTemperature = temperatureArray[i][1];
            }
        }

        return indexMaxTemperature;
    }
}
