import java.util.Scanner;

public class TemperaturasGlobales {

    private Scanner teclado;
    private String[] ciudades;
    private float[][] temperaturas;

    public void cargar(){
        teclado = new Scanner(System.in);
        ciudades = new String[10];
        temperaturas = new float[10][2];
        //inicializamos sueldos
        for(int i = 0; i< ciudades.length; i++){
            System.out.println("Ingrese la ciudad: ");
            ciudades[i] = teclado.next();
            System.out.println("Ingrese temperatura minima: ");
            temperaturas[i][0] = teclado.nextFloat();
            System.out.println("Ingrese temperatura maxima: ");
            temperaturas[i][1] = teclado.nextFloat();
        }
    }

    public void imprimir(){

        float tempMinima = temperaturas[0][0];
        String ciudadMinima = ciudades[0];
        float tempMaxima = temperaturas[0][0];
        String ciudadMaxima = ciudades[0];
        //Recorrido para encontrar la temperatura mínima y máxima
        for (int f = 0; f < ciudades.length; f++) {
            for (int c = 0; c < temperaturas[0].length; c++) {

                //Condición para encontrar la temperatura mínima y guardar la ciudad que posea la misma
                if (temperaturas[f][c]<tempMinima){
                    tempMinima=temperaturas[f][c];
                    ciudadMinima=ciudades[f];
                }
                //Condición para encontrar la temperatura máxima y guardar la ciudad que posea la misma
                if (temperaturas[f][c]>tempMaxima){
                    tempMaxima=temperaturas[f][c];
                    ciudadMaxima=ciudades[f];
                }

            }

        }

        System.out.println("-------------------");
        System.out.println("---INFORME FINAL---");
        System.out.println("-------------------");
        System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + tempMinima);
        System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + tempMaxima);
        System.out.println("------------------------------------------------------------------------------------------");

        for (int j=0; j<ciudades.length; j++){
            System.out.println(ciudades[j] + " temp min: " + temperaturas[j][0] + " temp max: " + temperaturas[j][1]);
        }
    }



    public static void main(String[] args) {



        TemperaturasGlobales temperaturasGlobales = new TemperaturasGlobales();

        temperaturasGlobales.cargar();
        temperaturasGlobales.imprimir();
    }
}