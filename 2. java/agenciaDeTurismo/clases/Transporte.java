package clases;

public class Transporte implements Reservas {

   private Double costoTransporte;
   private String nombreTransporte;

   @Override
   public Double getCosto() {
      return costoTransporte;
   }

   @Override
   public void setCosto(Double costoTransporte) {
      this.costoTransporte = costoTransporte;
   }

   public String getNombreTransporte() {
      return nombreTransporte;
   }

   public void setNombreTransporte(String nombreTransporte) {
      this.nombreTransporte = nombreTransporte;
   }

   public Transporte(Double costoTransporte, String nombreTransporte) {
      this.costoTransporte = costoTransporte;
      this.nombreTransporte = nombreTransporte;
   }

   @Override
   public String toString() {
      return " " + "(" + nombreTransporte + ")" + " Costo: " + costoTransporte;
   }
}
