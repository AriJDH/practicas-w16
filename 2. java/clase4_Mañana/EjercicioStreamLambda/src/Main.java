import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo v1 = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo v2 = new Vehiculo("Ford","Focus",1200);
        Vehiculo v3 = new Vehiculo("Ford","Explorer",2500);
        Vehiculo v4 = new Vehiculo("Fiat","Uno",500);
        Vehiculo v5 = new Vehiculo("Fiat","Cronos",1000);
        Vehiculo v6 = new Vehiculo("Fiat","Torino",1250);
        Vehiculo v7 = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo v8 = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo v9 = new Vehiculo("Toyota","Corolla",1200);
        Vehiculo v10 = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo v11 = new Vehiculo("Renault","Logan",950);
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);
        vehiculos.add(v8);
        vehiculos.add(v9);
        vehiculos.add(v10);
        vehiculos.add(v11);

        System.out.println("Lista ordenada por costo de menor a mayor");
        List<Vehiculo> lordenada = vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        lordenada.forEach(x -> System.out.println(x.toString()));

        System.out.println("Lista ordenada por costo y marca");
        List<Vehiculo> lOrdenadaMC = vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toList());
        lOrdenadaMC.forEach(x-> System.out.println(x.toString()));

        System.out.println("Lista con vehiculos con costo <1000");
        List<Vehiculo> menor1000 = vehiculos.stream()
                .filter(x->x.getCosto()<1000)
                .collect(Collectors.toList());
        menor1000.forEach(x-> System.out.println(x.toString()));

        System.out.println("Lista con vehiculos con costo >=1000");
        List<Vehiculo> mayor1000 = vehiculos.stream()
                .filter(x->x.getCosto()>=1000)
                .collect(Collectors.toList());
        mayor1000.forEach(x-> System.out.println(x.toString()));

        Double prom = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto).average().getAsDouble();

        System.out.println("Promedio= "+ prom.shortValue());
    }
}
