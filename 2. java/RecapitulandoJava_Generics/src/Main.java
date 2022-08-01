import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(listaVehiculos);
        System.out.println(garaje.getId());
        Garaje garaje1 = new Garaje(listaVehiculos);
        System.out.println(garaje1.getId());
    }
}
