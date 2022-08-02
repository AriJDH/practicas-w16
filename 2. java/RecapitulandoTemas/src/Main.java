import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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


        List<Vehiculo> vehiculoList = new ArrayList<Vehiculo>();
        vehiculoList.add(fordFiesta);
        vehiculoList.add(fordFocus);
        vehiculoList.add(fordExplorer);
        vehiculoList.add(fiatUno);
        vehiculoList.add(fiatCronos);
        vehiculoList.add(fiatTorino);
        vehiculoList.add(chevroletAveo);
        vehiculoList.add(chevroletSpin);
        vehiculoList.add(toyotaCorola);
        vehiculoList.add(toyotaFortuner);
        vehiculoList.add(renaultLogan);

        Garage garage = new Garage(1,vehiculoList);


        garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
        garage.getVehiculos().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        vehiculoList.stream().sorted((vehiculo, t1)-> vehiculo.getCosto().compareTo(t1.getCosto())).forEach(Vehiculo::toString);
        vehiculoList.stream().sorted((vehiculo, t1)-> vehiculo.getMarca().compareTo(t1.getMarca())).forEach(Vehiculo::toString);
        vehiculoList.stream().filter(v -> v.getCosto() <1000 ).forEach(Vehiculo::toString);
        vehiculoList.stream().filter(v -> v.getCosto() >1000 ).forEach(Vehiculo::toString);
        vehiculoList.forEach(Vehiculo::toString);










    }
}
