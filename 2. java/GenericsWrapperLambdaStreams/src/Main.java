import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Fiesta", "Ford", 1000.0));
        vehicles.add(new Vehicle("Focus", "Ford", 1200.0));
        vehicles.add(new Vehicle("Explorer", "Ford", 2500.0));
        vehicles.add(new Vehicle("Uno", "Fiat", 500.0));
        vehicles.add(new Vehicle("Cronos", "Fiat", 1000.0));
        vehicles.add(new Vehicle("Torino", "Fiat", 1250.0));
        vehicles.add(new Vehicle("Aveo", "Chevrolet", 1250.0));
        vehicles.add(new Vehicle("Spin", "Chevrolet", 2500.0));
        vehicles.add(new Vehicle("Corola", "Toyota", 1200.0));
        vehicles.add(new Vehicle("Fortuner", "Toyota", 3000.0));
        vehicles.add(new Vehicle("Logan", "Renault", 950.0));

        Garage garage = new Garage(1, vehicles);

        System.out.println(garage.getVehicles().size());

        //lista de vehículos ordenados por precio de menor a mayor
        System.out.println("--------------------------");
        List<Vehicle> sortedVehicles = garage.getVehicles().stream()
                //.sorted(Comparator.comparingDouble(Vehicle::getCost).reversed())
                .sorted(Comparator.comparingDouble(Vehicle::getCost))
                .collect(Collectors.toList());
        sortedVehicles.stream().forEach(vehicle -> System.out.println("Marca: " + vehicle.getMarca() + " - Modelo: " + vehicle.getModel() + " - Costo: " + vehicle.getCost()));

        System.out.println("--------------------------");

        List<Vehicle> sortedVehiclesBrand = garage.getVehicles().stream()
                .sorted(Comparator.comparing(Vehicle::getCost))
                .sorted(Comparator.comparing(Vehicle::getMarca))
                .collect(Collectors.toList());
        sortedVehiclesBrand.stream().forEach(vehicle -> System.out.println("Marca: " + vehicle.getMarca() + " - Modelo: " + vehicle.getModel() + " - Costo: " + vehicle.getCost()));

        System.out.println("--------------------------");
        List<Vehicle> filterCostList = garage.getVehicles().stream()
                .filter(vehicle -> vehicle.getCost() < 1000)
                .collect(Collectors.toList());
        filterCostList.stream().forEach(vehicle -> System.out.println("Marca: " + vehicle.getMarca() + " - Modelo: " + vehicle.getModel() + " - Costo: " + vehicle.getCost()));

        System.out.println("--------------------------");
        List<Vehicle> filterCostElderlyList = garage.getVehicles().stream()
                .filter(vehicle -> vehicle.getCost() >= 1000)
                .collect(Collectors.toList());
        filterCostElderlyList.stream().forEach(vehicle -> System.out.println("Marca: " + vehicle.getMarca() + " - Modelo: " + vehicle.getModel() + " - Costo: " + vehicle.getCost()));

        System.out.println("--------------------------");
        Double prom = garage.getVehicles().stream()
                .mapToDouble(Vehicle::getCost).average().getAsDouble();

        System.out.println("Promedio: "+ prom.shortValue());
    }
}
