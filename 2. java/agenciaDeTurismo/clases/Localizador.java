package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Localizador {

   private ArrayList<Reservas> reservas;
   private Cliente cliente;
   private Double subTotal;
   private Double total;
   private ArrayList<Integer> descuentosInteger;
   private ArrayList<String> descuentosString;
   private HashMap<String, Integer> hashMapReservas;

   public ArrayList<Reservas> getReservas() {
      return reservas;
   }

   public HashMap<String, Integer> getHashMapReservas() {
      return hashMapReservas;
   }

   public ArrayList<String> getDescuentosString() {
      return descuentosString;
   }

   public ArrayList<Integer> getDescuentosInteger() {
      return descuentosInteger;
   }

   public Double getSubTotal() {
      return subTotal;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public Integer getDescuentosTotal() {
      Integer returnInt = 0;
      for (Integer descuento : descuentosInteger) {
         returnInt += descuento;
      }
      return returnInt;
   }

   public void setHashMapReservas(HashMap<String, Integer> hashMapReservas) {
      this.hashMapReservas = hashMapReservas;
   }

   public void setSubTotal(Double subTotal) {
      this.subTotal = subTotal;
   }

   public void setTotal(Double total) {
      this.total = total;
   }

   public void setDescuentosString(String descuentosString) {
      this.descuentosString.add(descuentosString);
   }

   public void setDescuentosInteger(Integer descuentosInteger) {
      this.descuentosInteger.add(descuentosInteger);
   }

   public void setReservas(ArrayList<Reservas> reservas) {
      this.reservas = reservas;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public Localizador(ArrayList<Reservas> reservas, Cliente cliente) {
      this.descuentosString = new ArrayList<>();
      this.descuentosInteger = new ArrayList<>();
      this.hashMapReservas = new HashMap<>();
      this.reservas = reservas;
      this.cliente = cliente;
      this.subTotal = calcularSubTotal();
      this.total = 0.0;
      createHashMapReservas(reservas);
   }

   private void createHashMapReservas(ArrayList<Reservas> reservas) {
      for (int i = 0; i < reservas.size(); i++) {
         if (hashMapReservas.get(reservas.get(i).getClass().getSimpleName()) != null) {
            hashMapReservas.put(reservas.get(i).getClass().getSimpleName(),
                  hashMapReservas.get(reservas.get(i).getClass().getSimpleName()) + 1);
         } else {
            hashMapReservas.put(reservas.get(i).getClass().getSimpleName(), 1);
         }
      }
   }

   protected Double calcularSubTotal() {
      Double subtotal = 0.0;
      for (Reservas reserva : reservas) {
         subtotal += reserva.getCosto();
      }
      return subtotal;
   }

   private String reservasToString() {
      String returnString = "\n";
      for (Reservas reserva : reservas) {
         returnString = returnString + "Tipo de reserva: " + "--" + reserva + "\n";
      }
      return returnString;
   }

   private String descuentosToString() {
      String returnString = "\n";
      if (descuentosInteger.size() == 0) {
         for (int i = 0; i < descuentosString.size(); i++) {
            returnString = returnString + descuentosString.get(i) + "\n";
         }
      } else {
         for (int i = 0; i < descuentosString.size(); i++) {
            returnString = returnString + descuentosString.get(i) + ":" + descuentosInteger.get(i) + "% \n";
         }
      }
      return returnString;
   }



   protected void aplicarDescuentoPorDobleHotel() {
      reservas.stream()
            .filter(reserva -> reserva instanceof Hotel)
            .forEach(reserva -> reserva.setCosto(reserva.getCosto() - ((reserva.getCosto() * 5) / 100)));
      ;
   }

   protected void aplicarDescuentoPorDobleBoleto() {
      reservas.stream()
            .filter(reserva -> reserva instanceof BoletoDeViaje)
            .forEach(reserva -> reserva.setCosto(reserva.getCosto() - ((reserva.getCosto() * 5) / 100)));
      ;
   }

   @Override
   public String toString() {
      return "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() + "\n" +
            "Descripcion del paquete: \n" +
            "==================================================== \n" +
            reservasToString() + "\n" +
            "==================================================== \n" +
            "Sub Total: " + subTotal + "\n" +
            "==================================================== \n" +
            "Descuentos: \n" +
            descuentosToString() +
            "==================================================== \n" +
            "Total: " + total;
   }

}
