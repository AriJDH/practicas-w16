package clases;

public class Cliente {

   private String nombre;
   private String apellido;
   private int dni;
   private Integer cantidadDeLocalizadores;

   public String getNombre() {
      return nombre;
   }

   public Integer getCantidadDeLocalizadores() {
      return cantidadDeLocalizadores;
   }

   public void setCantidadDeLocalizadores(Integer cantidadDeLocalizadores) {
      this.cantidadDeLocalizadores += cantidadDeLocalizadores;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApellido() {
      return apellido;
   }

   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   public int getDni() {
      return dni;
   }

   public void setDni(int dni) {
      this.dni = dni;
   }

   public Cliente(String nombre, String apellido, int dni) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.dni = dni;
      this.cantidadDeLocalizadores = 0;
   }

}
