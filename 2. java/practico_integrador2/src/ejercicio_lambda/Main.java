package ejercicio_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static int[] burbuja(int[] array) {
        Arrays.sort(array);
        return array;
    }



    public static void main(String[] args) {



        Garage garage = new Garage();
        Vehiculo uno = new Vehiculo("FORD", "FIESTA", 1000.0);
        Vehiculo dos = new Vehiculo("FORD", "FOCUS", 1200.0);
        Vehiculo tres = new Vehiculo("FORD", "EXPLORER", 2600.0);
        Vehiculo cuatro = new Vehiculo("FIAT", "UNO", 500.0);
        Vehiculo cinco = new Vehiculo("FIAT", "CRONOS", 1000.0);
        Vehiculo seis = new Vehiculo("FIAT", "TORINO", 1250.0);
        Vehiculo siete = new Vehiculo("CHEVROLET", "AVEO", 1250.0);
        Vehiculo ocho = new Vehiculo("CHEVROLET", "SPIN", 2500.0);
        Vehiculo nueve = new Vehiculo("TOYOTA", "COROLA", 1200.0);
        Vehiculo diez = new Vehiculo("TOYOTA", "FORTUNER", 3000.0);
        Vehiculo once = new Vehiculo("RENAULT", "LOGAN", 950.0);
        garage.getVehiculos().add(uno);
        garage.getVehiculos().add(dos);
        garage.getVehiculos().add(tres);
        garage.getVehiculos().add(cuatro);
        garage.getVehiculos().add(cinco);
        garage.getVehiculos().add(seis);
        garage.getVehiculos().add(siete);
        garage.getVehiculos().add(ocho);
        garage.getVehiculos().add(nueve);
        garage.getVehiculos().add(diez);
        garage.getVehiculos().add(once);

//        ejercicio 3
        garage.getVehiculos().stream().sorted((vehiculo1, vehiculo2) -> vehiculo1.getCosto().compareTo(vehiculo2.getCosto())).forEach(System.out::println);
        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);


        //ejercicio 4

        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(vehiculo -> System.out.println(vehiculo));


        // ejercicio 5
        garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .forEach(vehiculo -> System.out.println(vehiculo));

        garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println(garage.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).sum() / garage.getVehiculos().size());


    }




}

