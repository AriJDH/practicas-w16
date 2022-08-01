package clases;

import java.util.ArrayList;

public class Repositorio {

   ArrayList<Localizador> localizadores;

   public ArrayList<Localizador> getLocalizadores() {
      return localizadores;
   }

   public void setLocalizadores(ArrayList<Localizador> localizadores) {
      this.localizadores = localizadores;
   }

   public Repositorio() {
      this.localizadores = new ArrayList<>();
   }

   public Repositorio(ArrayList<Localizador> localizadores) {
      this.localizadores = localizadores;
   }

   public void guardarLocalizador(Localizador localizador) {

      if (Descuentos.esPaqueteCompleto(localizador)) {
         localizador.setDescuentosString("Descuento por paquete completo");
         localizador.setDescuentosInteger(10);
      }
      if (localizador.getCliente().getCantidadDeLocalizadores() >= 2) {
         localizador.setDescuentosString("Descuento por cliente recurrente");
         localizador.setDescuentosInteger(5);
      }
      if (Descuentos.esDobleHotel(localizador)){
         localizador.setDescuentosString("Descuento por compra de 2 reservas de Hoteles");
         localizador.aplicarDescuentoPorDobleHotel();
         localizador.setSubTotal(localizador.calcularSubTotal());
      }
      if (Descuentos.esDobleBoleto(localizador)){
         localizador.setDescuentosString("Descuento por compra de 2 reservas de Boletos");
         localizador.aplicarDescuentoPorDobleBoleto();
         localizador.setSubTotal(localizador.calcularSubTotal());
      }
      if (localizador.getDescuentosTotal() != 0) {
         localizador.setTotal(
               localizador.getSubTotal() - ((localizador.getSubTotal() * localizador.getDescuentosTotal()) / 100));
      } else {
         localizador.setTotal(localizador.getSubTotal());
      }
      localizador.getCliente().setCantidadDeLocalizadores(1);
      System.out.println(localizador);
   }

}
