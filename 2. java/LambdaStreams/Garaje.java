package LambdaStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {
    private int nextVehiculoId;
    List<Vehiculo> vehiculos;
    public Garaje() {
        this.nextVehiculoId = 0;
        this.vehiculos = new ArrayList<Vehiculo>();
    }
    public Vehiculo addVehicule(String modelo, String marca, int costo) {
        Vehiculo vehiculo = new Vehiculo(this.nextVehiculoId, modelo, marca, costo);
        this.nextVehiculoId++;
        vehiculos.add(vehiculo);
        return vehiculo;
    }
    public List<Vehiculo>  orderByPrice() {
        return this.vehiculos.stream().sorted((o1, o2) -> {
            if(o1.getCosto() > o2.getCosto()) return 1;
            return -1;
        }).collect(Collectors.toList());
    }

    public List<Vehiculo>  orderByBrandAndPrice() {
        Comparator<Vehiculo> c = (o1, o2) -> o1.getMarca().compareTo(o2.getMarca());
        c = c.thenComparing((o1, o2) -> {
            if(o1.getCosto() > o2.getCosto()) return 1;
            return -1;
        });
        return this.vehiculos.stream().sorted(c)
                .collect(Collectors.toList());
    }
    public void showOrderByPrice() {
        this.orderByPrice().forEach((v) -> System.out.println(v.toString()));
    }
    public void showOrderByBrandAndPrice() {
        this.orderByBrandAndPrice()
                .forEach((v) -> System.out.println(v.toString()));
    }
    public List<Vehiculo> getVehiculesLowerThan(int price) {
        return this.vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < price).collect(Collectors.toList());
    }
    public List<Vehiculo> getVehiculesHigherAndEqualThan(int price) {
        return this.vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() > price).collect(Collectors.toList());
    }
    public double getAveragePrice() {
        return this.vehiculos
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0d);
    }
}
