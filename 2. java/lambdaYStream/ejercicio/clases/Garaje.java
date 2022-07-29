package clases;

import java.util.ArrayList;
import java.util.Comparator;

public class Garaje {

   Integer id;
   ArrayList<Vehiculo> vehiculosEnGaraje;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public ArrayList<Vehiculo> getVehiculosEnGaraje() {
      return vehiculosEnGaraje;
   }

   public void setVehiculosEnGaraje(ArrayList<Vehiculo> vehiculosEnGaraje) {
      this.vehiculosEnGaraje = vehiculosEnGaraje;
   }

   public Garaje(Integer id, ArrayList<Vehiculo> vehiculosEnGaraje) {
      this.id = id;
      this.vehiculosEnGaraje = vehiculosEnGaraje;
   }

   @Override
   public String toString() {
      return "Garaje [id=" + id + ", vehiculosEnGaraje=" + vehiculosEnGaraje + "]";
   }

   public void sortByCost () {
      vehiculosEnGaraje.stream()
         .sorted(
            Comparator.comparing((Vehiculo vehiculo) -> vehiculo.costo)
         ).forEach(value -> System.out.println(value));
   }

   public void sortByMarcaThenCost () {
      vehiculosEnGaraje.stream()
         .sorted(
            Comparator.comparing((Vehiculo vehiculo) -> vehiculo.marca)
            .thenComparing(
               Comparator.comparing((Vehiculo vehiculo) -> vehiculo.costo)
            )
         ).forEach(value -> System.out.println(value));
   }

   public void filterByCostUnder(Integer i){
      vehiculosEnGaraje.stream()
      .filter(vehiculo -> vehiculo.costo < i)
      .forEach(vehiculo -> System.out.println(vehiculo));
      ;

   }

   public void filterByCostOverAndEqual(Integer i){
      vehiculosEnGaraje.stream()
      .filter(vehiculo -> vehiculo.costo >= i)
      .forEach(vehiculo -> System.out.println(vehiculo));
      ;
   }

}
