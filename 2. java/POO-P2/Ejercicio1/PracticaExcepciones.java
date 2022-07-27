package Ejercicio1;

public class PracticaExcepciones {

   public static void main(String[] args) {

      int a = 0;
      int b = 300;

      try {
         int result = b/a;
      }catch(ArithmeticException e){
         //System.out.println("Se ha produccion un error");
         throw new IllegalArgumentException("No se puede dividir por cero");
      }finally{
         System.out.println("Programa finalizado");
      }
   }

}
