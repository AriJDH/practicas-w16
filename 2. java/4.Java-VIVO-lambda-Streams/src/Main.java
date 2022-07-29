import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Vehicle ford1 = new Vehicle("Fiesta", "Ford", 1000);
        Vehicle ford2 = new Vehicle("Focus", "Ford", 1200);
        Vehicle ford3 = new Vehicle("Explorer", "Ford", 2500);
        Vehicle fiat1 = new Vehicle("Uno", "Fiat", 500);
        Vehicle fiat2 = new Vehicle("Cronos", "Fiat", 1000);
        Vehicle fiat3 = new Vehicle("Torino", "Fiat", 1250);
        Vehicle chevrolet1 = new Vehicle("Aveo", "Chevrolet", 1250);
        Vehicle chevrolet2 = new Vehicle("Spin", "Chevrolet", 2500);
        Vehicle toyota1 = new Vehicle("Corola", "Toyota", 1200);
        Vehicle toyota2 = new Vehicle("Fortuner", "Toyota", 3000);
        Vehicle renault = new Vehicle("Logan", "Renault", 950);

        ArrayList<Vehicle> listOfVehicles = new ArrayList<>();

        listOfVehicles.add(ford1);
        listOfVehicles.add(ford2);
        listOfVehicles.add(ford3);
        listOfVehicles.add(fiat1);
        listOfVehicles.add(fiat2);
        listOfVehicles.add(fiat3);
        listOfVehicles.add(chevrolet1);
        listOfVehicles.add(chevrolet2);
        listOfVehicles.add(toyota1);
        listOfVehicles.add(toyota2);
        listOfVehicles.add(renault);

        System.out.println(" --- LISTA DE VEHICULOS: \n" + listOfVehicles);

        Garage garageOne = new Garage(1, listOfVehicles);
        System.out.println(" --- GARAJE:  \n" + garageOne);

        System.out.println(" --- LISTA DE VEHICULOS ORGANIZADA POR PRECIO: \n" );
        listOfVehicles.stream().sorted((x, y) -> x.getCost().compareTo(y.getCost())).forEach(System.out::println);

        System.out.println(" --- LISTA DE VEHICULOS ORGANIZADA POR MARCA Y PRECIO: \n" );
        listOfVehicles.stream().sorted(Comparator.comparing(Vehicle::getBrand).thenComparing(Vehicle::getCost)).forEach(System.out::println);

        System.out.println(" --- VEHICULOS NO MAYOR A 1000: \n" );
        listOfVehicles.stream().filter(x -> x.getCost() < 1000).forEach(System.out::println);

        System.out.println(" --- VEHICULOS MAYOR O IGUAL A 1000: \n" );
        listOfVehicles.stream().filter(x -> x.getCost() >= 1000).forEach(System.out::println);

        System.out.println(" --- PROMEDIO TOTAL DE LOS PRECIOS DE LOS VEHICULOS: \n" +
        listOfVehicles.stream().mapToDouble(x -> x.getCost()).average());

        System.out.println(" --- PROMEDIO DE LOS PRECIOS DE LOS VEHICULOS CON REF A METODOS: \n" +
        listOfVehicles.stream().mapToDouble(Vehicle::getCost).average());

    }
}