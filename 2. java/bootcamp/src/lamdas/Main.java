package lamdas;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.0));
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.0));

        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.0));

        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));

        vehiculos.add(new Vehiculo("Toyota", "Fortune", 3000.0));
        vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200.0));

        vehiculos.add(new Vehiculo("Renault", "Logan", 950.0));


        Garage g = new Garage(vehiculos, 1234);

        //por precio
        //g.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).forEach(System.out::println);

        //por marca y precio
       /* g.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).
                sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println); */

        //g.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio));

        //g.getVehiculos().stream().filter(vehiculo -> vehiculo.getPrecio() < 1000).forEach(System.out::println);
        //g.getVehiculos().stream().filter(vehiculo -> vehiculo.getPrecio() >= 1000).forEach(System.out::println);

        //System.out.println(g.getVehiculos().stream().mapToDouble((Vehiculo::getPrecio)).average().getAsDouble());


        int[] array = new int[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 1;
        array[3] = 0;
        array[4] = 5;
        Arrays.stream(array).sorted().toArray();
    }
}
