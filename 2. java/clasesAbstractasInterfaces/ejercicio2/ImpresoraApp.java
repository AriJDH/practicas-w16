import clases.Curriculum;
import clases.Impresora;
import clases.LibroPdf;
import interfaces.Imprimible;

public class ImpresoraApp {

   public static void main(String[] args) {

      String[] habilidades = {
            "No sabe mucho de Java",
            "Pero es perseverante",
            "Le gusta mucho NVim"
      };

      Imprimible newCurriculum = new Curriculum(
            "Alejandro",
            "Rojas",
            "32000000",
            "2664700000",
            "Calle Publica",
            "151",
            "Secundaria",
            "nemesissoluciones@gmail.com",
            habilidades
      );

      Imprimible elSrDeLosAnillos = new LibroPdf(10, "J.R.R. Tolkien", "El Senor De Los Anillos", "Fantasia");

      Impresora newPrinter = new Impresora();

      newPrinter.imprimirDoc(newCurriculum);
      newPrinter.imprimirDoc(elSrDeLosAnillos);

   }

}
