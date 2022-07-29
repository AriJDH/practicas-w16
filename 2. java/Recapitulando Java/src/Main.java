import clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        ejercicio3();
        ejercicio4();
        ejercicio5();


    }


    public static void ejercicio3() {
        System.out.println("Ejercicio 3");

        List<Vehiculo> lstVehiculos = new ArrayList<Vehiculo>();

        popularVehiculos(lstVehiculos);

        lstVehiculos.sort((b, a) -> Double.compare(b.getCosto(), a.getCosto()));

        lstVehiculos.stream().forEach(vehiculo -> {
            System.out.println(vehiculo.toString());
        });
    }

    public static void ejercicio4() {
        System.out.println("Ejercicio 4");

        List<Vehiculo> lstVehiculos1 = new ArrayList<Vehiculo>();
        List<Vehiculo> sortedVehiculos1 = new ArrayList<Vehiculo>();

        popularVehiculos(lstVehiculos1);

        Comparator<Vehiculo> marcaAsc = Comparator.comparing(Vehiculo::getMarca);
        Comparator<Vehiculo> costoAsc = Comparator.comparing(Vehiculo::getCosto);

        Comparator<Vehiculo> compararMarcaCosto = marcaAsc.thenComparing(costoAsc);

        lstVehiculos1.stream()
                .sorted(compararMarcaCosto)
                .collect(Collectors.toList())
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));
    }

    public static void ejercicio5() {
        System.out.println("Ejercicio 5");
        List<Vehiculo> lstVehiculos2 = new ArrayList<Vehiculo>();
        List<Vehiculo> sortedVehiculos2 = new ArrayList<Vehiculo>();

        Double sum = 0.0d;
        Double promedio = 0.0d;

        popularVehiculos(lstVehiculos2);

        System.out.println("----Costo no mayor a 1000---");

        lstVehiculos2.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));


        System.out.println("----Costo mayor o igual a 1000---");

        lstVehiculos2.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(vehiculo -> System.out.println(vehiculo.toString()));

        sum=lstVehiculos2.stream()
                .map(vehiculo -> vehiculo.getCosto())
                .reduce(0.0d, (a,b)->a+b);

        promedio = sum/ lstVehiculos2.stream().count();

        System.out.println("-------");
        System.out.println("El promedio es: " + promedio);

    }

    public static void popularVehiculos(List<Vehiculo> list) {
        Vehiculo vehiculo = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo3 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo6 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo8 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo10 = new Vehiculo("Renault", "Logan", 950);

        list.add(vehiculo);
        list.add(vehiculo1);
        list.add(vehiculo2);
        list.add(vehiculo3);
        list.add(vehiculo4);
        list.add(vehiculo5);
        list.add(vehiculo6);
        list.add(vehiculo7);
        list.add(vehiculo8);
        list.add(vehiculo9);
        list.add(vehiculo10);

    }
}
