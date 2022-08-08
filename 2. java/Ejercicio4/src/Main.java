import java.util.*;

public class Main {

    public static void main(String[] args) {

        Garaje garaje = new Garaje();
        Vehiculo ford = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo flat = new Vehiculo("Flat","Uno",500);
        Vehiculo chevrolet = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo toyota = new Vehiculo("Toyota","Corola",1200);
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(ford);
        vehiculos.add(flat);
        vehiculos.add(chevrolet);
        vehiculos.add(toyota);

        garaje.setId(1);
        garaje.setVehiculos(vehiculos);

        vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));

        System.out.println("Ordenado por Precio de menor a mayor: \n");
        for (Vehiculo vehiculo: vehiculos){
            System.out.println(vehiculo);
        }

        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

        System.out.println("\nOrdenado por Marca y Precio: \n");
        for (Vehiculo vehiculo: vehiculos){
            System.out.println(vehiculo);
        }

        System.out.println("\nVehiculos con un precio menor a 1000\n");
        vehiculos.forEach(vehiculo -> {
            if (vehiculo.getCosto() < 1000) {
                System.out.println(vehiculo);
            }
        });

        System.out.println("\nVehiculos con un precio mayor o igual a 1000\n");
        vehiculos.forEach(vehiculo -> {
            if (vehiculo.getCosto() >= 1000) {
                System.out.println(vehiculo);
            }
        });

        System.out.println("\nPromedio de precios\n");

        Double promedio;
        promedio = vehiculos.stream().mapToInt(vehiculo -> vehiculo.getCosto()).average().orElse(0.0);
        System.out.println(promedio);

    }

}
