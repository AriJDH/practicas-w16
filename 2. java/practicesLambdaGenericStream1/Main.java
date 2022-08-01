package practicesLambdaGenericStream1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> listCars = createCars();
        Garage garage = new Garage(1, listCars);

        // Ordenar vehiculos por costo de menor a mayor
        System.out.println("-----Ordenar vehiculos por costo de menor a mayor-----");
        garage.getListCars().stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Ordernar vehiculos por marca y despues por costo
        System.out.println("-----Ordernar vehiculos por marca y despues por costo-----");
        garage.getListCars().sort(Comparator.comparing(Car::getBrand).thenComparing(Car::getPrice));
        garage.getListCars().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Ordenar vehiculos por marca y despues por costo (segunda forma)
        System.out.println("-----Ordenar vehiculos por marca y despues por costo (segunda forma)-----");
        garage.getListCars().stream()
                .sorted(Comparator.comparing(Car::getBrand).thenComparing(Car::getPrice))
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Filtras los vehiculos cuyo costo es menor o igual a 1000 (devolves otra lista)
        System.out.println("-----Filtras los vehiculos cuyo costo es menor o igual a 1000 (devolves otra lista)-----");
        List<Car> listFilterPrice1 = garage.getListCars().stream()
                .filter((car) -> car.getPrice() <= 1000)
                .collect(Collectors.toList());
        listFilterPrice1.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Filtras vehiculos cuyo costo es mayor o igual a 1000 (devolves otra lista)
        System.out.println("-----Filtras vehiculos cuyo costo es mayor o igual a 1000 (devolves otra lista)-----");
        List<Car> listFilterPrice2 = garage.getListCars().stream()
                .filter((car) -> car.getPrice() >= 1000 )
                .collect(Collectors.toList());
        listFilterPrice2.forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

        // Calculando el promedio de costos de todos los vehiculos
        System.out.println("-----Calculando el promedio de costos de todos los vehiculos-----");
        System.out.println(garage.getListCars()
                .stream()
                .mapToDouble(Car::getPrice).average().getAsDouble());
        System.out.println("------------------------------------------------------------------");

    }

    private static List<Car> createCars() {

        Car car1 = new Car("Ford","Fiesta",1000);
        Car car2 = new Car("Ford","Focus",1200);
        Car car3 = new Car("Ford","Explorer",2500);
        Car car4 = new Car("Fiat","Uno",500);
        Car car5 = new Car("Fiat","Cronos",1000);
        Car car6 = new Car("Fiat","Torino",1250);
        Car car7 = new Car("Chevrolet","Aveo",1250);
        Car car8 = new Car("Chevrolet","Spin",2500);
        Car car9 = new Car("Toyota","Corola",1200);
        Car car10 = new Car("Toyota","Fortuner",3000);
        Car car11 = new Car("Renault","Logan",950);

        List<Car> listCar = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11));

        return listCar;
    }
}
