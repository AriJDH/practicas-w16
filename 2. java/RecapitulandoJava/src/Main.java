import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);
//Ejercicio 2
        ArrayList<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7, vehiculo8, vehiculo9, vehiculo10, vehiculo11));
        Garage garage = new Garage(1, vehiculos);

//Ejercicio 3 obtén una lista de vehículos ordenados por precio de menor a mayor,
// imprime por pantalla el resultado.

        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n Otro ejercicio \n");

//Ejercicio 4 imprime una lista ordenada por marca y a su vez por precio.
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

//Ejercicio 5
//extraer una lista de vehículos con precio no mayor a 1000

        System.out.println("\n lista de vehículos con precio no mayor a 1000 \n");

        vehiculos.stream().filter(x -> x.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("\n precios mayor o igual 1000 \n");
        vehiculos.stream().filter(x -> x.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("\n Promedio \n");
        double promedio = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average().getAsDouble();

        System.out.println(promedio);
    }
}
