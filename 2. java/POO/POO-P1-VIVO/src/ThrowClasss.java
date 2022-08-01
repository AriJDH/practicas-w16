import java.time.LocalDateTime;

public class ThrowClasss {
    private static int dividendo = 5;
    private static int divisor = 0;

    public static void main(String[] args) {
    division();
    }

    public static void division(){
        try{
          if(divisor == 0){
              throw new IllegalArgumentException("No se puede dividir por cero");
          //luego del throw que me permite largar la excepcion debe ir si so si el new y el tipo de excepcion.
          }
        }catch (IllegalArgumentException e){
            e.printStackTrace(System.out);

        }
        finally {
            LocalDateTime ldt = LocalDateTime.now();
            System.out.println("Una clase utilitaria para probar: " + ldt);
        }
    };
}
