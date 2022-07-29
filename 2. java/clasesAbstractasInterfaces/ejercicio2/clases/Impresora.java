package clases;

import interfaces.Imprimible;

public class Impresora {

   public void imprimirDoc(Imprimible doc) {
      System.out.print("Imprimiendo:");
      System.out.println(doc.getNombreDocumento());
      System.out.println("----------------------------------------");
      System.out.println(doc.toString());
      System.out.println("----------------------------------------");
   }

}
