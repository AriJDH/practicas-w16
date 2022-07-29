import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos =
                List.of(
                        new Vehiculo("Ford", "Fiesta", 1000d),
                        new Vehiculo("Ford", "Focus", 1200d),
                        new Vehiculo("Ford", "Explorer", 2500d),
                        new Vehiculo("Fiat", "Uno", 500d),
                        new Vehiculo("Fiat", "Cronos", 1000d),
                        new Vehiculo("Fiat", "Torino", 1250d),
                        new Vehiculo("Chevrolet", "Aveo", 1250d),
                        new Vehiculo("Chevrolet", "Spin", 2500d),
                        new Vehiculo("Toyota", "Corola", 1200d),
                        new Vehiculo("Toyota", "Fortuner", 3000d),
                        new Vehiculo("Renault", "Logan", 950d)
                );

        Garage garage = new Garage(UUID.randomUUID(), vehiculos);

        garage.imprimirVehiculosOrdenadosPorPrecioDeFormaAscendente();

        System.out.println("==============");

        garage.imprimirVehiculosOrdenadosPorMarcaYPrecio();

        System.out.println("==============");

        Predicate<Vehiculo> precioMenorA1000 = vehiculo -> vehiculo.getCosto() < 1000;
        garage.vehiculosQueCumplan(precioMenorA1000);

        System.out.println("==============");

        Predicate<Vehiculo> precioMayorOIgualA1000 = vehiculo -> vehiculo.getCosto() >= 1000;
        garage.vehiculosQueCumplan(precioMayorOIgualA1000);

        System.out.println("==============");

        garage.promedioTotalDePrecios();
    }
}
