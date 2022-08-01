package clases;

import java.util.HashMap;

public abstract class Descuentos {

   public static boolean esPaqueteCompleto(Localizador localizador) {
      boolean esPaqueteCompleto = false;
      HashMap<String, Integer> hashMapReservas = localizador.getHashMapReservas();
      if (hashMapReservas.get("Hotel") != null &&
            hashMapReservas.get("BoletoDeViaje") != null &&
            hashMapReservas.get("Comida") != null &&
            hashMapReservas.get("Transporte") != null) {
         esPaqueteCompleto = true;
      }
      ;
      return esPaqueteCompleto;
   }

   public static boolean esDobleHotel(Localizador localizador) {
      boolean esDobleHotel = false;
      if (localizador.getHashMapReservas().get("BoletoDeViaje") != null) {
         if (localizador.getHashMapReservas().get("Hotel") >= 2) {
            esDobleHotel = true;
         }
      }
      ;
      return esDobleHotel;
   }

   public static boolean esDobleBoleto(Localizador localizador) {
      boolean esDobleBoleto = false;
      if (localizador.getHashMapReservas().get("BoletoDeViaje") != null) {
         if (localizador.getHashMapReservas().get("BoletoDeViaje") >= 2) {
            esDobleBoleto = true;
         }
      }
      ;
      return esDobleBoleto;
   }
}
