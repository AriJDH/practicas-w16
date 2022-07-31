import java.util.LinkedList;
import java.util.List;

public class PracticaExcepciones {

    public static void main(String[] args) {

        int a = 0;
        int b = 300;


       try{
            int cociente = b/a;
        }catch(ArithmeticException e){
                 System.out.println("Se ha producido un error");
        }finally{
            System.out.println("Programa finalizado");
        }

        try {
            int cociente = b/a;
        }
        catch(RuntimeException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }


}
}
