package clases;

public class BoletoDeViaje implements Reservas {

   private Double costoBoleto;
   private String nombreBoleto;

   @Override
   public Double getCosto() {
      return costoBoleto;
   }

   @Override
   public void setCosto(Double costoBoleto) {
      this.costoBoleto = costoBoleto;
   }

   public String getNombreBoleto() {
      return nombreBoleto;
   }

   public void setNombreBoleto(String nombreBoleto) {
      this.nombreBoleto = nombreBoleto;
   }

   public BoletoDeViaje(Double costoBoleto, String nombreBoleto) {
      this.costoBoleto = costoBoleto;
      this.nombreBoleto = nombreBoleto;
   }

   @Override
   public String toString() {
      return " " + "(" + nombreBoleto + ")" + " Costo: " + costoBoleto;
   }
}
