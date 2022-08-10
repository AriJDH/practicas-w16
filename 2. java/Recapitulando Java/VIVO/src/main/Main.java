package main;

import clases.Garaje;
import clases.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo fordFiesta = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo fordFocus = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo fordExplorer = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo fiatUno = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo fiatCronos = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo fiatTorino = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo chevroletAveo = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo chevroletSpin = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo toyotaCorola = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo toyotaFortuner = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo renaultLogan = new Vehiculo("Fiesta", "Renault", 950);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(fordFiesta, fordFocus, fordExplorer, fiatUno, fiatCronos, fiatTorino, chevroletAveo, chevroletSpin, toyotaCorola, toyotaFortuner, renaultLogan));
        Garaje garaje = new Garaje(1, vehiculos);

        garaje.getVehiculosList().forEach(System.out::println);
        System.out.println("\n\n");

        /* Ejercicio 3
        garaje.getVehiculosList().sort((a,b) -> ((Double) a.getCosto()).compareTo(b.getCosto()));
        garaje.getVehiculosList().forEach(System.out::println);
        */

        /* Ejercicio 4
        //garaje.getVehiculosList().sort((a,b) -> ((Double) a.getCosto()).compareTo(b.getCosto()));
        //garaje.getVehiculosList().sort((a,b) -> (a.getMarca()).compareTo(b.getMarca()));
        garaje.getVehiculosList().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        garaje.getVehiculosList().forEach(System.out::println);
        */

        /* Ejercicio 5*/
        //Vehiculos baratos
        garaje.getVehiculosList().stream().filter(a -> a.getCosto() < 1000).forEach(System.out::println);
        //Vehiculos mayor a 1000
        garaje.getVehiculosList().stream().filter(a -> a.getCosto() >= 1000).forEach(System.out::println);
        //Promedio de vehiculos
        garaje.getVehiculosList().stream().filter(a -> a.getCosto() < 1000).forEach(System.out::println);


        int[] array = new int[5];
        array[0]=1;
        array[1]=10;
        array[2]=14;
        array[3]=2;
        array[4]=8;
        for (int i: burbuja(array)){
            System.out.println(i);
        }


    }

    public static int[] burbuja(int[] array){
        Arrays.sort(array);
        return array;
    }
}
