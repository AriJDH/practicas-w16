package clases;

public class Vehiculo {
   String modelo;
   String marca;
   Integer costo;

   public String getModelo() {
      return modelo;
   }
   public void setModelo(String modelo) {
      this.modelo = modelo;
   }
   public String getMarca() {
      return marca;
   }
   public void setMarca(String marca) {
      this.marca = marca;
   }
   public Integer getCosto() {
      return costo;
   }
   public void setCosto(Integer costo) {
      this.costo = costo;
   }
   public Vehiculo(String modelo, String marca, Integer costo) {
      this.modelo = modelo;
      this.marca = marca;
      this.costo = costo;
   }

   @Override
   public String toString() {
      return "Vehiculo [costo=" + costo + ", marca=" + marca + ", modelo=" + modelo + "]";
   }

}
