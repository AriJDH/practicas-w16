public class TemperaturasGlobales {

    public static void main(String[] args) {

        String ciudadMenorT = "";
        String ciudadMayorT = "";
        int tempMenor = 0;
        int tempMayor = 0;

        String ciudades [] = {"Londres", "Madrid", "Nueva york", "Buenos Aires", "Asuncion", "Sâo Pablo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas [][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};


        for (int fil=0 ; fil < ciudades.length ; fil++){
            for (int col=0 ; col < temperaturas[0].length ; col++) {
                if (temperaturas[fil][col] < tempMenor) {
                    tempMenor = temperaturas[fil][col];
                    ciudadMenorT = ciudades[fil];
                }
                else if (temperaturas[fil][col] > tempMayor) {
                    tempMayor = temperaturas[fil][col];
                    ciudadMayorT = ciudades[fil];
                }
            }
        }
        System.out.println("La menor temperatura la tuvo la ciudad de: " + ciudadMenorT + " con una temperatura mínima de: " + tempMenor);
        System.out.println("La mayor temperatura la tuvo la ciudad de: " + ciudadMayorT + " con una temperatura maxima de: " + tempMayor);
        }





    }

