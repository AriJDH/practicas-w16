package poo.ejercicioVehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {

    private long id;
    private ArrayList<Vehiculo> listaVehiculos;

    public Garaje(long id) {
        this.id = id;
        this.listaVehiculos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        this.listaVehiculos.add(vehiculo);
    }

    public void mostrarVehiculosOrdenadosPorPrecio() {
        List<Vehiculo> ordenadosPorPrecio = this.listaVehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getPrecio))
                .collect(Collectors.toList());
        ordenadosPorPrecio.forEach(System.out::println);
    }

    public void mostrarVehiculosOrdenadosPorMarcaYPrecio() {
        List<Vehiculo> ordenadosPorMarcaYPrecio = this.listaVehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getPrecio).thenComparing(Vehiculo::getMarca))
                .collect(Collectors.toList());
        ordenadosPorMarcaYPrecio.forEach(System.out::println);
    }

    public void mostrarVehiculosConPrecioMayorAMil() {
        List<Vehiculo> vehiculosConPrecioMayorAMil = this.listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .collect(Collectors.toList());
        vehiculosConPrecioMayorAMil.forEach(System.out::println);
    }

    public void mostrarVehiculosConPrecioMenorAMil() {
        List<Vehiculo> vehiculosConPrecioMenorAMil = this.listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() < 1000)
                .collect(Collectors.toList());
        vehiculosConPrecioMenorAMil.forEach(System.out::println);
    }

    public void mostrarPromedio() {
        double promedio = this.listaVehiculos.stream().mapToInt(Vehiculo::getPrecio).sum() / (double) this.listaVehiculos.size();
        System.out.println(promedio);
    }

    @Override
    public String toString() {
        return "Garaje: " + id + "," + "\nLista de vehiculos: " + listaVehiculos;
    }
}
