import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> autos = new ArrayList<>();

        Vehiculo auto1= new Vehiculo("Fiesta","Ford",1000);
        Vehiculo auto2= new Vehiculo("Focus","Ford",1200);
        Vehiculo auto3= new Vehiculo("Explorer","Ford",2500);
        Vehiculo auto4= new Vehiculo("Uno","Fiat",500);
        Vehiculo auto5= new Vehiculo("Cronos","Fiat",1000);
        Vehiculo auto6= new Vehiculo("Torino","Fiat",1250);
        Vehiculo auto7= new Vehiculo("Aveo","Chevrolet",1250);
        Vehiculo auto8= new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo auto9= new Vehiculo("Corola","Toyota",1200);
        Vehiculo auto10= new Vehiculo("Fortuner","Toyota",1000);
        Vehiculo auto11= new Vehiculo("Logan","Renault",950);

        autos.add(auto1);
        autos.add(auto2);
        autos.add(auto3);
        autos.add(auto4);
        autos.add(auto5);
        autos.add(auto6);
        autos.add(auto7);
        autos.add(auto8);
        autos.add(auto9);
        autos.add(auto10);
        autos.add(auto11);

        Garage garage = new Garage(01,autos);

        garage.getAutos().stream().sorted((x,y)->x.getMarca().compareToIgnoreCase(y.getMarca())).forEach(System.out::println);
        System.out.println("----------------\n");
        garage.getAutos().stream().sorted((x,y)->x.getModelo().compareToIgnoreCase(y.getModelo())).forEach(System.out::println);
        System.out.println("----------------\n");
        garage.getAutos().stream().sorted( Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("----------------\n Mayor a 1000");
        garage.getAutos().stream().filter(x-> x.getCosto()>1000).forEach(System.out::println);
        System.out.println("----------------\n Menor o igual 1000");
        garage.getAutos().stream().filter(x-> x.getCosto()<=1000).forEach(System.out::println);

    }
}
