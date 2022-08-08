package P1;

import java.util.Scanner;

public class TemperaturasGlobales {
    private static Scanner teclado;
    private static String [] ciudades;
    static int cantidadDeCiudades;
    public static void main(String[] args){
        teclado = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de ciudades a registrar:");
        cantidadDeCiudades = teclado.nextInt();
        int temperaturas[][] = new int[cantidadDeCiudades][2];
        ciudades = new String[cantidadDeCiudades];
        cargarCiudadesYTemperaturas(temperaturas);
        calcularMinimoYMaximo(temperaturas);
    }

    public static void cargarCiudadesYTemperaturas(int [][] temp){
        teclado = new Scanner(System.in);
        for (int i = 0; i < cantidadDeCiudades; i++) {
            System.out.println("Ingrese el nombre de la ciudad: ");
            ciudades[i] = teclado.nextLine();
            System.out.println("Ingrese la temperatura minima de " + ciudades[i] + ":");
            temp[i][0] = teclado.nextInt();
            System.out.println("Ingrese la temperatura maxima de " + ciudades[i] + ":");
            temp[i][1] = teclado.nextInt();
            teclado.nextLine();
        }
        teclado.close();
    }

    public static void calcularMinimoYMaximo(int [][] temp){
        int temperaturaMinima = temp[0][0];
        int temperaturaMaxima = temp[0][1];
        String ciudadMinima = ciudades[0];
        String ciudadMaxima = ciudades[0];
        teclado = new Scanner(System.in);
        for (int i = 1; i < cantidadDeCiudades; i++) {
            if (temp[i][0] < temperaturaMinima){
                temperaturaMinima = temp[i][0];
                ciudadMinima = ciudades[i];
            }
            if (temp[i][1] > temperaturaMaxima){
                temperaturaMaxima = temp[i][1];
                ciudadMaxima = ciudades[i];
            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudadMinima + ", con " + temperaturaMinima + "º C.");
        System.out.println("La mayor temperatura la tuvo " + ciudadMaxima + ", con " + temperaturaMaxima + "º C.");
    }
}
