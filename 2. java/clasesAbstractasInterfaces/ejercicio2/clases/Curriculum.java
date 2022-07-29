package clases;

import interfaces.Imprimible;

public class Curriculum implements Imprimible {

   private final String extension = ".doc";
   private String nombreDocumento;
   private String nombre;
   private String apellido;
   private String dni;
   private String telefono;
   private String direccion;
   private String piso;
   private String educacion;
   private String email;
   private String[] habilidades;

   public Curriculum() {
   }

   public Curriculum(
         String nombre,
         String apellido,
         String dni,
         String telefono,
         String direccion,
         String piso,
         String educacion,
         String email,
         String[] habilidades
   ) {
      this.nombreDocumento = nombre + apellido + "CV" + extension;
      this.nombre          = nombre;
      this.apellido        = apellido;
      this.dni             = dni;
      this.telefono        = telefono;
      this.direccion       = direccion;
      this.piso            = piso;
      this.educacion       = educacion;
      this.email           = email;
      this.habilidades     = habilidades;
   }

   private String habilidadesToString(String[] habilidades) {
      String returnString = "\n";
      for (int i = 0; i < habilidades.length; i++) {
         returnString = returnString + "\t * " + habilidades[i] + "\n";
      }
      return returnString;
   }

   @Override
   public String toString() {
      return "Curriculum : \n Apellido: " + apellido + "\n Nombre: " + nombre + "\n DNI: " + dni + "\n Tel: " + telefono
            + "\n Direccion: " + direccion + "\n Piso: " + piso + "\n E-mail: " + email + "\n Educacion: " + educacion
            + "\n Habilidades: " + habilidadesToString(habilidades);
   }

   @Override
   public String getNombreDocumento() {
      return nombreDocumento;
   }

}
