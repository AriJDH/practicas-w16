import java.util.ArrayList;

import clases.Garaje;
import clases.Vehiculo;

public class MainApp {
   public static void main(String[] args) {

      Vehiculo fordFiesta = new Vehiculo("Fiesta", "Ford", 1000);
      Vehiculo fordFocus = new Vehiculo("Focus", "Ford", 1200);
      Vehiculo fordExplorer = new Vehiculo("Explorer", "Ford", 2500);
      Vehiculo fiatUno = new Vehiculo("Uno", "Fiat", 500);
      Vehiculo chevroletAveo = new Vehiculo("Aveo", "Chevrolet", 1250);

      ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

      listaVehiculos.add(fordFiesta);
      listaVehiculos.add(fordFocus);
      listaVehiculos.add(fordExplorer);
      listaVehiculos.add(fiatUno);
      listaVehiculos.add(chevroletAveo);

      Garaje garaje = new Garaje(01, listaVehiculos);
      System.out.println("-------------------------------------------------");
      garaje.sortByCost();
      System.out.println("-------------------------------------------------");
      garaje.sortByMarcaThenCost();
      System.out.println("-------------------------------------------------");
      garaje.filterByCostUnder(1000);
      System.out.println("-------------------------------------------------");
      garaje.filterByCostOverAndEqual(1000);
      System.out.println("-------------------------------------------------");


   }
}
