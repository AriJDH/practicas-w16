
public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public void cociente(){
        try{
            double division = b / a;

        }catch (ArithmeticException exception){
            System.out.println("Se ha producido un error.");
        }finally {
            System.out.println("Programa finalizado.");

        }
    }
}
