package clases;

public class Comida implements Reservas {

   private Double costoComida;
   private String nombreComida;

   @Override
   public void setCosto(Double costoComida) {
      this.costoComida = costoComida;
   }

   public String getNombreComida() {
      return nombreComida;
   }

   public void setNombreComida(String nombreComida) {
      this.nombreComida = nombreComida;
   }

   public Comida(Double costoComida, String nombreComida) {
      this.costoComida = costoComida;
      this.nombreComida = nombreComida;
   }

   @Override
   public String toString() {
      return " " + "(" + nombreComida + ")" + " Costo: " + costoComida;
   }

   @Override
   public Double getCosto() {
      return costoComida;
   }
}
