package generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    //creating vehicles
    Vehicle fordFiesta = new Vehicle("Ford","Fiesta",1000);
    Vehicle fordFocus= new Vehicle("Ford", "Focus", 1200);
    Vehicle fordExplorer= new Vehicle("Ford", "Explorer", 2500);
    Vehicle fiatUno= new Vehicle("Fiat", "Uno", 500);
    Vehicle fiatCronos= new Vehicle("Fiat", "Cronos", 1000);
    Vehicle fiatTorino= new Vehicle("Fiat", "Torino", 1250);
    Vehicle chevroletAveo= new Vehicle("Chevrolet", "Aveo", 1250);
    Vehicle chevroletSpin= new Vehicle("Chevrolet", "Spin", 2500);
    Vehicle toyotaCorola= new Vehicle("Toyota", "Corola", 1200);
    Vehicle toyotaFortuner= new Vehicle("Toyota", "Fortuner", 3000);
    Vehicle renaultLogan= new Vehicle("Renault", "Logan", 950);
    //declare array
    List<Vehicle> listVehicles = new ArrayList<>();
    //add vehicles to array
    listVehicles.add(fordFiesta);
    listVehicles.add(fordFocus);
    listVehicles.add(fordExplorer);
    listVehicles.add(fiatUno);
    listVehicles.add(fiatCronos);
    listVehicles.add(fiatTorino);
    listVehicles.add(chevroletAveo);
    listVehicles.add(chevroletSpin);
    listVehicles.add(toyotaCorola);
    listVehicles.add(toyotaFortuner);
    listVehicles.add(renaultLogan);

    Garage g = new Garage();
    g.setlistVehicles(listVehicles);
    //Lambdas
    listVehicles.stream()
        .sorted(Comparator.comparing(Vehicle::getprice))
        .forEach(System.out::println);

    listVehicles.stream()
        .sorted(Comparator.comparingInt(Vehicle::getprice))
        .sorted(Comparator.comparing(Vehicle::getbrand))
        .forEach(System.out::println);

    List<Vehicle> listMin1000 = listVehicles.stream()
        .filter(x -> x.getprice() < 1000)
        .collect(Collectors.toList());

    listMin1000.forEach(System.out::println);

    List<Vehicle> listMax1000 = listVehicles.stream()
        .filter(x -> x.getprice() >= 1000)
        .collect(Collectors.toList());

    listMax1000.forEach(System.out::println);
  }
}
