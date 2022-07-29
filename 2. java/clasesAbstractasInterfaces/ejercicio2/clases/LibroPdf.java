package clases;

import interfaces.Imprimible;
import statics.LoremIpsum;

public class LibroPdf implements Imprimible {

   private final String extension = ".pdf";
   private String nombreDocumento;
   private int cantidadDePaginas;
   private String nobmreAutor;
   private String titulo;
   private String genero;
   private LoremIpsum loremIpsum = new LoremIpsum();

   public LibroPdf(
         int cantidadDePaginas,
         String nobmreAutor,
         String titulo,
         String genero
   ) {
      this.cantidadDePaginas = cantidadDePaginas;
      this.nobmreAutor       = nobmreAutor;
      this.titulo            = titulo;
      this.genero            = genero;
      this.nombreDocumento   = titulo + " (" + "Por: " + nobmreAutor + " )" + extension;
   }

   @Override
   public String getNombreDocumento() {
      // TODO Auto-generated method stub
      return nombreDocumento;
   }

   private String multiplicadorLoremIpsum() {
      String returnString = "\n";
      for (int i = 0; i <= cantidadDePaginas; i++) {
         returnString = returnString + loremIpsum.getLoremIpsum() + "\n\n" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Pagina " + (i + 1) + "\n\n" ;
      }
      return returnString;
   }

   @Override
   public String toString() {
      return multiplicadorLoremIpsum();
   }


}
