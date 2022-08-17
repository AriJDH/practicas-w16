package ejercicioDivisionCeroExcepciones;

public class PracticaExcepciones {
    public static void main(String[] args) {

        //Ejercicio1 punto 1
        int a = 0;
        int b = 300;

        try{
            int conciente = b / a;
        }catch(ArithmeticException e) {
             System.out.println("Se ha producido un error");
         }finally {
             System.out.println("Programa finalizado");
         }

    }
}
