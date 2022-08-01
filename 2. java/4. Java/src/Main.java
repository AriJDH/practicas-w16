import Automotora.Garage;
import Automotora.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo autDos = new Vehiculo("Ford","Focus",1200);
        //Vehiculo autoUno = new Vehiculo("Ford","Explorer",2500);
        //Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);
        //Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);
        //Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);
        //Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);
        //Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);
        //Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);
        //Vehiculo autoUno = new Vehiculo("Ford","Fiesta",1000);


        List<Vehiculo>lstVehiculo = new ArrayList<>();

        Garage g = new Garage();
        g.setLstVehiculo(lstVehiculo);

        lstVehiculo.stream().sorted((vehiculo, t1)-> vehiculo.getCosto().compareTo(t1.getCosto())).forEach(Vehiculo::toString);
        lstVehiculo.stream().sorted((vehiculo, t1)-> vehiculo.getMarca().compareTo(t1.getMarca())).forEach(Vehiculo::toString);
        lstVehiculo.stream().filter(v -> v.getCosto() <1000 ).forEach(Vehiculo::toString);
        lstVehiculo.stream().filter(v -> v.getCosto() >1000 ).forEach(Vehiculo::toString);
        lstVehiculo.forEach(Vehiculo::toString);
    }
}


