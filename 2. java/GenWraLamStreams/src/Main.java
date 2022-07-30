import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>(Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Flat", "Uno", 500),
                new Vehiculo("Flat", "Cronos", 1000),
                new Vehiculo("Flat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

        Garaje garaje = new Garaje("3346", listaVehiculos);

        //Expresión lambda para ordenar la colección por precio de forma ascendente
        garaje.getListaVehiculos().sort(Comparator.comparingInt(Vehiculo::getCosto));

        System.out.println("Lista ordenada por precio: ");
        System.out.println("+++++++++++++++++++++++++++++++++");
        for (Vehiculo listaVehiculo : listaVehiculos) {
            System.out.println("Precio: " + listaVehiculo.getCosto() + " Vehiculo: " +
                    listaVehiculo.getMarca() + " " + listaVehiculo.getModelo());
        }

        //Expresión lambda que ordena la lista por marca y luego por precio
        garaje.getListaVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        System.out.println();
        System.out.println("Lista ordenada por marca y luego por precio");
        System.out.println("+++++++++++++++++++++++++++++++++");
        for (Vehiculo listaVehiculo : listaVehiculos) {
            System.out.println("Precio: " + listaVehiculo.getCosto() + " Vehiculo: " +
                    listaVehiculo.getMarca() + " " + listaVehiculo.getModelo());
        }

        //Expresión lambda que extrae los vehículos cuyo precio es menor a 1000
        List<Vehiculo> menoresAMil = garaje.getListaVehiculos().stream()
                        .filter(vehiculo -> vehiculo.getCosto() < 1000)
                                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Lista de vehículos cuyo precio no supera 1000");
        System.out.println("+++++++++++++++++++++++++++++++++");
        for (Vehiculo menoresQueMil : menoresAMil) {
            System.out.println("Precio: " + menoresQueMil.getCosto() + " Vehiculo: " +
                    menoresQueMil.getMarca() + " " + menoresQueMil.getModelo());
        }

        //Expresión lambda que extrae los vehículos cuyo precio es mayor o igual a 1000
        List<Vehiculo> mayoresAMil = garaje.getListaVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Lista de vehículos cuyo precio es mayor o igual a 1000");
        System.out.println("+++++++++++++++++++++++++++++++++");
        for (Vehiculo mayoresQueMil : mayoresAMil) {
            System.out.println("Precio: " + mayoresQueMil.getCosto() + " Vehiculo: " +
                    mayoresQueMil.getMarca() + " " + mayoresQueMil.getModelo());
        }

        //Expresión lambda que devuelve el promedio de los precios de los vehículos
        double promedioPrecios = listaVehiculos.stream().mapToDouble((vehiculos) -> {
            return vehiculos.getCosto();
        }).average().getAsDouble();

        DecimalFormat decimalFormat = new DecimalFormat("0.###");
        System.out.println();
        System.out.println("El precio de los vehículos en promedio es: " + decimalFormat.format(promedioPrecios));
    }
}
