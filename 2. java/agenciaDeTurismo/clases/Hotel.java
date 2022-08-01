package clases;

public class Hotel implements Reservas {

   private Double costoHotel;
   private String nombreHotel;

   @Override
   public Double getCosto() {
      return costoHotel;
   }

   public Hotel(Double costoHotel, String nombreHotel) {
      this.costoHotel = costoHotel;
      this.nombreHotel = nombreHotel;
   }

   public String getNombreHotel() {
      return nombreHotel;
   }

   public void setNombreHotel(String nombreHotel) {
      this.nombreHotel = nombreHotel;
   }

   @Override
   public String toString() {
      return " " + "(" + nombreHotel + ")" + " Costo: " + costoHotel;
   }

   @Override
   public void setCosto(Double costoHotel) {
      this.costoHotel = costoHotel;
   }

}
