import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Garage {

    private final UUID id;
    private List<Vehiculo> vehiculos;

    public Garage(UUID id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public UUID getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void imprimirVehiculosOrdenadosPorPrecioDeFormaAscendente() {
        List<Vehiculo> vehiculosOrdenados =
                vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).collect(Collectors.toList());

        imprimir(vehiculosOrdenados);
    }

    public void imprimirVehiculosOrdenadosPorMarcaYPrecio() {
        List<Vehiculo> vehiculosOrdenados =
                vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).collect(Collectors.toList());

        imprimir(vehiculosOrdenados);
    }

    private void imprimir(List<Vehiculo> vehiculos) {
        vehiculos.forEach(System.out::println);
    }

    public void vehiculosQueCumplan(Predicate<Vehiculo> unaCondicion) {
        List<Vehiculo> vehiculosFiltrados =
                vehiculos.stream().filter(vehiculo -> unaCondicion.test(vehiculo)).collect(Collectors.toList());

        imprimir(vehiculosFiltrados);
    }

    public void promedioTotalDePrecios() {
        Double sumatoriaDePrecios = vehiculos.stream().mapToDouble(Vehiculo::getCosto).sum();

        System.out.println("Promedio de precios = " + sumatoriaDePrecios / vehiculos.size());
    }
}
