import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1000 );
        vehiculos.add(vehiculo1);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",1200 );
        vehiculos.add(vehiculo2);
        Vehiculo vehiculo3 = new Vehiculo("Ford","Explorer",2500 );
        vehiculos.add(vehiculo3);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Uno",500 );
        vehiculos.add(vehiculo4);
        Vehiculo vehiculo5 = new Vehiculo("Fiat","Cronos",1000 );
        vehiculos.add(vehiculo5);
        Vehiculo vehiculo6 = new Vehiculo("Fiat","Torino",1250 );
        vehiculos.add(vehiculo6);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet","Aveo",1250 );
        vehiculos.add(vehiculo7);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet","Spin",2500 );
        vehiculos.add(vehiculo8);
        Vehiculo vehiculo9 = new Vehiculo("Toyota","Corola",1200 );
        vehiculos.add(vehiculo9);
        Vehiculo vehiculo10 = new Vehiculo("Toyota","Fortuner",3000 );
        vehiculos.add(vehiculo10);
        Vehiculo vehiculo11 = new Vehiculo("Renault","Logan",950 );
        vehiculos.add(vehiculo11);
        Garaje garaje1 = new Garaje(1, vehiculos);

        List<Vehiculo> vehiculosOrdenadosPorCosto = vehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("Ordenados por costo : " +vehiculosOrdenadosPorCosto);

        List<Vehiculo> vehiculosOrdenadosPorMarcaYCosto= vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("Ordenados por marca y costo : "+vehiculosOrdenadosPorMarcaYCosto);

        List<Vehiculo> vehiculosDeCostoMenorA1000=vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000)
                .collect(Collectors.toList());
        System.out.println("Vehiculos de costo menor que 1000: " +vehiculosDeCostoMenorA1000);

        List<Vehiculo> vehicuLosDecostoMayorA1000=vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto()>=1000)
                .collect(Collectors.toList());;
        System.out.println("Vehiculos de costo mayor que 1000" + vehicuLosDecostoMayorA1000);

        List<Vehiculo> vehiculosDeCosto1000=vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto()==1000)
                .collect(Collectors.toList());;
        System.out.println("Vehiculos de costo igual que 1000" + vehiculosDeCosto1000);
    }
}
