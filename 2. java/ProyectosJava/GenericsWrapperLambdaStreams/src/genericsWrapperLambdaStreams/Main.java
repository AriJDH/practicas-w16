
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Vehiculo fordFiesta = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo fordFocus= new Vehiculo("Ford", "Focus", 1200);
        Vehiculo fordExplorer= new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo fiatUno= new Vehiculo("Fiat", "Uno", 500);
        Vehiculo fiatCronos= new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo fiatTorino= new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo chevroletAveo= new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo chevroletSpin= new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo toyotaCorola= new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo toyotaFortuner= new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo renaultLogan= new Vehiculo("Renault", "Logan", 950);


        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(fordFiesta);
        listaVehiculos.add(fordFocus);
        listaVehiculos.add(fordExplorer);
        listaVehiculos.add(fiatUno);
        listaVehiculos.add(fiatCronos);
        listaVehiculos.add(fiatTorino);
        listaVehiculos.add(chevroletAveo);
        listaVehiculos.add(chevroletSpin);
        listaVehiculos.add(toyotaCorola);
        listaVehiculos.add(toyotaFortuner);
        listaVehiculos.add(renaultLogan);

        Garage g = new Garage();
        g.setListaDeVeiculos(listaVehiculos);


        listaVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        listaVehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println);

        List<Vehiculo> listaMenores1000 = listaVehiculos.stream()
                .filter(x -> x.getCosto() < 1000)
                .collect(Collectors.toList());

        listaMenores1000.forEach(System.out::println);

        List<Vehiculo> listaMayores1000 = listaVehiculos.stream()
                .filter(x -> x.getCosto() >= 1000)
                .collect(Collectors.toList());

        listaMayores1000.forEach(System.out::println);


    }
}
